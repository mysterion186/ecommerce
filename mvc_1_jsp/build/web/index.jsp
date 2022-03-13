<%-- 
    Document   : index.jsp
    Created on : 11 févr. 2022, 10:06:23
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<%@ page import="mvc_1.*"%>
<%@ page import="java.util.ArrayList"%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    <title>Document</title>
<script async src='/cdn-cgi/bm/cv/669835187/api.js'></script></head>
<body>
    <%@ include file="header.jsp" %> 
    <section id="hero">
       
        <h4>Achetez Simplement</h4>
        <h2>Plus de 4000 pièces de Luxe</h2>
        <h1>En quelque cliques</h1>
        <p>Sofiane is super straight</p>
        <button>Achetez Maintenant</button>

    </section>
    <section id="product1" class="section-p1">
        
        <p>Toute nos montres</p>
        <!-- "Import" de la bean ArticleBean -->
           <jsp:useBean id="ArticleBean" scope = "session" class="mvc_1.ArticleBean"/>
        <!-- on récupére la liste de tous les articles présents dans notre base de données --> 
         <% ArrayList<ArticleBean> list_articles = ArticleBean.getAllArticles();%>
         <!-- Utilisation d'une boucle for pour afficher les articles + utilisattion des attributs de la classe ArticleBean pour avoir des informations supplémentaires comme le nom de l'article ou bien le prix -->
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
                </div>
                <form action="processpanier.jsp" method="post">
                <input type="hidden" name="idArticle" value="<%= temp.getIdArticle()%>">
                <input type="hidden" name="idUser" value="<%= ClientBean.getUserId()%>">
                <button><a href="#"><i class="fal fa-shopping-cart cart"></i></a></button>
            </form
                
            </div>    
        </div>
        <% } %>
    </section>
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd565970cbf082c',m:'K1j2Fgx.0dC5AyCHeMrGmTcqITzs8TaIEgZNq7wx4uM-1644832275-0-ASdra/xwySUHeakHnr7TQvXGTARtl9RgvSd0yAlRRX4j9E8qqyLRzTlaOKvfbAPAFNZcqGZxIBSZnn3AHc0JYnEhEQRMjPtRuv+iugAKxrZlFe03XAeYunqZx/+FccE8uEkqtE09Zbb8QPScfUUbKxn/CJWgV+5DVGADnwaoMpmfi2ATptv6/5CMkcdTTu2x9A==',s:[0x67cdf8c6c2,0x783fff509f],}})();</script></body>
</html>