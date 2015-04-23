<%-- 
    Document   : Test2
    Created on : Jul 15, 2012, 2:12:46 PM
    Author     : diego
--%>

<html>
    <head>
        <title></title>
        <script type="text/javascript">
            
            function loadXMLDoc()
            {
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                    alert("hhhhhh");
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                    
                }
                xmlhttp.open("GET","proxy.php",true);
                xmlhttp.onreadystatechange=function()
                { 
                    alert("i'm in");
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {  
                        
                        var  response = xmlhttp.responseXML;
                        var tab = response.getElementsByTagName("uri");
                        alert(tab);
                   
                       
                        var dd=document.getElementById("diva");
                        dd.innerHTML(tab);
                        alert("sikaaaaa3");
                    }else {
                        alert("There was a problem in the returned data:\n");
                    }
                }
                
                xmlhttp.send();
            }
            
            
            
        </script>
    </head>
    <body>
        <div id ="diva">  </div>

        <p><input type="button" name="myBtn" id="myBtn1" value="Add" onClick="loadXMLDoc();"></p>

    </body>
</html>
