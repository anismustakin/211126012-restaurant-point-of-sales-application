<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header/include.jsp" />

<body>

    <button class="btn btn-large btn-block btn-primary" type="button">This is The Landing Page for the Application Menu</button>

<center>
    <button class="btn btn-success btn-large" type="button"><a href="/restApplication">Home</a></button>
    <button class="btn btn-success btn-large" type="button"><a href="customerform">Create Customer</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="customers">List Customer</a></button>
</center>
<p></p>
<center>
    <table class="table table-hover">
        <caption> <h2>The Customers </h2></caption>
        <thead>
            <tr>
                <th>Customer Name</th>
                <th>Customer Code </th>
                <th>Edit 
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.customerfirstName}</td>
                    <td>${customer.customerlastName}</td>
                    <td>${customer.customerNumber} </td>
                    <td><a href="editcustomerform?id=${customer.id}"> Edit </a></td>
                    <td><a href="deletecustomer?customercodeId=${customer.id}"> Delete </a></td>
                </tr>

            </c:forEach>

        </tbody>


    </table>

</center>

</body>

<jsp:include page="../footer/include.jsp" />
