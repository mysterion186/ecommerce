<%-- 
    Document   : panier
    Created on : 11 févr. 2022, 21:21:11
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
        
        <p>Votre panier</p>
        <!-- "Import" des beans CommandBean et ArticleBean-->
           <jsp:useBean id="CommandBean" scope = "session" class="mvc_1.CommandBean"/>
           
           <jsp:useBean id="ArticleBean" scope = "session" class="mvc_1.ArticleBean"/>
           <!--On remplit les informations de la bean avec les informations sur le client -->
           <jsp:setProperty name="CommandBean" property="idUser" value="<%= ClientBean.getUserId()%>" />
           <jsp:setProperty name="CommandBean" property="idCommande" value="<%= CommandBean.checkForCurrentCommand() %>" />
          <!-- On cherche à obtenir l'ensemble des articles qui sont dans le panier en cours de l'utilisateur connecté  -->
         <% ArrayList<ArticleBean> list_articles = CommandBean.getPanier(); int Total = 0;%>
         <!-- Boucle for pour afficher les articles qui se trouvent dans la panier -->
         <% for(ArticleBean temp: list_articles){%>
         <div class="pro-container">
            <div class="pro">
                <img src="<%= temp.getPhoto_url()%>" alt="">
                <div class="des">
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
                    <% Total += temp.getPrix() ;%>
                </div>
            </div>    
        </div>
        <% } %>
        <h1>Prix total : <%= Total %> € </h1>
        <!-- Formulaire qui a pour but de valider la commande de l'utilisateur, le redirige vers la page buy.jsp-->
        <form action='buy.jsp' method="post">
            <input type="hidden" name="prix" value="<%=Total%>" >  
            <div class="button">
                    <input type="submit" value="Acheter">
            </div>
        </form>
        
    </section>
 
    </body>
</html>
