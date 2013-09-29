<%-- 
    Document   : index
    Created on : Sep 29, 2013, 2:40:57 PM
    Author     : Linda
--%>

<jsp:include page="header/include.jsp" />

<body>
    <h1 class="header">Hello World!</h1>
    <h2> ${msg.welcome}</h2>
    <h3> Today is ${msg.today}</h3>
    <button class="btn btn-large btn-block btn-primary" type="button">This is The Landing Page for the Application Menu</button>

<center>
    <button class="btn btn-success btn-large" type="button"><a href="form">Create Customer</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="customers">List Customers</a></button>
</center>


</body>

<jsp:include page="footer/include.jsp" />

