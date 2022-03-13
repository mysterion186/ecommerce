<%-- 
    Document   : all_articles
    Created on : 14 févr. 2022, 19:46:59
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="mvc_1.*"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    </head>
    <body>
        <%@ include file="header.jsp" %> 
        <section id="product1" class="section-p1">
        
        <p>Toute nos montres</p>
        <!-- "Import" de la bean ArticleBean -->
        <jsp:useBean id="ArticleBean" scope = "session" class="mvc_1.ArticleBean"/>
         
        <!-- Utilisation de la méthode getAllArticles() pour obtenir tous les articles de la base de données -->
         <% ArrayList<ArticleBean> list_articles = ArticleBean.getAllArticles();%>
         <!-- Utilisation d'une boucle for pour afficher les produits qui se trouvent dans la base de données + des attributs de la classe ARticleBean pour remplir des informations comme le nom ou le prix du produit -->
         <% for(ArticleBean temp: list_articles){%>
         <div class="pro-container">
            <div class="pro">
                <img src="<%= temp.getPhoto_url()%>" alt="">
                <div class="des">
                    <!-- Lien pour avoir plus d'information sur le produit en question -->
                    <a href = "product.jsp?productID=<%=temp.getIdArticle() %>" ><span><%= temp.getNomArticle()%></span></a>
                    <h5><%= temp.getDescription()%></h5>
                    <h6><%= temp.getCategorie()%></h6>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4><%=temp.getPrix() %>€</h4>
                </div>
            </div>    
        </div>
        <% } %>
    </section>
 
    </body>
</html>
