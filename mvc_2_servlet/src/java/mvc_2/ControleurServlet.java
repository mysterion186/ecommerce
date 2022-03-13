/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kowsik
 */
@WebServlet(name = "ControleurServlet", urlPatterns = {"/ControleurServlet"})
public class ControleurServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArticleBean article = new ArticleBean();
        HttpSession session = request.getSession(true); 
        String origin = request.getParameter("origin");
        String login = request.getParameter("email");
        String password = request.getParameter("password");
        String connected = (String) session.getAttribute("isConnected");
        
        if (origin == null || origin.equals("index")){
            try {
                session.setAttribute("listArticle",article.getAllArticles());
                request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );
            }catch (SQLException sqle){}
        }
        else if (origin.equals("product")){
            //int produit_id = Integer.parseInt(request.getParameter("idArticle"));
            int produit_id = Integer.parseInt(request.getParameter("idArticle"));
            try {
                ArticleBean product_info = article.getProductInfo(produit_id);
                session.setAttribute("produit_info", product_info);
                //request.getRequestDispatcher( "product.jsp" ).forward( request, response );
            }catch (SQLException sqle){}
            //session.setAttribute("produit_info",produit_id);
            request.getRequestDispatcher( "product.jsp" ).forward( request, response );
        }
        else if (origin.equals("deconnexion")){
            ClientBean utilisateur = new ClientBean();
            session = request.getSession(true);
            utilisateur.setEmail((String) session.getAttribute("email"));
            utilisateur.setPassword((String) session.getAttribute("password"));
            session.setAttribute("isConnected", "no");
            utilisateur.logout();
            request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );
        }
        else if (origin.equals("panier")){ 
            /*ClientBean utilisateur = new ClientBean();
            CommandBean commande = new CommandBean();
           // session = request.getSession();
            utilisateur.setEmail(request.getParameter("email"));
            utilisateur.setPassword(request.getParameter("password"));      
            try {
                commande.setIdUser(utilisateur.getUserId());
                commande.setIdCommande(commande.checkForCurrentCommand());
                ArrayList<ArticleBean> articles = commande.getPanier();
                session.setAttribute("Panier",articles);
                request.getRequestDispatcher( "panier.jsp" ).forward( request, response );
            }catch(SQLException sqle){request.getRequestDispatcher( "buy.jsp" ).forward( request, response );}*/
            if (connected.equals("yes")){
               ClientBean user = new ClientBean();
               CommandBean commande = new CommandBean();
               user.setEmail((String) session.getAttribute("email"));
               try {
                   commande.setIdUser(user.getUserId());
                   commande.setIdCommande(commande.checkForCurrentCommand());
                   ArrayList<ArticleBean> panier = commande.getPanier();
                   session.setAttribute("Panier",panier);
                   request.getRequestDispatcher( "panier.jsp" ).forward( request, response );
               }catch(SQLException sqle ){}
     
           }
           else{
               request.getRequestDispatcher( "login.jsp" ).forward( request, response );
           }
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("email");
        String password = request.getParameter("password");
        String origin = request.getParameter("origin");
        HttpSession session = request.getSession(true);
        
        session.setAttribute("email",login);
        session.setAttribute("password",password);
        
        ClientBean utilisateur = new ClientBean();
        
        boolean exists = false; 
        if (origin.equals("login")){
            try {
                utilisateur.setEmail(login);
                utilisateur.setPassword(password);
                exists = utilisateur.isRegistered();
                if (exists){
                    utilisateur.login();
                    session.setAttribute("isConnected", "yes");
                    session.setAttribute("userId",utilisateur.getUserId());
                    session.setAttribute("email",login);
                    session.setAttribute("password",password);
                    request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );
                }
                else {
                    request.getRequestDispatcher( "inscription.jsp" ).forward( request, response );
                }
            }catch (SQLException sqle){ session.setAttribute("isConnected", "no");}
        }
        else if (origin.equals("inscription")){
            utilisateur.setLastName(request.getParameter("lastName"));
            utilisateur.setFirstName(request.getParameter("firstName"));
            utilisateur.setEmail(request.getParameter("email"));
            utilisateur.setPassword(request.getParameter("password"));
            try {
               utilisateur.registerCustomer();
               utilisateur.login();
               session.setAttribute("isConnected", "yes");
               session.setAttribute("email",login);
               session.setAttribute("password",password);
               request.getRequestDispatcher( "accueil.jsp" ).forward( request, response);
            }catch(SQLException sql){ request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );}
        }
        else if (origin.equals("panier")){
            session = request.getSession(true);
            String connected = (String) session.getAttribute("isConnected");
      
            CommandBean commande = new CommandBean();
            ClientBean user = new ClientBean();
            try {
                if (connected.equals("yes")){
                    int articleId = Integer.parseInt(request.getParameter("idArticle"));
                    commande.setIdArticle(articleId);
                    user.setEmail(request.getParameter("email"));
                    user.setPassword(request.getParameter("password"));
                    try {
                        commande.setIdUser(user.getUserId());
                        commande.addPanier();
                    }catch(SQLException sqle ){}     
                    request.getRequestDispatcher( "all_articles.jsp" ).forward( request, response );   
                }
                else{
                    request.getRequestDispatcher( "login.jsp" ).forward( request, response );
                }
            }catch(NullPointerException npe){request.getRequestDispatcher( "login.jsp" ).forward( request, response );}
        }
        
        else if (origin.equals("acheter")){
            CommandBean commande = new CommandBean();
            ClientBean user = new ClientBean();
            String connected = (String) session.getAttribute("isConnected");
            try {
                if (connected.equals("yes")){
                    user.setEmail(request.getParameter("email"));
                    user.setPassword(request.getParameter("password"));
                    try {
                        commande.setIdUser(user.getUserId());
                        commande.checkForCurrentCommand();
                        commande.buy(Integer.parseInt(request.getParameter("prix")));
                    }catch(SQLException sqle ){}     
                    request.getRequestDispatcher( "buy.jsp" ).forward( request, response );   
                }
                else{
                    request.getRequestDispatcher( "login.jsp" ).forward( request, response );
                }
            }catch(NullPointerException npe){request.getRequestDispatcher( "login.jsp" ).forward( request, response );}
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
