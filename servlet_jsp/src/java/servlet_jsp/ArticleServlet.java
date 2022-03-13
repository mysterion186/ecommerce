/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_jsp;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ArticleServlet", urlPatterns = {"/ArticleServlet"})
public class ArticleServlet extends HttpServlet {

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
