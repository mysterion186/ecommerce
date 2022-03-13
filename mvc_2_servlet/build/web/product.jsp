<%-- 
    Document   : product
    Created on : 14 févr. 2022, 22:27:58
    Author     : kowsik
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<%@ page import="mvc_2.*"%>
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
    <jsp:useBean id="ArticleBean" scope = "session" class="mvc_2.ArticleBean"/>
    
   <!-- Le contrôleur sait sur quel produit l'utilisateut àa cliqué, et il a mis les informations sur ce produit dans la session, on y accède donc avec la ligne suivante-->
    <% 
        ArticleBean produit = (ArticleBean) request.getSession().getAttribute("produit_info");
    %>
    <section id="prodetails" class="section-p1">
        <div class="single-pro-image">
            <img src="<%= produit.getPhoto_url()%>" widht="100%" id="MainImg" alt="">
            </div>
      
        <div class="single-pro-details">
            <h6><%= produit.getCategorie() %></h6>
            <h4><%= produit.getNomArticle() %></h4>
            <h2><%= produit.getPrix() %></h2>
            <!-- Formulaire pour ajouter des articles aux panier, le contrôleur va vérifier si l'utilisateur est connecté et si oui on ajoute l'article dans le panier sinon on le redirige vers la page connexion -->
            <form action="ControleurServlet" method="post">
                <input type="hidden" name="idArticle" value="<%= produit.getIdArticle()%>">
                <input type="hidden" name="origin" value='panier'>
                <input type="hidden" name="email" value="${email}" >  
                <input type="hidden" name="password" value="${password}" >  
                <input type="hidden" name="userId" value="${userId}" >
                 <div class="button">
                    <input type="submit" value="Acheter">
                </div>
            </form>
            
            <h4>Produit détail</h4>
            <span><%= produit.getDescription() %>.
            </span>
        </div>
    </section>

    
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd60603480aedc7',m:'mXInN9AkDPjyMyGhRLCZAfudS.YjGA_1HSikaC3V7Xs-1644838846-0-AYm9nwKvgiXHgVYwg0QfFy3zZEhRE/4Wo6f3veDVL8gNCZgbUACvixLYgWy4LcqKUaiBrcNEgm4iNCSu84XYrnG4+ocW1ufCsUQv4e2L8o2p6F83MMVM/geO/xp0zp2GEaD7jvOyTKt9kabB743iS0f3HUNW+/twD1CSc4sVDf6vYFh63Pelf4yrzLfK3pK2kg==',s:[0x104d29641f,0x54d6b7ccb7],}})();</script></body>
</html>