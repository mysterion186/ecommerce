<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">


<head>
    <%@ include file="header.jsp" %> 
    <!-- On redirige l'utilisateur vers la servlet pour qu'il récupère l'ensemble des articles se trouvant dans notre base de données pour ensuite les afficher dans le fichier accueil.jsp -->
    <jsp:forward page="ArticleServlet"/>
 </html>