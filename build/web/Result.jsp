<%-- 
    Document   : Result
    Created on : 14 Σεπ 2012, 1:22:06 μμ
    Author     : it20846
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%

    String disTerm = request.getParameter("arif");
    
    
    String lisTerm = request.getParameter("isDisTerm");
    

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=disTerm%></h1>
        
        <h1><%=lisTerm%></h1>
    </body>
</html>
