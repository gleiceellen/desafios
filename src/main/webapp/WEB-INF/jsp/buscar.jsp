<%-- 
    Document   : buscar
    Created on : 05/12/2017, 17:10:50
    Author     : gleiceellen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>Os melhores reddits</td>
            </tr>
            
            <c:forEach var="reddits" items="${lista}">
                <tr>
                    <td>${reddits}</td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
