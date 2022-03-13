<%-- 
    Document   : buy
    Created on : 16 févr. 2022, 11:21:26
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
    <!--"Import" de la bean CommandBean  -->
    <jsp:useBean id="CommandBean" scope = "session" class="mvc_1.CommandBean"/>
    <!-- On récuperre le prix total de la commande -->
     <% int Prix = Integer.parseInt(request.getParameter("prix")); %>
     <!-- On fait appel à la méthode buy du CommandBean pour valider le panier de l'utilisateur (et donc le vider pour ses prochaines commandes) -->
     <% CommandBean.buy(Prix); %>
     <h1> Merci pour votre achat !</h1>
</html>
