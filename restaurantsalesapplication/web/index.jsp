<%-- 
    Document   : index
    Created on : 14 May 2013, 7:50:20 PM
    Author     : linda
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
        <h1>Changed</h1>
    </body>
    
    <h1>Payments</h1>
    <c:forEach var="payments" items="${payments}">
        ${payments.amount}
    </c:forEach>
    
</html>
