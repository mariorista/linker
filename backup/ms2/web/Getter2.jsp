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
    ArrayList<String> ar = Conn.getAllin();
    Disambiguity.setLinks(ar);
    Disambiguity.doAll();

    ArrayList<String> terms = Disambiguity.getTerms();
    ArrayList<String> fckcmt = Disambiguity.getComments();%>



<script type="text/javascript" >
    
    var pgCounter=1;//to go the next or previous page
    
    var commentsArray=new Array();
    
    var titleArray = new Array();
    var linkArray = new Array();
    var formatArray = new Array();
    var cmt ;
    //var formatArray = new Array();
    
    
    /* transfers the values from JSP to js  
     * so that we don't have to use JSP variables but js variables
     */
 
    
    function assigner(){
    <% for (int i = 0; i < ar.size(); i++) {%>
            tempVar= "<%=ar.get(i)%>";
            tempVar2=tempVar.split(";");
            linkArray[<%=i%>]=tempVar2[0];
            titleArray[<%=i%>]=tempVar2[1];
            formatArray[<%=i%>]=tempVar2[2];
    <%}%> 
            ss();           
        }
        
        
        //        function getc(){
        //            alert("hiiiiiiiii");
        //            var tte = document.getElementById("test");
        //    <!% try {
        //for (int i = 0; i < fckcmt.size();i++ ) {%-->//
        //                   //tte.innerHTML= "<!--%=fckcmt.get(i)%-->";
        //                  
        //    <!%}
        //    } catch (Exception e) {
        //      e.printStackTrace();
        //}%>//   
        //                    gettf();
        //        }
        //   
        //         
        //                function gettf(){
        //                    alert("hiiiiiit2");
        //                    var ctt = document.getElementById("test");
        //                    for(i=0;i<cmt.length;i++){
        //                        ctt.innerHTML=cmt[i]+"<br>";
        //           
        //                    }
        //                }

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
                var txt = "<h4>"+tit+"</h4><a id='aId"+idx+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+idx+")' /> ";
                prg.innerHTML=txt;
                sde.appendChild(prg); 
            }
            diambiguity();
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
                var txt = "<h4>"+tit+"</h4><a id='aId"+i+"' href='"+ref+"'> "+ref+" </a>  <input type='button' value='del' onclick='getIt("+i+")' /> ";
                prg.innerHTML=txt;
                sde.appendChild(prg);
            } 
        }
        
        function diambiguity(){
            var list=document.getElementById("disList");
            var cmt=document.getElementById("cmt");
                         
    <%for (int i = 0; i < terms.size(); i++) {%>                  
            var opt=document.createElement("option");
            opt.text="<%=terms.get(i)%>";
            opt.setAttribute("onclick", "showComment("+<%=i%>+");");           
            
            list.add(opt);           
    <%}%>   
        }
        
        
        function showComment(i){
           
            var cmtp = document.getElementById("p_"+i);
            var cmtf = document.getElementById("f_"+i);
             
            for(j=0;j< <%=fckcmt.size()%>;j++){
                var cmtpa = document.getElementById("p_"+j);
                cmtpa.setAttribute("style", "visibility: hidden");
                var cmtf = document.getElementById("f_"+i);
                cmtf.setAttribute("size", "1");
            }
            cmtp.setAttribute("style", "visibility: visible");
            cmtf.setAttribute("size", "3");
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
    <body onload=" assigner(); ">
        <table border="1" width="100%">
            <tbody>
                <tr>
                    <td  width = "60%" valign="top"> 
                        <div id="ddd">
                        </div>

                    </td>
                    <td width="40%" valign="top" colspan="2">
                        <div id="c"  style="margin: 30pt" >
                            <table border="1" width="100%">
                                <tr>
                                    <td>
                                        <select name="dis-list" id="disList" size="12"  >
                                            <option></option>
                                        </select>
                                    </td>
                                </tr>  
                                <tr>
                                    <td colspan="2"> 
                                        <form name="noname" action="Getter.jsp" method="GET">
                                            <input type="hidden" name="q" value="<%=q%>"/>
                                            <input type="hidden" name="ont" value="<%=ont%>"/>
                                            <input type="hidden" name="ontClas" value="<%=clas%>"/>
                                            <input type="hidden" name="ontSub" value="<%=sub%>"/>
                                            <input type="submit" value="search this one" />
                                        </form>

                                    </td>                                    
                                </tr>

                            </table>

                            <table border="0" width="100%"  >
                                <tbody  >
                                    <tr>
                                        <td id="cmt" align="center"  colspan="2" /> 
                                        <% for (int i = 0; i < fckcmt.size(); i++) {%>
                                <font size="1" id="f_<%=i%>" >
                                    <p id="p_<%=i%>"  style="visibility:  hidden" >
                                        <%=fckcmt.get(i)%>
                                    </p>
                                </font>   
                                <%}%> 


                                </td>
                                </tr>
                                
                                </tbody>
                            </table>



                        </div>
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

