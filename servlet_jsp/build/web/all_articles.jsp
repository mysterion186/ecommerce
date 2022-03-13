<%-- 
    Document   : all_articles
    Created on : 14 févr. 2022, 19:46:59
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet_jsp.*"%>
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
        
           
          <!-- Le contrôleur a récupéré la liste de tous les articles présent dans notre base de données pour les mettre dans la session, on accède à cette liste avec la ligne suivante -->
         <% ArrayList<ArticleBean> list_articles = (ArrayList<ArticleBean>) request.getSession().getAttribute("listArticle");%>
         <!-- Utilisation d'une boucle for pour afficher tous les articles de notre base de données + des attributs important  comme le nom ou bien le prix des articles -->
         <% for(ArticleBean temp: list_articles){%>
         <div class="pro-container">
            <div class="pro">
                <img src="<%= temp.getPhoto_url()%>" alt="">
                <div class="des">
                    <a href = "ArticleServlet?origin=product&idArticle=<%= temp.getIdArticle()%>" ><span><%= temp.getNomArticle()%></span></a>
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
                <!-- Formulaire pour ajouter un article dans notre panier, on envoie ce formulaire au contrôleur pour qu'il fasse les tests comme si l'utilisateur est connecté ou pas avatn d'ajouter l'article dans son panier-->
                <form action="PanierServlet" method="post">
                <input type="hidden" name="idArticle" value="<%= temp.getIdArticle()%>">
                <input type="hidden" name="idUser" value='${"userId"}'>
                <input type="hidden" name="origin" value='panier'>
                <button><a href="#"><i class="fal fa-shopping-cart cart"></i></a></button>
            </form  
            </div>    
        </div>
        <% } %>
    </section>
 
    </body>
</html>