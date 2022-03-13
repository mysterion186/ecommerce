/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_jsp;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kowsik
 */
@WebServlet(name = "PanierServlet", urlPatterns = {"/PanierServlet"})
public class PanierServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
       String connected = (String) session.getAttribute("isConnected");
      
       CommandBean commande = new CommandBean();
       ClientBean user = new ClientBean();
       String origin = request.getParameter("origin");
       if (origin == null || origin.equals("index")){
           try {
           if (connected.equals("yes")){
           int articleId = Integer.parseInt(request.getParameter("idArticle"));
           commande.setIdArticle(articleId);
           user.setEmail((String) session.getAttribute("email"));
           try {
               commande.setIdUser(user.getUserId());
           }catch(SQLException sqle ){}
           
           try {
               commande.getPanier();
           }catch(SQLException sqle){}
           request.getRequestDispatcher( "panier.jsp" ).forward( request, response );   
           }
           else{
               request.getRequestDispatcher( "login.jsp" ).forward( request, response );
           }
       }catch(NullPointerException npe){request.getRequestDispatcher( "login.jsp" ).forward( request, response );}
       }
       else if (origin.equals("panier")) {
           if (connected.equals("yes")){
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
        
       HttpSession session = request.getSession(true);
       String connected = (String) session.getAttribute("isConnected");
      
       CommandBean commande = new CommandBean();
       ClientBean user = new ClientBean();
       String origin = request.getParameter("origin");
       if (origin == null || origin.equals("panier")){
           try {
           if (connected.equals("yes")){
           int articleId = Integer.parseInt(request.getParameter("idArticle"));
           commande.setIdArticle(articleId);
           user.setEmail((String) session.getAttribute("email"));
           try {
               commande.setIdUser(user.getUserId());
               commande.addPanier();
               request.getRequestDispatcher( "all_articles.jsp" ).forward( request, response ); 
           }catch(SQLException sqle ){}            
           }
           else{
               request.getRequestDispatcher( "login.jsp" ).forward( request, response );
           }
       }catch(NullPointerException npe){request.getRequestDispatcher( "login.jsp" ).forward( request, response );}
       }
       else if (origin.equals("acheter")){
           int prix = Integer.parseInt(request.getParameter("prix"));
           user.setEmail(request.getParameter("email"));
           user.setPassword(request.getParameter("password"));
           try {
               commande.setIdUser(user.getUserId());
               commande.setIdCommande(commande.checkForCurrentCommand());
               commande.buy(prix);
               request.getRequestDispatcher( "buy.jsp" ).forward( request, response );
           }catch(SQLException sqle) {}
           
       }
       
       
       /*else if (connected == null){
           request.getRequestDispatcher( "temp.jsp" ).forward( request, response );
       }*/
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
