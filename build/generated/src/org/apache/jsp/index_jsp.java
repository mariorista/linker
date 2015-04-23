package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");

    String dbpedia[][] = new String[20][6];
    String foaf[][] = new String[20][6];
    String doublin[][] = new String[20][16];

    dbpedia[0][1] = "Species";
    //dbpedia[0][2] = "N";

    dbpedia[2][1] = "Person";
    dbpedia[2][2] = "Artist";

    dbpedia[3][1] = "Artist";
    dbpedia[3][2] = "MusicalArtist";


    dbpedia[1][1] = "Place";
    dbpedia[1][2] = "PopulatedPleace";
    dbpedia[1][3] = "City";
    dbpedia[1][4] = "Area";
    // dbpedia[1][5] = "N";

    dbpedia[5][1] = "PopulatedPleace";
    dbpedia[5][2] = "Country";

    dbpedia[6][1] = "Country";
    dbpedia[6][2] = "Municipality";

    dbpedia[7][1] = "Municipality";
    dbpedia[7][2] = "City";

    dbpedia[4][1] = "Organization";
    dbpedia[4][2] = "U";
    dbpedia[4][3] = "EducationalInstitute";
    //dbpedia[4][4] = "N";


    dbpedia[8][1] = "EducationalInstitute";
    dbpedia[8][2] = "University";


    dbpedia[9][1] = "Work";
    //dbpedia[9][2] = "N";
    dbpedia[10][1] = "Film";
    //dbpedia[10][2] = "N";


      out.write('\n');



    foaf[0][1] = "Agent";
    foaf[0][2] = "Organization";
    foaf[0][3] = "Group";
    foaf[0][4] = "Person";
    //foaf[0][5] = "N";


    foaf[1][1] = "Document";
    foaf[1][2] = "PersonalProfileDocument";
    foaf[1][3] = "Image";
    // foaf[1][3] = "N";


    foaf[2][1] = "OnlineAccount";
    foaf[2][2] = "Online_E-commerce_Account";
    foaf[2][3] = "Online_Gaming_Account";
    foaf[2][4] = "Online_Chat_Account";
    // foaf[2][5] = "N";

    foaf[3][1] = "Project";
    // foaf[3][2] = "N";
    foaf[4][1] = "maker";
    //foaf[4][2] = "N";
    foaf[5][1] = "mbox";
    //foaf[5][2] = "N";
    foaf[6][1] = "knows";
    // foaf[6][2] = "N";
    foaf[7][1] = "nick";
    // foaf[7][2] = "N";


      out.write('\n');

    doublin[0][1] = "http://purl.org/dc/terms/BibliographicResource";
    doublin[0][2] = "http://purl.org/dc/terms/Agent";
    doublin[0][3] = "http://purl.org/dc/terms/LicenseDocument";
    doublin[0][4] = "http://purl.org/dc/terms/MediaTypeOfExtent";
    doublin[0][5] = "http://purl.org/dc/terms/URI";
    doublin[0][6] = "http://purl.org/dc/terms/AgentClass";
    doublin[0][7] = "http://purl.org/dc/terms/LinguisticSystem";
    doublin[0][8] = "http://purl.org/dc/terms/SubjectScheme";
    doublin[0][9] = "http://purl.org/dc/terms/TypeScheme";
    doublin[0][10] = "http://purl.org/dc/terms/TemporalScheme";
    doublin[0][11] = "http://purl.org/dc/terms/DateScheme";
    doublin[0][12] = "http://purl.org/dc/terms/RFC1766";
    doublin[0][13] = "http://purl.org/dc/terms/Standart";
    doublin[0][14] = "http://purl.org/dc/terms/Text";
    doublin[0][15] = "http://purl.org/dc/terms/Text";

    doublin[1][1] = "http://purl.org/dc/elements/1.1/format";
    doublin[1][2] = "http://purl.org/dc/elements/1.1/subject";
    doublin[1][3] = "http://purl.org/dc/elements/1.1/language";
    doublin[1][4] = "http://purl.org/dc/elements/1.1/title";
    doublin[1][5] = "http://purl.org/dc/elements/1.1/description";
    doublin[1][6] = "http://purl.org/dc/elements/1.1/creator";
    doublin[1][7] = "http://purl.org/dc/elements/1.1/publisher";
    doublin[1][8] = "http://purl.org/dc/elements/1.1/date";
    doublin[1][9] = "http://purl.org/dc/elements/1.1/rights";
    doublin[1][10] = "http://purl.org/dc/elements/1.1/type";


    doublin[2][1] = " http://purl.org/dc/dcmitype/Text";
    doublin[2][2] = " http://purl.org/dc/dcmitype/Image";
    doublin[2][3] = " http://purl.org/dc/dcmitype/Sount";
    doublin[2][4] = " http://purl.org/dc/dcmitype/Collection";
    doublin[2][5] = " http://purl.org/dc/dcmitype/MovingImage";


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("    function del(msg){\n");
      out.write("        var ele=document.getElementById(msg);\n");
      out.write("                \n");
      out.write("        for (var i=ele.childNodes.length-1; i>=0; i--)\n");
      out.write("        {\n");
      out.write("            ele.removeChild(ele.childNodes[i]);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    function ontselector(sel){\n");
      out.write("        \n");
      out.write("        del(\"ontClass\");\n");
      out.write("        var cl=document.getElementById(\"ontClass\");\n");
      out.write("        \n");
      out.write("        if (sel==\"dbpedia\")\n");
      out.write("        {\n");
      out.write("            //          ");
 for (int i = 0; i < 20; i++) {
        if (dbpedia[i][1] == null) {
            break;
        }
      out.write("\n");
      out.write("\n");
      out.write("                    var opt=document.createElement(\"option\");\n");
      out.write("                    opt.text=\"");
      out.print(dbpedia[i][1]);
      out.write("\"\n");
      out.write("                    cl.add(opt);       \n");
      out.write("                \n");
      out.write("    ");
}
      out.write("\n");
      out.write("                   }\n");
      out.write("         \n");
      out.write("         \n");
      out.write("                   if (sel==\"doublin\")\n");
      out.write("                   {\n");
      out.write("    ");
 for (int i = 0; i < 20; i++) {
                    if (doublin[i][1] == null) {
                        break;
                    }
      out.write("// \n");
      out.write("                                \n");
      out.write("                                var opt=document.createElement(\"option\");\n");
      out.write("                                opt.text=\"");
      out.print(doublin[i][1]);
      out.write("\"\n");
      out.write("                                cl.add(opt);                       \n");
      out.write("    ");
}
      out.write("\n");
      out.write("                    }         \n");
      out.write("            \n");
      out.write("            \n");
      out.write("                  \n");
      out.write("                    if (sel==\"foaf\")\n");
      out.write("                    {\n");
      out.write("    ");
 for (int i = 0; i < 20; i++) {
              if (foaf[i][1] == null) {
                  break;
              }
      out.write(" \n");
      out.write("                          var opt=document.createElement(\"option\");\n");
      out.write("                          opt.text=\"");
      out.print(foaf[i][1]);
      out.write("\";\n");
      out.write("                          cl.add(opt);                 \n");
      out.write("    ");
}
      out.write("\n");
      out.write("             }     \n");
      out.write("   \n");
      out.write("         }//end of ontselector\n");
      out.write(" \n");
      out.write(" \n");
      out.write("         function subSelector(sel){\n");
      out.write("             del(\"ontSub\");\n");
      out.write("    \n");
      out.write("             var ontology = document.getElementById(\"ontList\").value;\n");
      out.write("             var sbcls = document.getElementById(\"ontSub\");\n");
      out.write("  \n");
      out.write("             if (ontology==\"dbpedia\"){\n");
      out.write(" \n");
      out.write("            \n");
      out.write("    ");
for (int i = 0; i < 20; i++) {
      out.write("\n");
      out.write("                            if (sel == \"");
      out.print(dbpedia[i][1]);
      out.write("\"){\n");
      out.write("    ");
 for (int k = 1; k < 6; k++) {
                                    if (dbpedia[i][k] == null) {
                                        break;
                                    }
      out.write("\n");
      out.write("                                                    var opt=document.createElement(\"option\");\n");
      out.write("                                                    opt.text=\"");
      out.print(dbpedia[i][k]);
      out.write("\";\n");
      out.write("                                                    sbcls.add(opt);              \n");
      out.write("    ");
}
      out.write(" \n");
      out.write("                                        }   \n");
      out.write("    ");
}
      out.write(" \n");
      out.write("                            sbcls.appernfChild(\"opt\");\n");
      out.write("                        }\n");
      out.write("    \n");
      out.write("                        if (ontology==\"foaf\"){\n");
      out.write("            \n");
      out.write("    ");
for (int i = 0; i < 20; i++) {
      out.write("\n");
      out.write("                        if (sel == \"");
      out.print(foaf[i][1]);
      out.write("\"){\n");
      out.write("        ");
 for (int k = 1; k < 6; k++) {
                                    if (dbpedia[i][k] == null) {
                                        break;
                                    }
      out.write("\n");
      out.write("                                                    var opt=document.createElement(\"option\");\n");
      out.write("                                                    opt.text=\"");
      out.print(foaf[i][k]);
      out.write("\";\n");
      out.write("                                                    sbcls.add(opt);       \n");
      out.write("    ");
}
      out.write(" \n");
      out.write("                                        }   \n");
      out.write("    ");
}
      out.write(" \n");
      out.write("                            sbcls.appernfChild(\"opt\");\n");
      out.write("                        }\n");
      out.write("                    }       \n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"div\"><div/>\n");
      out.write("            <form name=\" noname\" action=\"Getter.jsp\">\n");
      out.write("                <p > query <input id=\"q\" type=\"text\"  name=\"q\" value=\"\" /></p>\n");
      out.write("\n");
      out.write("                <p > ontology <select name=\"ont\" id=\"ontList\"  onchange=\"ontselector(this.value);\">\n");
      out.write("                        <option></option>\n");
      out.write("                        <option>dbpedia</option>\n");
      out.write("                        <option>foaf</option>\n");
      out.write("                        <option>doublin</option>\n");
      out.write("                    </select></p>\n");
      out.write("\n");
      out.write("                <p  id=\"ski\"> class <select name=\"ontClas\"  id=\"ontClass\" onchange=\"subSelector(this.value);\"   >\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p > sub-class <select  \n");
      out.write("                        name=\"ontSub\" id=\"ontSub\"  onchange=\"subSelector2(this.value);\">\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p > predicate <select name=\"pred\" id=\"pred\"   onchange=\"predicator();\">\n");
      out.write("                        <option></option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <input type=\"submit\" value=\"hit it\"/>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div id=\"ddd\">\n");
      out.write("\n");
      out.write("            </div>\n");
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
