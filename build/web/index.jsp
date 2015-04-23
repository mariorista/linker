<%-- 
    Document   : index
    Created on : Nov 30, 2011, 9:46:58 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
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

%>
<%


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

%>
<%
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

%>


<script type="text/javascript">
    
    function del(msg){
        var ele=document.getElementById(msg);
                
        for (var i=ele.childNodes.length-1; i>=0; i--)
        {
            ele.removeChild(ele.childNodes[i]);
        }
    }
    
    
    function ontselector(sel){
        
        del("ontClass");
        var cl=document.getElementById("ontClass");
        
        if (sel=="dbpedia")
        {
            //          <% for (int i = 0; i < 20; i++) {
        if (dbpedia[i][1] == null) {
            break;
        }%>

                    var opt=document.createElement("option");
                    opt.text="<%=dbpedia[i][1]%>"
                    cl.add(opt);       
                
    <%}%>
                   }
         
         
                   if (sel=="doublin")
                   {
    <% for (int i = 0; i < 20; i++) {
                    if (doublin[i][1] == null) {
                        break;
                    }%>// 
                                
                                var opt=document.createElement("option");
                                opt.text="<%=doublin[i][1]%>"
                                cl.add(opt);                       
    <%}%>
                    }         
            
            
                  
                    if (sel=="foaf")
                    {
    <% for (int i = 0; i < 20; i++) {
              if (foaf[i][1] == null) {
                  break;
              }%> 
                          var opt=document.createElement("option");
                          opt.text="<%=foaf[i][1]%>";
                          cl.add(opt);                 
    <%}%>
             }     
   
         }//end of ontselector
 
 
         function subSelector(sel){
             del("ontSub");
    
             var ontology = document.getElementById("ontList").value;
             var sbcls = document.getElementById("ontSub");
  
             if (ontology=="dbpedia"){
 
            
    <%for (int i = 0; i < 20; i++) {%>
                            if (sel == "<%=dbpedia[i][1]%>"){
    <% for (int k = 1; k < 6; k++) {
                                    if (dbpedia[i][k] == null) {
                                        break;
                                    }%>
                                                    var opt=document.createElement("option");
                                                    opt.text="<%=dbpedia[i][k]%>";
                                                    sbcls.add(opt);              
    <%}%> 
                                        }   
    <%}%> 
                            sbcls.appernfChild("opt");
                        }
    
                        if (ontology=="foaf"){
            
    <%for (int i = 0; i < 20; i++) {%>
                        if (sel == "<%=foaf[i][1]%>"){
        <% for (int k = 1; k < 6; k++) {
                                    if (dbpedia[i][k] == null) {
                                        break;
                                    }%>
                                                    var opt=document.createElement("option");
                                                    opt.text="<%=foaf[i][k]%>";
                                                    sbcls.add(opt);       
    <%}%> 
                                        }   
    <%}%> 
                            sbcls.appernfChild("opt");
                        }
                    }       
        

        
</script>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="div"><div/>
            <form name=" noname" action="Getter.jsp">
                <p > query <input id="q" type="text"  name="q" value="" /></p>

                <p > ontology <select name="ont" id="ontList"  onchange="ontselector(this.value);">
                        <option></option>
                        <option>dbpedia</option>
                        <option>foaf</option>
                        <option>doublin</option>
                    </select></p>

                <p  id="ski"> class <select name="ontClas"  id="ontClass" onchange="subSelector(this.value);"   >
                        <option></option>
                    </select>
                </p>

                <p > sub-class <select  
                        name="ontSub" id="ontSub"  onchange="subSelector2(this.value);">
                        <option></option>
                    </select>
                </p>

                <p > predicate <select name="pred" id="pred"   onchange="predicator();">
                        <option></option>
                    </select>
                </p>

                <input type="submit" value="hit it"/>

            </form>

            <div id="ddd">

            </div>
    </body>
</html>
