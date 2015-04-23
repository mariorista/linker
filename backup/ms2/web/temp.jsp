<%-- 
    Document   : temp
    Created on : Aug 21, 2012, 8:07:56 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%@page import="jclas.Disambiguity"%>
<%@page import="jclas.Connecter"%>
<%@page import="java.util.ArrayList"%>

<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->

<!--DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  //  "http://www.w3.org/TR/html4/loose.dtd"-->
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
    ArrayList<String> ar = Conn.getAllin();
    Disambiguity.setLinks(ar);
    Disambiguity.doAll();

    ArrayList<String> terms = Disambiguity.getTerms();
    ArrayList<String> fckcmt = Disambiguity.getComments();
    %>

