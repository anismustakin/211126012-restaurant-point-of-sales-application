<%-- 
    Document   : index
    Created on : Aug 13, 2013, 5:58:06 PM
    Author     : Linda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Welcome</h1>
		<a href="about.html"> About Us </a></span></span><a href="contact.html"> Contact Us </a><a href="menu.html"> Menu </a><a href="order.html"> Order Now </a></p>

        
    <h1> All our Customers</h1>
    
    <c:forEach var="customer" items="${customers}" >
        
        ${customers.name}
        
    </c:forEach>
    </body>
</html>
