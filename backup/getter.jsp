<%-- 
    Document   : Getter
    Created on : Dec 2, 2011, 12:28:45 PM
    Author     : diego
--%>



<%@page import="jclas.Connecter"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="Conn" scope="page" class="jclas.Conn" />
<jsp:useBean id="Connecter" scope="page" class="jclas.Connecter" />
<jsp:useBean id="Urier" scope="page" class="jclas.Urier" />
<jsp:useBean id="Splitter" scope="page" class="jclas.Splitter" />


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

<jsp:setProperty name="Conn" property="q" value="<%=q%>" />
<jsp:setProperty name="Conn" property="ont" value="<%=ont%>" />
<jsp:setProperty name="Conn" property="clas" value="<%=clas%>" />
<jsp:setProperty name="Conn" property="sub" value="<%=fullOnt%>" />

<%
    ArrayList ar = Conn.getAllin();
%>

<script type="text/javascript" >
    var valArray = new Array();
    
    function assigner(){
    <%for (int i = 0; i < ar.size(); i++) {%>
            valArray[<%=i%>]= "<%=ar.get(i)%>";
    <%}%> 
        }
    
        function del(msg){
            var ele=document.getElementById(msg);
            for (var i=ele.childNodes.length-1; i>=0; i--)
            {
                ele.removeChild(ele.childNodes[i]);
            }
        }
    
        function ss(){
            var sde=document.getElementById("ddd");
            del("ddd");
        
            for(i=0;i<valArray.length;i++){
                var idx=i;    
                var prg = document.createElement("p");
                var ref=valArray[i];
                var txt = "<a id='aId"+idx+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+idx+")' /> ";
                prg.innerHTML=txt;
                sde.appendChild(prg);
            }
        }
        
        function reset(){
            var sde=document.getElementById("ddd");
            del("ddd");
        
    <%  for (int i = 0; i < ar.size(); i++) {%>
            var idx=<%=i%>;    
            var prg = document.createElement("p");
            var ref="<%=ar.get(i)%>";
            var txt = "<a id='aId"+idx+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+idx+")' /> ";
            prg.innerHTML=txt;
            sde.appendChild(prg)           
    <%}%>
            assigner();
        }
            
        function domer(url){//gets the domain from the url
            var dom;
            temp = url.split("://");
            temp1 = temp[1].split("/");
            temp2 = temp1[0].split(".");
            if(temp2[0]==="www"){
                dom = temp2[1];
            }
            else{
                dom = temp2[0];
            }
            return dom;
        }
        
        
        function domIn(dom){
            var j=0; 
    <% for (int i = 0; i < ar.size(); i++) {%>
            if (!"<%=ar.get(i)%>".match(dom))
            {
                j++;
            }
    <%}%>
            return j; 
        }

 
       

        function getIt(idx){
           
            var id="aId"+idx;
            var url=document.getElementById(id).href;
            var dom = domer(url);
            var showArray = new Array();
            var j=0;
            for(i=0;i<valArray.length;i++){
                if(!valArray[i].match(dom)){
                    showArray[j]=valArray[i];
                    j++;
                }
            }
            valArray=showArray;
            ss2(showArray);
        }    
        
        
        
        function ss2(showArray){
            del("ddd");
            var sde=document.getElementById("ddd");
            
            for(i=0;i<showArray.length;i++){
                var prg = document.createElement("p");
                var ref=showArray[i];
                var txt = "<a id='aId"+i+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+i+")' /> ";
                prg.innerHTML=txt;
                sde.appendChild(prg);
            } 
        }
       
        
        
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload=" assigner(); ss();">
        <h1>Hello  CRUEL World! <%=q%></h1>
        <div id="ddd">


        </div>
        <div id="c">

        </div>
        <input type="reset" value="reset" name="res" onclick="reset();"/>
        <input type="button" value="show" name="gugu" on click="shower();"/>
    </body>
</html>
