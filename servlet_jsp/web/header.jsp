<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
<header>
    <section id="header">
        <a href="#"><img src="img/logox.png" class ="logo" alt=""></a>
        <div>
            <ul id = "navbar">
                <li><a class="active" href="/servlet_jsp/index.jsp">Home</a></li>
                <li><a href="/servlet_jsp/all_articles.jsp">Shop</a></li>
                <li><a href="/servlet_jsp/blog.jsp">� propos de moi</a></li>
                <li><a href="/servlet_jsp/blog.jsp">Blog</a></li>
                <!-- Le contr�leur a mis dans la session l'information de si l'utilisateur est connect� ou non, selon la valeur on d�cide d'afficher un bouton de connexion ou bien de d�connexion + un panier-->
                <% String result = (String) request.getSession().getAttribute("isConnected"); %>           
                <% if (result=="yes"){%> 
                    <li><a href="PanierServlet?origin=panier"><i class="far fa-shopping-bag"></i></a></li>
                    <li><a href="Login?origin=deconnexion">D�connexion></i></a></li>
                <% }else{ %>
                    <li><a href="/servlet_jsp/login.jsp">Connectez-vous !</a></li>          
                <% } %>
            </ul>
            <h2>Comme nous vendons des montres de luxe et que les quantit�s sont limit�es, nous ne pourrez acheter qu'un article par commande. Nous nous excusons pour la g�ne occasionn�e</h2>
        </div>
    </section>
</header>