package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import mvc_1.*;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"/>\n");
      out.write("    <title>Document</title>\n");
      out.write("<script async src='/cdn-cgi/bm/cv/669835187/api.js'></script></head>\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"style/style.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"/>\n");
      out.write("<header>\n");
      out.write("    <section id=\"header\">\n");
      out.write("        ");
      mvc_1.ClientBean ClientBean = null;
      synchronized (session) {
        ClientBean = (mvc_1.ClientBean) _jspx_page_context.getAttribute("ClientBean", PageContext.SESSION_SCOPE);
        if (ClientBean == null){
          ClientBean = new mvc_1.ClientBean();
          _jspx_page_context.setAttribute("ClientBean", ClientBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <a href=\"#\"><img src=\"img/logox.png\" class =\"logo\" alt=\"\"></a>\n");
      out.write("        <div>\n");
      out.write("            <ul id = \"navbar\">\n");
      out.write("                <li><a class=\"active\" href=\"/mvc_1_jsp/index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"/mvc_1_jsp/all_articles.jsp\">Shop</a></li>\n");
      out.write("                <li><a href=\"/mvc_1_jsp/blog.jsp\">À propos de moi</a></li>\n");
      out.write("                <li><a href=\"/mvc_1_jsp/blog.jsp\">Blog</a></li>\n");
      out.write("                <!-- Test pour avoir si l'utilisateur est connecté -->\n");
      out.write("                ");
 if (ClientBean.getRegistered()){
      out.write(" \n");
      out.write("                    <li><a href=\"/mvc_1_jsp/panier.jsp\"><i class=\"far fa-shopping-bag\"></i></a></li>\n");
      out.write("                    <li><a href=\"/mvc_1_jsp/logout.jsp\">Déconnexion></i></a></li>\n");
      out.write("                <!-- Si l'utilisateur n'est pas connecté on lui propose de se connecter -->\n");
      out.write("                ");
 }else{ 
      out.write("\n");
      out.write("                    <li><a href=\"/mvc_1_jsp/login.jsp\">Connectez-vous !</a></li>          \n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <h2>Comme nous vendons des montres de luxe et que les quantités sont limitées, nous ne pourrez acheter qu'un article par commande. Nous nous excusons pour la gêne occasionnée</h2>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("</header>");
      out.write(" \n");
      out.write("    <section id=\"hero\">\n");
      out.write("       \n");
      out.write("        <h4>Achetez Simplement</h4>\n");
      out.write("        <h2>Plus de 4000 pièces de Luxe</h2>\n");
      out.write("        <h1>En quelque cliques</h1>\n");
      out.write("        <p>Sofiane is super straight</p>\n");
      out.write("        <button>Achetez Maintenant</button>\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("    <section id=\"product1\" class=\"section-p1\">\n");
      out.write("        \n");
      out.write("        <p>Toute nos montres</p>\n");
      out.write("        <!-- \"Import\" de la bean ArticleBean -->\n");
      out.write("           ");
      mvc_1.ArticleBean ArticleBean = null;
      synchronized (session) {
        ArticleBean = (mvc_1.ArticleBean) _jspx_page_context.getAttribute("ArticleBean", PageContext.SESSION_SCOPE);
        if (ArticleBean == null){
          ArticleBean = new mvc_1.ArticleBean();
          _jspx_page_context.setAttribute("ArticleBean", ArticleBean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <!-- on récupére la liste de tous les articles présents dans notre base de données --> \n");
      out.write("         ");
 ArrayList<ArticleBean> list_articles = ArticleBean.getAllArticles();
      out.write("\n");
      out.write("         <!-- Utilisation d'une boucle for pour afficher les articles + utilisattion des attributs de la classe ArticleBean pour avoir des informations supplémentaires comme le nom de l'article ou bien le prix -->\n");
      out.write("         ");
 for(ArticleBean temp: list_articles){
      out.write("\n");
      out.write("         <div class=\"pro-container\">\n");
      out.write("            <div class=\"pro\">\n");
      out.write("                <img src=\"");
      out.print( temp.getPhoto_url());
      out.write("\" alt=\"\">\n");
      out.write("                <div class=\"des\">\n");
      out.write("                    <a href = \"product.jsp?productID=");
      out.print(temp.getIdArticle() );
      out.write("\" ><span>");
      out.print( temp.getNomArticle());
      out.write("</span></a>\n");
      out.write("                    <h5>");
      out.print( temp.getDescription());
      out.write("</h5>\n");
      out.write("                    <h6>");
      out.print( temp.getCategorie());
      out.write("</h6>\n");
      out.write("                    <div class=\"star\">\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                        <i class=\"fas fa-star\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <h4>");
      out.print(temp.getPrix() );
      out.write("€</h4>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"processpanier.jsp\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"idArticle\" value=\"");
      out.print( temp.getIdArticle());
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"idUser\" value=\"");
      out.print( ClientBean.getUserId());
      out.write("\">\n");
      out.write("                <button><a href=\"#\"><i class=\"fal fa-shopping-cart cart\"></i></a></button>\n");
      out.write("            </form\n");
      out.write("                \n");
      out.write("            </div>    \n");
      out.write("        </div>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </section>\n");
      out.write("<script type=\"text/javascript\">(function(){window['__CF$cv$params']={r:'6dd565970cbf082c',m:'K1j2Fgx.0dC5AyCHeMrGmTcqITzs8TaIEgZNq7wx4uM-1644832275-0-ASdra/xwySUHeakHnr7TQvXGTARtl9RgvSd0yAlRRX4j9E8qqyLRzTlaOKvfbAPAFNZcqGZxIBSZnn3AHc0JYnEhEQRMjPtRuv+iugAKxrZlFe03XAeYunqZx/+FccE8uEkqtE09Zbb8QPScfUUbKxn/CJWgV+5DVGADnwaoMpmfi2ATptv6/5CMkcdTTu2x9A==',s:[0x67cdf8c6c2,0x783fff509f],}})();</script></body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
