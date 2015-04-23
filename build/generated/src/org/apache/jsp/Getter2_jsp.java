package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jclas.Disambiguity;
import jclas.Connecter;
import java.util.ArrayList;

public final class Getter2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      jclas.Conn Conn = null;
      synchronized (_jspx_page_context) {
        Conn = (jclas.Conn) _jspx_page_context.getAttribute("Conn", PageContext.PAGE_SCOPE);
        if (Conn == null){
          Conn = new jclas.Conn();
          _jspx_page_context.setAttribute("Conn", Conn, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      jclas.Connecter Connecter = null;
      synchronized (_jspx_page_context) {
        Connecter = (jclas.Connecter) _jspx_page_context.getAttribute("Connecter", PageContext.PAGE_SCOPE);
        if (Connecter == null){
          Connecter = new jclas.Connecter();
          _jspx_page_context.setAttribute("Connecter", Connecter, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      jclas.Urier Urier = null;
      synchronized (_jspx_page_context) {
        Urier = (jclas.Urier) _jspx_page_context.getAttribute("Urier", PageContext.PAGE_SCOPE);
        if (Urier == null){
          Urier = new jclas.Urier();
          _jspx_page_context.setAttribute("Urier", Urier, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      jclas.Splitter Splitter = null;
      synchronized (_jspx_page_context) {
        Splitter = (jclas.Splitter) _jspx_page_context.getAttribute("Splitter", PageContext.PAGE_SCOPE);
        if (Splitter == null){
          Splitter = new jclas.Splitter();
          _jspx_page_context.setAttribute("Splitter", Splitter, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      jclas.Disambiguity Disambiguity = null;
      synchronized (_jspx_page_context) {
        Disambiguity = (jclas.Disambiguity) _jspx_page_context.getAttribute("Disambiguity", PageContext.PAGE_SCOPE);
        if (Disambiguity == null){
          Disambiguity = new jclas.Disambiguity();
          _jspx_page_context.setAttribute("Disambiguity", Disambiguity, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    String q = request.getParameter("q");
    String ont = request.getParameter("ont");
    if (ont == null) {
        ont = "";
    }

    String clas = request.getParameter("ontClas");
    if (clas == null) {
        clas = "";
    }

    String sub = request.getParameter("ontSub");
    if (sub == null) {
        sub = "";
    }


      out.write("\n");
      out.write("\n");
      out.write("\n");
 String fullOnt = "";
    if (!ont.equals("") && !clas.equals("")) {
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Urier"), "ontology",
ont);
      out.write("   \n");
      out.write("<!--jsp:setProperty name=\"Urier\" property=\"sub\" value=\"<!%=clas%>\" /-->  \n");
      out.write("\n");
                                                                      // pas class or subClass
    if (sub.equals("")) {
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Urier"), "sub",
clas);
      out.write("   \n");
} else {
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Urier"), "sub",
sub);
      out.write("   \n");
}
        fullOnt = Urier.getFullOnt();                                // get URI of the ont
    }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- pass the properties to Conn class-->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Conn"), "q",
q);
      out.write("            \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Conn"), "ont",
ont);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Conn"), "clas",
clas);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("Conn"), "sub",
fullOnt);
      out.write("\n");
      out.write("\n");
      out.write("\n");

    //ArrayList<String> ar = Conn.getAllin();
    //Disambiguity.setLinks(ar);
 //   /Disambiguity.doAll();
//
  //  ArrayList<String> terms = Disambiguity.getTerms();
//    ArrayList<String> fckcmt = Disambiguity.getComments();
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\" assigner(); \">\n");
      out.write("      <table border=\"1\" width=\"100%\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td  width = \"50%\" valign=\"top\" style=\"position: relative\" > \n");
      out.write("                <div id=\"ddd\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </td>\n");
      out.write("            <td width=\"40%\" valign=\"top\" colspan=\"2\"   >\n");
      out.write("                <div id=\"c\"  style=\"margin: 30pt\" >\n");
      out.write("                    <table border=\"1\" width=\"100%\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <form name=\"noname\" action=\"Result.jsp\" method=\"GET\">\n");
      out.write("                                <select name=\"dis-list\" id=\"disList\" size=\"12\"  ><!-- contains the ambiguous term-->\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <select name=\"dis-term\" id=\"disTerm\" size=\"12\"  ><!-- contains the terms-->\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>  \n");
      out.write("                        <tr>\n");
      out.write("                            <td> \n");
      out.write("                                \n");
      out.write("                                    <input type=\"hidden\" name=\"q\" value=\"");
      out.print(q);
      out.write("\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"ont\" value=\"");
      out.print(ont);
      out.write("\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"ontClas\" value=\"");
      out.print(clas);
      out.write("\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"ontSub\" value=\"");
      out.print(sub);
      out.write("\"/>\n");
      out.write("                                    <input type=\"submit\" value=\"search this one\" />\n");
      out.write("                                </form>\n");
      out.write("\n");
      out.write("                            </td> \n");
      out.write("                            <td align=\"right\"> <form name=\"newname\" action=\"index.jsp\" method=\"GET\">\n");
      out.write("                                    <input type=\"submit\" value=\"nwe search\" />\n");
      out.write("                                </form>  \n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <table border=\"1\" width=\"100%\">\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td id=\"cmt\" align=\"center\"  colspan=\"2\" /> \n");
      out.write("                    <div id=\"test\">\n");
      out.write("                    </div>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </tbody>\n");
      out.write("</table>                    \n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td id=\"pgNr\">\n");
      out.write("\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("</tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("        <div id=\"test\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <input type=\"reset\" value=\"reset\" name=\"res\" onclick=\"reset();\"/>\n");
      out.write("        <input type=\"button\" value=\"show\" name=\"gugu\" onclick=\"diambiguity();\"/>\n");
      out.write("        <input type=\"button\" value=\"next\" name=\"gugug\" onclick=\"next();\"/>\n");
      out.write("        <input type=\"button\" value=\"past\" name=\"guguer\" onclick=\"previous();\"/>\n");
      out.write("\n");
      out.write("        <input type=\"button\" value=\"asign\" onclick=\"getc();\"/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
