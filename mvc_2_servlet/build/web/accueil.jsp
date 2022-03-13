<%-- 
    Document   : index
    Created on : 18 févr. 2022, 09:39:09
    Author     : kowsik
--%>

<%-- 
    Document   : index.jsp
    Created on : 11 févr. 2022, 10:06:23
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="mvc_2.ArticleBean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">


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
     
           <!-- Le contrôleur a récupéré la liste de tous les articles présent dans notre base de données pour les mettre dans la session, on accède à cette liste avec la ligne suivante -->
        <% ArrayList<ArticleBean> list_articles = (ArrayList<ArticleBean>) request.getSession().getAttribute("listArticle");%>
         <!-- Utilisation d'une boucle for pour afficher tous les articles de notre base de données + des attributs important  comme le nom ou bien le prix des articles -->
           <% for(ArticleBean temp: list_articles){%>
         <div class="pro-container">
            <div class="pro">
                <img src="<%= temp.getPhoto_url()%>" alt="">
                <div class="des">
                    <a href = "ControleurServlet?origin=product&idArticle=<%= temp.getIdArticle()%>" ><span><%= temp.getNomArticle()%></span></a>
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
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd565970cbf082c',m:'K1j2Fgx.0dC5AyCHeMrGmTcqITzs8TaIEgZNq7wx4uM-1644832275-0-ASdra/xwySUHeakHnr7TQvXGTARtl9RgvSd0yAlRRX4j9E8qqyLRzTlaOKvfbAPAFNZcqGZxIBSZnn3AHc0JYnEhEQRMjPtRuv+iugAKxrZlFe03XAeYunqZx/+FccE8uEkqtE09Zbb8QPScfUUbKxn/CJWgV+5DVGADnwaoMpmfi2ATptv6/5CMkcdTTu2x9A==',s:[0x67cdf8c6c2,0x783fff509f],}})();</script></body>
</html>