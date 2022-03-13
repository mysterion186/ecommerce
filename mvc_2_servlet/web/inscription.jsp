<%-- 
    Document   : inscription
    Created on : 11 févr. 2022, 22:34:11
    Author     : kowsik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <section id="formIns">
        <div class="container">
            <div class="titre">Inscription</div>
            <!-- Formulaire pour s'inscrire, on redirige l'utilisateur vers le contrôleur pour qu'il s'assure de l'enregistrement de l'utilisateur dans la base de données-->
            <form action="ControleurServlet" method='post'>
                <input type="hidden" name="origin" value="inscription" >
                <div class="utilisateur-details">
                    <div class="input-box">
                        <span class="details">Nom</span>
                        <input type="text" placeholder="Entre ton Nom" name = "lastName" required >
                    </div>
                    <div class="input-box">
                        <span class="details">Prénom</span>
                        <input type="text" placeholder="Entre ton Prénom" name="firstName" required > 
                    </div>
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="text" placeholder="Entre ton adresse Email" name="email" required >
                    </div>
             
                    <div class="input-box">
                        <span class="details">Mot de Passe</span>
                        <input type="text" placeholder="Entre ton mot de passe" name = "password" required >
                    </div>
                    
                </div>
                <div class="button">
                    <input type="submit" value="Inscription">
                </div>
                
            </form>
        </div>
    </section>
<script type="text/javascript">(function(){window['__CF$cv$params']={r:'6dd605b53841edc7',m:'MYxWRjjtoya2jxYw8K4qEljYK73ItLxGkzVIpI.Jo0U-1644838833-0-AaDYA0HGapZ8cH4s27nGawR3gOyyBkQSpk1By04XwWslDzBm+IqyqM47TS3m9QLFH0eCP174td3/moFejb94rrMAXqOju6kOWoKPWm70S02P0ljOJLUoHtOzIyoK3TDMXrpqmmVjBQO8RLlnLzA+gcbJpulI2uyVF0gyGairdoEXE+hGx4DMKKgvdebtsUO0FrcHYTgap0qx+EhB1npeKhw=',s:[0x2900a90da7,0x310089902b],}})();</script></body>
</html>