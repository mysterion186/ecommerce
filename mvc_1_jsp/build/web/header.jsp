<%-- 
    Document   : header.jsp
    Created on : 14 févr. 2022, 17:04:18
    Author     : kowsik
--%>
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
<header>
    <section id="header">
        <jsp:useBean id="ClientBean" scope = "session" class="mvc_1.ClientBean"/>
        <a href="#"><img src="img/logox.png" class ="logo" alt=""></a>
        <div>
            <ul id = "navbar">
                <li><a class="active" href="/mvc_1_jsp/index.jsp">Home</a></li>
                <li><a href="/mvc_1_jsp/all_articles.jsp">Shop</a></li>
                <li><a href="/mvc_1_jsp/blog.jsp">À propos de moi</a></li>
                <li><a href="/mvc_1_jsp/blog.jsp">Blog</a></li>
                <!-- Test pour avoir si l'utilisateur est connecté -->
                <% if (ClientBean.getRegistered()){%> 
                    <li><a href="/mvc_1_jsp/panier.jsp"><i class="far fa-shopping-bag"></i></a></li>
                    <li><a href="/mvc_1_jsp/logout.jsp">Déconnexion></i></a></li>
                <!-- Si l'utilisateur n'est pas connecté on lui propose de se connecter -->
                <% }else{ %>
                    <li><a href="/mvc_1_jsp/login.jsp">Connectez-vous !</a></li>          
                <% } %>
            </ul>
            <h2>Comme nous vendons des montres de luxe et que les quantités sont limitées, nous ne pourrez acheter qu'un article par commande. Nous nous excusons pour la gêne occasionnée</h2>
        </div>



    </section>
</header>