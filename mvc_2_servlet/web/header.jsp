<%-- 
    Document   : header.jsp
    Created on : 14 févr. 2022, 17:04:18
    Author     : kowsik
--%>
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
<header>
    <section id="header">
        <a href="#"><img src="img/logox.png" class ="logo" alt=""></a>
        <div>
            <ul id = "navbar">
                <li><a class="active" href="/mvc_2_jsp/index.jsp">Home</a></li>
                <li><a href="/mvc_2_servlet/all_articles.jsp">Shop</a></li>
                <li><a href="/mvc_2_servlet/blog.jsp">À propos de moi</a></li>
                <li><a href="/mvc_2_servlet/blog.jsp">Blog</a></li>
                <!-- Le contrôleur a mis dans la session l'information de si l'utilisateur est connecté ou non, selon la valeur on décide d'afficher un bouton de connexion ou bien de déconnexion + un panier-->
                <% String result = (String) request.getSession().getAttribute("isConnected"); %>
                <% if (result=="yes"){%> 
                    <li><a href="ControleurServlet?origin=panier"><i class="far fa-shopping-bag"></i></a></li>
                    <li><a href="ControleurServlet?origin=deconnexion">Déconnexion></i></a></li>
                <% }else{ %>
                    <li><a href="/mvc_2_servlet/login.jsp">Connectez-vous !</a></li>          
                <% } %>
            </ul>
            <h2>Comme nous vendons des montres de luxe et que les quantités sont limitées, nous ne pourrez acheter qu'un article par commande. Nous nous excusons pour la gêne occasionnée</h2>
        </div>



    </section>
</header>