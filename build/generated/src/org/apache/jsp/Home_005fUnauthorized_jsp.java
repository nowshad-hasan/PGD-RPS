package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Course;

public final class Home_005fUnauthorized_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>HOME(Unauthorized)</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("<link rel=\"stylesheet\" href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map\">\n");
      out.write("<link rel=\"stylesheet\" href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"FrontEnd/css/style.css\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"FrontEnd/css/footer-distributed-with-contact-form.css\">\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/3/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/lib/w3-theme-teal.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("  <body>\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\" >\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"{pageContext.request.contextPath}/Home_Unauthorized.jsp\">PGD RPS</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("\n");
      out.write("          <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n");
      out.write("            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/registration.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("      <!-- Indicators -->\n");
      out.write("      <ol class=\"carousel-indicators\">\n");
      out.write("\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"1\" ></li>\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("      </ol>\n");
      out.write("\n");
      out.write("      <!-- Wrapper for slides -->\n");
      out.write("      <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("\n");
      out.write("        <div class=\"item carousel-item active\">\n");
      out.write("          <img src=\"FrontEnd/images/first.jpg\" alt=\"Chania\" width=\"460\" height=\"345\">\n");
      out.write("          <div class=\"carousel-caption\">\n");
      out.write("            <h3>Chania</h3>\n");
      out.write("            <p>The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"item carousel-item\">\n");
      out.write("          <img src=\"FrontEnd/images/second.jpg\" alt=\"Chania\" width=\"460\" height=\"345\">\n");
      out.write("          <div class=\"carousel-caption\">\n");
      out.write("            <h3>Chania</h3>\n");
      out.write("            <p>The atmosphere in Chania has a touch of Florence and Venice.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"item carousel-item\">\n");
      out.write("          <img src=\"FrontEnd/images/third.jpg\" alt=\"Flower\" width=\"460\" height=\"345\">\n");
      out.write("          <div class=\"carousel-caption\">\n");
      out.write("            <h3>Flowers</h3>\n");
      out.write("            <p>Beatiful flowers in Kolymbari, Crete.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Left and right controls -->\n");
      out.write("      <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("        <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("        <span class=\"sr-only\">Previous</span>\n");
      out.write("      </a>\n");
      out.write("      <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("        <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("        <span class=\"sr-only\">Next</span>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- <div class=\"panel-footer\" >\n");
      out.write("  Copyright &copy; SUSTCSE\n");
      out.write("</div> -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"w3-row-padding w3-center w3-margin-top\">\n");
      out.write("<div class=\"w3-third\">\n");
      out.write("  <div class=\"w3-card-2 w3-padding-top\" style=\"min-height:460px\">\n");
      out.write("  <h4>Responsive</h4><br>\n");
      out.write("  <!-- <i class=\"fa fa-desktop w3-margin-bottom w3-text-theme\" style=\"font-size:120px\"></i> -->\n");
      out.write("<img src=\"FrontEnd/images/Turbo.png\" alt=\"Turbo\" height=\"150\" width=\"150\" />\n");
      out.write("\n");
      out.write("  <p>Built-in responsiveness</p>\n");
      out.write("  <p>Mobile first fluid grid</p>\n");
      out.write("  <p>Fits any screen sizes</p>\n");
      out.write("  <p>PC Tablet and Mobile</p>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"w3-third\">\n");
      out.write("  <div class=\"w3-card-2 w3-padding-top\" style=\"min-height:460px\">\n");
      out.write("  <h4>Standard CSS</h4><br>\n");
      out.write("  <!-- <i class=\"fa fa-css3 w3-margin-bottom w3-text-theme\" style=\"font-size:120px\"></i> -->\n");
      out.write("  <img src=\"FrontEnd/images/2.png\" alt=\"Turbo\" height=\"150\" width=\"150\" />\n");
      out.write("  <p>Standard CSS only</p>\n");
      out.write("  <p>Easy to learn</p>\n");
      out.write("  <p>No need for jQuery</p>\n");
      out.write("  <p>No JavaScript library</p>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"w3-third\">\n");
      out.write("  <div class=\"w3-card-2 w3-padding-top\" style=\"min-height:460px\">\n");
      out.write("  <h4>Design</h4><br>\n");
      out.write("  <!-- <i class=\"fa fa-diamond w3-margin-bottom w3-text-theme\" style=\"font-size:120px\"></i> -->\n");
      out.write("  <img src=\"FrontEnd/images/ratatoulie.jpg\" alt=\"Turbo\" height=\"150\" width=\"150\" />\n");
      out.write("  <p>Paper like design</p>\n");
      out.write("  <p>Bold colors and shadows</p>\n");
      out.write("  <p>Equal across platforms</p>\n");
      out.write("  <p>Equal across devices</p>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"footer-distributed\">\n");
      out.write("\n");
      out.write("  <div class=\"footer-left\">\n");
      out.write("\n");
      out.write("    <h3>PGD RPS\n");
      out.write("      <!-- <span>logo</span> -->\n");
      out.write("    </h3>\n");
      out.write("\n");
      out.write("    <p class=\"footer-links\">\n");
      out.write("      <a href=\"#\">Home</a>\n");
      out.write("      ·\n");
      out.write("      <a href=\"#\">Result</a>\n");
      out.write("      ·\n");
      out.write("      <a href=\"#\">Publish</a>\n");
      out.write("      ·\n");
      out.write("      <a href=\"#\">About</a>\n");
      out.write("      ·\n");
      out.write("      <a href=\"#\">Faq</a>\n");
      out.write("      ·\n");
      out.write("      <a href=\"#\">Contact</a>\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("    <p class=\"footer-company-name\">PGD RPS &copy; SUSTCSE</p>\n");
      out.write("\n");
      out.write("    <div class=\"footer-icons\">\n");
      out.write("\n");
      out.write("      <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("      <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("      <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("      <a href=\"#\"><i class=\"fa fa-github\"></i></a>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <div class=\"footer-right\">\n");
      out.write("\n");
      out.write("    <p>Contact Us</p>\n");
      out.write("\n");
      out.write("    <form>\n");
      out.write("\n");
      out.write("      <input type=\"text\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("      <textarea name=\"message\" placeholder=\"Message\"></textarea>\n");
      out.write("      <button>Send</button>\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
