<%-- 
    Document   : Getter
    Created on : Dec 2, 2011, 12:28:45 PM
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
<jsp:setProperty name="Conn" property="q" value="<%=q.replaceAll(" ","_") %>" />            
<jsp:setProperty name="Conn" property="ont" value="<%=ont%>" />
<jsp:setProperty name="Conn" property="clas" value="<%=clas%>" />
<jsp:setProperty name="Conn" property="sub" value="<%=fullOnt%>" />


<%
    ArrayList<String> ar = Conn.getAllin();
    Disambiguity.setLinks(ar);
    Disambiguity.setQ(q);
    Disambiguity.doAll();


    ArrayList<String> comm = Disambiguity.getComments();
    ArrayList<String> redComm = Disambiguity.getRedComList();
    ArrayList<String> keyTerm = Disambiguity.getKeyTerm();
    ArrayList<String> term = Disambiguity.getTerms();
   
%>

<script type="text/javascript" >
    
    var pgCounter=1;//to go the next or previous page
    
    var commentsArray=new Array();
    
    var titleArray = new Array();
    var linkArray = new Array();
    var formatArray = new Array();
    
    var termArray = new Array();
    var commArray = new Array();
    var keyArray = new Array();
    var redComArray = new Array();
    //   / var cmt ;
    //var formatArray = new Array();
    
    
    /* transfers the values from JSP to js  
     * so that we don't have to use JSP variables but js variables
     */
    function assigner(){// sindice resoults
        
    <% for (int i = 0; i < ar.size(); i++) {%>
            tempVar= "<%=ar.get(i)%>";
            tempVar2=tempVar.split(";");
            linkArray[<%=i%>]=tempVar2[0];
            titleArray[<%=i%>]=tempVar2[1];
            formatArray[<%=i%>]=tempVar2[2];
    <%}%> 
            ss();           
        }//end of function        
        
        function disAssign(){//disambiguity results
        
    <% for (int i = 0; i < keyTerm.size(); i++) {%>
            tempVar= "<%=keyTerm.get(i)%>";
            tempVar2=tempVar.split("-;");
            keyArray[<%=i%>]=new Array (tempVar2[0],tempVar2[1]);
    <%}%> 
        
    <% for (int i = 0; i < term.size(); i++) {%>
            tempVar= "<%=term.get(i)%>";
            tempVar2=tempVar.split("-;");
            termArray[<%=i%>]=new Array (tempVar2[0],tempVar2[1]);
    <%}%> 
        
    <% for (int i = 0; i < comm.size(); i++) {%>
            tempVar= "<%=comm.get(i)%>";
            tempVar2=tempVar.split("-;");
            commArray[<%=i%>]=new Array (tempVar2[0],tempVar2[1]);
    <%}%> 
        
    <% for (int i = 0; i < redComm.size(); i++) {%>
            tempVar= "<%=redComm.get(i)%>";
            tempVar2=tempVar.split("-;");
            redComArray[<%=i%>]=new Array (tempVar2[0]);
    <%}%> 
            disambiguity();
        }//end of function
   
   
        function ccc(){
            var ttd = document.getElementById("test")
            for(i=0;i<keyArray.length;i++){
                var pp= document.createElement("p");
                var txt=document.createTextNode(keyArray[i][0])
                //var txt2=document.createTextNode(keyArray[i][1])
                var text = txt;//+txt2;
                pp.appendChild(text);
                ttd.appendChild(pp);
            }
        
        }    
        
        
        
        function rdfa(){// to show only the actual sites
            
            var showLinkArray = new Array();
            var showTitleArray = new Array();
            var j=0;
            for(i=0;i<formatArray.length;i++){
                if(formatArray[i]==1){
                    
                    showTitleArray[j]=titleArray[i];
                    showLinkArray[j]=linkArray[i];
                    j++;
                }
            }
            
            titleArray=showTitleArray;
            linkArray=showLinkArray;       
            ss2(showTitleArray,showLinkArray);
        }
        
   


        function del(msg){              //deletes the children of a node
            var ele=document.getElementById(msg);
            for (var i=ele.childNodes.length-1; i>=0; i--)
            {
                ele.removeChild(ele.childNodes[i]);
            }
        }
    
    
        function ss(){                  // first function to run, displays the screens
            
            var sde=document.getElementById("ddd");
            del("ddd");
        
            for(i=(pgCounter-1)*10;i<pgCounter*10 ;i++){
                if(i>=linkArray.length)
                    break;
                var idx=i;    
                var prg = document.createElement("p");
                var tit =titleArray[i];
                var ref=linkArray[i];
                var txt = tit+"<br>"+"<a id='aId"+idx+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+idx+")' /><hr> ";
                prg.innerHTML=txt;
                sde.appendChild(prg); 
            }
            page();
        }
        
        
        function next(){
            if(pgCounter*10<linkArray.length)
            {
                pgCounter++;
                ss();     
            }
        }
        
        function previous(){         
            if(pgCounter>1)
            {
                pgCounter--;    
                ss();
            }
                
        }
        
        function reset(){       //after deleting resets the variables to the initial state            
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
        
    

        function getIt(idx){  //deletes the links baed on the domain
          
            var dom = domer(linkArray[idx]);
            var showLinkArray = new Array();
            var showTitleArray = new Array();
            var j=0;
            for(i=0;i<linkArray.length;i++){
                if(!linkArray[i].match(dom)){
                    showTitleArray[j]=titleArray[i]
                    showLinkArray[j]=linkArray[i];
                    j++;
                }
            }
            titleArray=showTitleArray;
            linkArray=showLinkArray;            
            ss2(showTitleArray,showLinkArray);
        }    
        
        
        function ss2(showTitleArray,showLinkArray){        //displays the screen after the delete
            
            var sde=document.getElementById("ddd");
            del("ddd");
            for(i=(pgCounter-1)*10;i<pgCounter*10;i++){
                if(i>=linkArray.length)
                    break;
                var prg = document.createElement("p");
                var tit =showTitleArray[i];
                var ref=showLinkArray[i];
                //var txt = "<h4>"+tit+"</h4><a id='aId"+i+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+i+")' /><hr> ";
                var txt = tit+"<br>"+"<a id='aId"+i+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+i+")' /><hr> ";
                
                
                prg.innerHTML=txt;
                sde.appendChild(prg);
            } 
        }
        
        
        function disambiguity(){// fills the first part of the terms on the d.d.list "disList"
           
            var list=document.getElementById("disList");
            
            for(j=0;j<redComArray.length;j++){
                var opt=document.createElement("option");
                opt.text=keyArray[j][0];
                opt.setAttribute("onclick", "showRedComment("+j+");");            
                list.add(opt);           
            }
            for(i=redComArray.length;i<keyArray.length;i++){
                var opt=document.createElement("option");
                opt.text=keyArray[i][0];
                opt.setAttribute("onclick", "midleFunc("+i+");");            
                list.add(opt);           
            }                     
        }        
     
        
        function midleFunc(i){// if it is a ambiguous term show the other terms to the d.d.list "disTerm"
            del("disTerm");
            var list=document.getElementById("disTerm");
            for(j=0;j<termArray.length;j++){
                if(termArray[j][1]===keyArray[i][1]){
                    var opt=document.createElement("option");
                    opt.text=termArray[j][0];
                    opt.setAttribute("onclick", "showComment("+j+");");       
                    list.add(opt);           
                }//if
            }//for        
        }          
        
        function showComment(i){        
            del("test");
            var cts = document.getElementById("test");
            var hh  = document.createElement("h4");            
            var txt = document.createTextNode(commArray[i][0]);
            hh.appendChild(txt);
            cts.appendChild(hh);        
        }     
        
        function showRedComment(i){        
            del("test");
            var cts = document.getElementById("test");
            var hh  = document.createElement("h4");            
            var txt = document.createTextNode(redComArray[i][0]);
            hh.appendChild(txt);
            cts.appendChild(hh);        
        }     
      
        function page(){
            del("pgNr");
            var page = document.getElementById("pgNr");
            pgTn = document.createTextNode(pgCounter);
            page.appendChild(pgTn);
        }
        
</script>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload=" assigner(); disAssign(); ">
        
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
                                <select name="dis-list" id="disList" size="12"  ><!-- contains the ambiguous term-->

                                </select>
                            </td>
                            <td>
                                <select name="dis-term" id="disTerm" size="12"  ><!-- contains the terms-->

                            </td>
                        </tr>  
                        <tr>
                            <td> 
                                <form name="noname" action="Result.jsp" method="GET">
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
<input type="button" value="previous" name="guguer" onclick="previous();"/>
<input type="button" value="next" name="gugug" onclick="next();"/>
<input type="button" value="RDFa" name="gugug" onclick="rdfa();"/>
<input type="button" value="foo" name="gugug" onclick="ccc();"/>



</body>
</html>
