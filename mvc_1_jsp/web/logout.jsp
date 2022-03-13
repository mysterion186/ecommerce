<%-- 
    Document   : logout
    Created on : 14 févr. 2022, 18:11:18
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
        <!-- "Import" de la bean ClientBean  -->
        <jsp:useBean id="ClientBean" scope = "session" class="mvc_1.ClientBean"/>
        <!-- Déconnexion de l'utilisateur -->
        <% ClientBean.logout();%>
        <jsp:forward page="index.jsp" />
</html>

