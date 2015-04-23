<%-- 
   Document   : Test
   Created on : Jul 5, 2012, 10:04:31 PM
   Author     : diego
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Urier" scope="page" class="jclas.Urier" />




<%
    String q = request.getParameter("q");
    String ont = request.getParameter("ont");
    String clas = request.getParameter("ontClas");
    String sub = request.getParameter("ontSub");
%>
<jsp:setProperty name="Urier" property="ontology" value="<%=ont%>" />   
<!--jsp:setProperty name="Urier" property="sub" value="<!%=clas%---->  
<%
    if (sub.equals("")) {%>
<jsp:setProperty name="Urier" property="sub" value="<%=clas%>" />   
<%} else {%>
<jsp:setProperty name="Urier" property="sub" value="<%=sub%>" />   
<%}

    String fullOnt = Urier.getFullOnt();
    //String txt = Connecter.getTxt();

%>

<script type="text/javascript" >
    function ss(){
        var spl=("<!%=fullOnt%>")
        var ttt=spl.split(".");
        
        var sde=document.getElementById("gjks");
 
        var pe=document.createElement("p");
             
        // var tn=document.createTextNode("<!%=fullOnt%>");
        var tn=document.createTextNode(ttt);
        pe.appendChild(tn);
        sde.appendChild(pe);
        var bre=document.createElement("br"); 
        sde.appendChild(bre);
  
    }
    
    function trt(){
    <%for (int i = 0; i < 5; i++) {%> 
          idx="33";
            var sde = document.getElementById("sss");  
            var prg = document.createElement("p");
            var txt = "<a id='aId"+"<%=i%>"+"' href='http://www.google.com'>uuuuu </a>  <input type='button' value='akr' onclick='getIt("+"<%=i%>"+")' /> ";
          
            prg.innerHTML=txt;
            sde.appendChild(prg);
        
        
    <%}%>
        }
   
        function getIt(i){
           // alert(i);
            ides="aId"+i;
           // alert(ides);
            var bitch=document.getElementById(ides);
            bitch.innerHTML="muthefucka";
        }
        
        function sera(){
            k=",arakaibo,Marakaibo.Venezuela";
            if(k.match("aibo")){
                alert("i mutched it");
            }
        }
</script>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="ss();">
        <input type="submit" value="aaaa" onclick="trt();" />
        <input type="submit" value="aasssdddd" onclick="sera();" />
        <h1 id="gjks">Hello World!</h1>
        <div id="sss"></div>

    </body>
</html>
