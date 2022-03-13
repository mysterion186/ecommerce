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

<!DOCTYPE html>
<html lang="en">


<head>
    <%@ include file="header.jsp" %> 
    <!-- On redirige l'utilisateur vers la servlet pour qu'il récupère l'ensemble des articles se trouvant dans notre base de données pour ensuite les afficher dans le fichier accueil.jsp -->
    <jsp:forward page="ControleurServlet"/>
 </html>