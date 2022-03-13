<%-- 
    Document   : processpanier
    Created on : 16 févr. 2022, 12:28:19
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="mvc_1.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- "Import" des beans ClientBean,CommandBean -->
        <!-- On remplit les différents informations de chacun des beans -->
        <jsp:useBean id="ClientBean" scope = "session" class="mvc_1.ClientBean"/>
        <jsp:setProperty name="ClientBean" property="*"/>
        <jsp:useBean id="CommandBean" scope = "session" class="mvc_1.CommandBean"/>
        <jsp:setProperty name="CommandBean" property="*"/>
        <!-- Lorsqu'un utilisateur a appuyé sur ajouter au panier et quq'il est connecté on ajoute l'article à son panier et le redirige vers la page avec tous les articles -->
        <% if (ClientBean.isRegistered()){%> 
            <% CommandBean.addPanier(); %>
            <jsp:forward page="all_articles.jsp" />
        <!-- Sinon on le redirige vers la page de connexion -->
        <% }else{ %>
            <jsp:forward page="login.jsp" />
            
        <% } %> 
    </body>
</html
