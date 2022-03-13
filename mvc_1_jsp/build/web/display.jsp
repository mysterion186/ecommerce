<%-- 
    Document   : display
    Created on : 11 févr. 2022, 21:53:22
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
        <!-- "Import" du bean ClientBean -->
        <jsp:useBean id="ClientBean" scope = "session" class="mvc_1.ClientBean"/>
        <!-- On remplit les informations de la bean avec les différents champs du formulaire -->
        <jsp:setProperty name="ClientBean" property="*"/>
        <!-- On utilise la méthode isRegistered de la bean ClientBean pour voir si l'utilisateur existe, si c'est le cas on le connecte (méthode login) et on le redirige vers la page d'accueil-->
        <% if (ClientBean.isRegistered()){%> 
            <% ClientBean.login(); %>
            <jsp:forward page="index.jsp" />
            <!-- Si  l'utilisateur est inconnu on le redirige vers la page d'inscription -->
        <% }else{ %>
            <% String s = request.getParameter("origin"); %>
            <% if (s==null || s.isEmpty()) { %> 
                <jsp:forward page="inscription.jsp" />
                <% } else { %>
                <% ClientBean.registerCustomer(); %>
                <jsp:forward page="index.jsp" />
            <% } %>
        <% } %> 
    </body>
</html>
