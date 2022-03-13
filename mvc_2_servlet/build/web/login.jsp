<%-- 
    Document   : login
    Created on : 11 févr. 2022, 21:22:16
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    <title>Document</title>
<script async src='/cdn-cgi/bm/cv/669835187/api.js'></script></head>
<body>
    <%@ include file="header.jsp" %>
    <section id="formIns">
        <div class="container">
            <div class="titre">Connexion</div>
            <!-- Formulaire pour se connecter, on redirigie l'utilisateur vers le contrôleur pour que celui s'assure de l'existence de l'utilisateur et le connecte ou bien le redirige vers la page d'inscription si ce dernier n'existe pas  -->
            <form action="ControleurServlet" method="post">
                <input type="hidden" name="origin" value="login">
                <div class="utilisateur-details">
                    <div class="input-box">
                        <span class="details">Email</span>
                        
                        <input type="text" placeholder="Entre ton adresse Email" name ="email" required>
                    </div>
                    <div class="input-box">
                        <span class="details">Mot de Passe</span>
                        <input type="text" placeholder="Entre ton mot de passe" name ="password" required >
                    </div>
                </div>
        
                <div class="button">
                    <input type="submit" value="Connexion">
                </div>
            </form>
            <a href="/mvc_2_servlet/inscription.jsp">Inscription</a>
        </div>
    </section>
    
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd606725ec3edc7',m:'mnA.1aroiCJNa2q9RPvfeAqj5DbXPEzpOK8DB.Bzhl4-1644838863-0-AV9JlLUJqw9Eh2yjmVSx5nlufzz7YCUHuY2XxOdNvJwhpsAV+GzJ8rDkMBnyZmkuYFYS6rKxggw0k7EbGFbXbQntHhou+xzhjPZ593D2YUdcorb0+6b7VFJR476TnbFzBbi/NfC36OYMvzzbc+vjHxBn0WWPIq6S6NfmTDsQmyLNtJFCzIlW7z0LC0gOtN4ZfEO+bjLbXmQlsSymcmGdYOo=',s:[0xffe644f85a,0xa0b9cb2ac0],}})();</script></body>
</html>