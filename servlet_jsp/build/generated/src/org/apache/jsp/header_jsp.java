package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
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
      out.write("<link rel=\"stylesheet\" href=\"style/style.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://pro.fontawesome.com/releases/v5.10.0/css/all.css\"/>\n");
      out.write("<header>\n");
      out.write("    <section id=\"header\">\n");
      out.write("        <a href=\"#\"><img src=\"img/logox.png\" class =\"logo\" alt=\"\"></a>\n");
      out.write("        <div>\n");
      out.write("            <ul id = \"navbar\">\n");
      out.write("                <li><a class=\"active\" href=\"/mvc_1_jsp/index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"/mvc_2_servlet/all_articles.jsp\">Shop</a></li>\n");
      out.write("                <li><a href=\"/mvc_2_servlet/blog.jsp\">À propos de moi</a></li>\n");
      out.write("                <li><a href=\"/mvc_2_servlet/blog.jsp\">Blog</a></li>\n");
      out.write("                ");
 String result = (String) request.getSession().getAttribute("isConnected"); 
      out.write("\n");
      out.write("                ");
 if (result=="yes"){
      out.write(" \n");
      out.write("                    <li><a href=\"ControleurServlet?origin=panier\"><i class=\"far fa-shopping-bag\"></i></a></li>\n");
      out.write("                    <li><a href=\"ControleurServlet?origin=deconnexion\">Déconnexion></i></a></li>\n");
      out.write("                ");
 }else{ 
      out.write("\n");
      out.write("                    <li><a href=\"/mvc_2_servlet/login.jsp\">Connectez-vous !</a></li>          \n");
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
