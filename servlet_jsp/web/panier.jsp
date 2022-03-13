<%-- 
    Document   : panier
    Created on : 11 févr. 2022, 21:21:11
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
        
        <p>Votre panier</p>
           
        <!-- La servlet ArticleServlet a récupéré la liste de tous les articles présent dans notre base de données pour les mettre dans la session, on accède à cette liste avec la ligne suivante -->
         <% ArrayList<ArticleBean> list_articles = (ArrayList<ArticleBean>) request.getSession().getAttribute("Panier");int Total = 0;%>>
         <!-- Utilisation d'une boucle for pour afficher tous les articles de notre base de données + des attributs important  comme le nom ou bien le prix des articles -->
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
        
        <form action='PanierServlet?origin=acheter' method="post">
            <input type="hidden" name="prix" value="<%=Total%>" >  
            <input type="hidden" name="origin" value="acheter" >  
            <input type="hidden" name="email" value="${email}" >  
            <input type="hidden" name="password" value="${password}" >  
            <input type="hidden" name="userId" value="${userId}" >  
            <div class="button">
                    <input type="submit" value="Acheter">
            </div>
        </form>
        
    </section>
 
    </body>
</html>
