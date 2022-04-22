<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

	<div class="container">
		<header>
		<h1>Expense Details</h1>
		<a href="/expenses">Regresar</a>
		</header>
		
		<table class="table">
  
    <tr>
      <th scope="col">Expense Name:</th>
      <td scope="col"><c:out value="${gasto.getExpense_name() }" /></td>
    </tr>
    <tr>
      <th scope="row">Expense Description:</th>
      <td><c:out value="${gasto.getDescription() }" /></td>
    </tr>
    <tr>
      <th scope="row">Vendor</th>
      <td><c:out value="${gasto.getVendor() }" /></td>
    </tr>
    <tr>
      <th scope="row">Amount Spent</th>
      <td><c:out value="${gasto.getAmount() }" /></td>
    </tr>
</table>
		
		
	</div>

</body>
</html>