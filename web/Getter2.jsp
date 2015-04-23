<%-- 
    Document   : Getter2
    Created on : Aug 21, 2012, 9:10:41 PM
    Author     : diego
--%>

<%@page import="jclas.Disambiguity"%>
<%@page import="jclas.Connecter"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Conn" scope="page" class="jclas.Conn" />
<jsp:useBean id="Connecter" scope="page" class="jclas.Connecter" />
<jsp:useBean id="Urier" scope="page" class="jclas.Urier" />
<jsp:useBean id="Splitter" scope="page" class="jclas.Splitter" />
<jsp:useBean id="Disambiguity" scope="page" class="jclas.Disambiguity" />

<%
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

%>


<% String fullOnt = "";
    if (!ont.equals("") && !clas.equals("")) {%>

<jsp:setProperty name="Urier" property="ontology" value="<%=ont%>" />   
<!--jsp:setProperty name="Urier" property="sub" value="<!%=clas%>" /-->  

<%                                                                      // pas class or subClass
    if (sub.equals("")) {%>
<jsp:setProperty name="Urier" property="sub" value="<%=clas%>" />   
<%} else {%>
<jsp:setProperty name="Urier" property="sub" value="<%=sub%>" />   
<%}
        fullOnt = Urier.getFullOnt();                                // get URI of the ont
    }%>



<!-- pass the properties to Conn class-->
<jsp:setProperty name="Conn" property="q" value="<%=q%>" />            
<jsp:setProperty name="Conn" property="ont" value="<%=ont%>" />
<jsp:setProperty name="Conn" property="clas" value="<%=clas%>" />
<jsp:setProperty name="Conn" property="sub" value="<%=fullOnt%>" />


<%
    //ArrayList<String> ar = Conn.getAllin();
    //Disambiguity.setLinks(ar);
 //   /Disambiguity.doAll();
//
  //  ArrayList<String> terms = Disambiguity.getTerms();
//    ArrayList<String> fckcmt = Disambiguity.getComments();%>





<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload=" assigner(); ">
      <table border="1" width="100%">
            <tbody>
                <tr>
            <div>

            </div>
        </tr>
        <tr>
            <td  width = "50%" valign="top" style="position: relative" > 
                <div id="ddd">
                </div>

            </td>
            <td width="40%" valign="top" colspan="2"   >
                <div id="c"  style="margin: 30pt" >
                    <table border="1" width="100%">
                        <tr>
                            <td>
                                <form name="noname" action="Result.jsp" method="GET">
                                <select name="dis-list" id="disList" size="12"  ><!-- contains the ambiguous term-->

                                </select>
                            </td>
                            <td>
                                <select name="dis-term" id="disTerm" size="12"  ><!-- contains the terms-->

                            </td>
                        </tr>  
                        <tr>
                            <td> 
                                
                                    <input type="hidden" name="q" value="<%=q%>"/>
                                    <input type="hidden" name="ont" value="<%=ont%>"/>
                                    <input type="hidden" name="ontClas" value="<%=clas%>"/>
                                    <input type="hidden" name="ontSub" value="<%=sub%>"/>
                                    <input type="submit" value="search this one" />
                                </form>

                            </td> 
                            <td align="right"> <form name="newname" action="index.jsp" method="GET">
                                    <input type="submit" value="nwe search" />
                                </form>  
                            </td>
                        </tr>
                    </table>
                </div>
                <table border="1" width="100%">
                    <tbody>
                        <tr>
                            <td id="cmt" align="center"  colspan="2" /> 
                    <div id="test">
                    </div>
            </td>
        </tr>
    </tbody>
</table>                    
</td>
</tr>
<tr>
    <td id="pgNr">

    </td>
</tr>

</tbody>
</table>

        <div id="test">

        </div>


        <input type="reset" value="reset" name="res" onclick="reset();"/>
        <input type="button" value="show" name="gugu" onclick="diambiguity();"/>
        <input type="button" value="next" name="gugug" onclick="next();"/>
        <input type="button" value="past" name="guguer" onclick="previous();"/>

        <input type="button" value="asign" onclick="getc();"/>
    </body>
</html>

