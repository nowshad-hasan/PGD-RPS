package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class confirmationCode_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Confirmation Code</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css\" />\n");
      out.write("        <link  href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css.map\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"FrontEnd/bootstrap-3.3.7-dist/css/bootstrap.min.css\"/>\n");
      out.write("\n");
      out.write("        <script src=\"FrontEnd/bootstrap-3.3.7-dist/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"FrontEnd/javascript/script.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h1>Confirm Your Email Account</h1>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <p>Please check your email for confirmation code</p>\n");
      out.write("            </div>\n");
      out.write("            <form class=\"form-horizontal\" method=\"get\" action=\"RegistrationServlet\">\n");
      out.write("                <div class=\"form-group form-group-lg col-xs-6\">\n");
      out.write("                    <label class=\"col-sm-2 control-label\" for=\"lg\">Code</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"lg\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" name=\"actionName\" value=\"confirmation\">\n");
      out.write("                \n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary btn-lg\" >Validate Email</button>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
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
