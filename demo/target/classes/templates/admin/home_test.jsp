<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" th:href="@{/css/home.css}" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
	
		<form th:action="@{/logout}" method="get">
			<button class="btn btn-md btn-danger btn-block" name="registration"
				type="Submit">Logout</button>
		</form>    
		
		<div class="panel-group" style="margin-top:40px">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span th:utext="${userName}"></span>
				</div>
				<p class="admin-message-text text-center" th:utext="${adminMessage}"></p>
		<div align="center">
            <h1>Product List</h1>
                 <span th:utext="${listProducts}"></span>
            <table border="1">
                <th>Product ID</th>
                <th>Name</th>
                <th>Code</th>
                <th>Price</th>
                <th>Seller</th>
                <th>Action</th>
                <c:forEach items="${listProducts}" var="productout" varStatus="status">
                <tr>
           
                <c:out value = "${productout.productId}"/><p>
                <c:out value = "${productout.productName}"/><p>
                <c:out value = "${productout.code}"/><p>
                <c:out value = "${productout.price}"/><p>
                
                
<!--                     <td>${productout.productId}</td>
                    <td>${productout.productName}</td>
                    <td>${productout.code}</td>
                    <td>${productout.price}</td>
                    <td>${productout.seller}</td> -->
                    <td>
                         <form th:action="@{/admin/editproduct}" method="get">
							<button class="btn btn-md" name="edit PRODUCT"
							type="Submit">edit Product</button>
						</form>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/admin/deleteproduct?id=${productout.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
				
 		<form th:action="@{/admin/addproduct}" method="get">
		<button class="btn btn-md btn-danger btn-block" name="ADD PRODUCT"
				type="Submit">Add Product</button>
		</form>  
		</div>
		
	</div>
</body>
</html>