package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\n");
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
      out.write("                ");
 if (ClientBean.getRegistered()){
      out.write(" \n");
      out.write("                    <li><a href=\"/mvc_1_jsp/panier.jsp\"><i class=\"far fa-shopping-bag\"></i></a></li>\n");
      out.write("                    <li><a href=\"/mvc_1_jsp/logout.jsp\">Déconnexion></i></a></li>\n");
      out.write("                ");
 }else{ 
      out.write("\n");
      out.write("                    <li><a href=\"/mvc_1_jsp/login.jsp\">Connectez-vous !</a></li>          \n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </section>\n");
      out.write("</header>");
      out.write("\n");
      out.write("    <section id=\"formIns\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"titre\">Connexion</div>\n");
      out.write("            <form action=\"display.jsp\" method='post'>\n");
      out.write("                <div class=\"utilisateur-details\">\n");
      out.write("                    <div class=\"input-box\">\n");
      out.write("                        <span class=\"details\">Email</span>\n");
      out.write("                        <input type=\"text\" placeholder=\"Entre ton adresse Email\" name = \"email\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-box\">\n");
      out.write("                        <span class=\"details\">Mot de Passe</span>\n");
      out.write("                        <input type=\"text\" placeholder=\"Entre ton mot de passe\" name =\"password\" required >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("        \n");
      out.write("                <div class=\"button\">\n");
      out.write("                    <input type=\"submit\" value=\"Connexion\">\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    \n");
      out.write("<script type=\"text/javascript\">(function(){window['__CF$cv$params']={r:'6dd606725ec3edc7',m:'mnA.1aroiCJNa2q9RPvfeAqj5DbXPEzpOK8DB.Bzhl4-1644838863-0-AV9JlLUJqw9Eh2yjmVSx5nlufzz7YCUHuY2XxOdNvJwhpsAV+GzJ8rDkMBnyZmkuYFYS6rKxggw0k7EbGFbXbQntHhou+xzhjPZ593D2YUdcorb0+6b7VFJR476TnbFzBbi/NfC36OYMvzzbc+vjHxBn0WWPIq6S6NfmTDsQmyLNtJFCzIlW7z0LC0gOtN4ZfEO+bjLbXmQlsSymcmGdYOo=',s:[0xffe644f85a,0xa0b9cb2ac0],}})();</script></body>\n");
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
