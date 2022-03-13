<%-- 
    Document   : product
    Created on : 14 févr. 2022, 22:27:58
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
    <!-- "Import" la bean ArticleBean pour avoir les infos sur les articles -->
    <jsp:useBean id="ArticleBean" scope = "session" class="mvc_1.ArticleBean"/>
    
   <!-- On retrouve les données d'un artcle dans notre base de données avec l'identifiant de cet article -->
    <% int articleId = Integer.parseInt(request.getParameter("productID"));
    ArticleBean produit = ArticleBean.getProductInfo(articleId);
    %>
    <section id="prodetails" class="section-p1">
        <div class="single-pro-image">
            <img src="<%= produit.getPhoto_url()%>" widht="100%" id="MainImg" alt="">
            </div>
      
        <div class="single-pro-details">
            <h6><%= produit.getCategorie() %></h6>
            <h4><%= produit.getNomArticle() %></h4>
            <h2><%= produit.getPrix() %></h2>
            <form action="processpanier.jsp" method="post">
                <input type="hidden" name="idArticle" value="<%= produit.getIdArticle()%>">
                <input type="hidden" name="idUser" value="<%= ClientBean.getUserId()%>">
                <button>Ajouter au panier</button>
            </form>
            
            <h4>Produit détail</h4>
            <span><%= produit.getDescription() %>.
            </span>
        </div>
    </section>

    
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd60603480aedc7',m:'mXInN9AkDPjyMyGhRLCZAfudS.YjGA_1HSikaC3V7Xs-1644838846-0-AYm9nwKvgiXHgVYwg0QfFy3zZEhRE/4Wo6f3veDVL8gNCZgbUACvixLYgWy4LcqKUaiBrcNEgm4iNCSu84XYrnG4+ocW1ufCsUQv4e2L8o2p6F83MMVM/geO/xp0zp2GEaD7jvOyTKt9kabB743iS0f3HUNW+/twD1CSc4sVDf6vYFh63Pelf4yrzLfK3pK2kg==',s:[0x104d29641f,0x54d6b7ccb7],}})();</script></body>
</html>