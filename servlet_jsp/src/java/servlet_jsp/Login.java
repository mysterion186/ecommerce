/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.UnavailableException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet_jsp.ClientBean; 

/**
 *
 * @author kowsik
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

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
            throws ServletException, IOException,SQLException, SQLException {
   
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
        ClientBean utilisateur = new ClientBean();
        HttpSession session = request.getSession(true);
        utilisateur.setEmail((String) session.getAttribute("email"));
        utilisateur.setPassword((String) session.getAttribute("password"));
        session.setAttribute("isConnected", "no");
        utilisateur.logout();
        request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );
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
        /*try {
            processRequest(request, response);
        }catch(SQLException sqle){};*/
        
        
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
               request.getRequestDispatcher( "accueil.jsp" ).forward( request, response);
            }catch(SQLException sql){ request.getRequestDispatcher( "accueil.jsp" ).forward( request, response );}
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
