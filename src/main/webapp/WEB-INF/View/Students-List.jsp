<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- <link href="<c:url value="/URL_TO_REACH_RESOURCES_FOLDER/css/App.css" />" rel="stylesheet"> --%>
<%-- <script src="<c:url value="/URL_TO_REACH_RESOURCES_FOLDER/js/App.js" />"></script> --%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Students-List</title>
</head>
<body>
<div class="container">
<h1 align="center">Students Data</h1>
<form action="addStudent">
<input type="submit" value="Add New Student" class="btn btn-success btn-lg">
</form>
<br/>
<div class="table-responsive">
<table border="1px" class="table align-middle">
<thead class="table-dark">
<tr>
<th>Id</th><th>Name</th><th>Mobile</th><th>Country</th><th>Update</th><th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach var="student" items="${students}">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.mobile}</td>
<td>${student.country}</td>
<td><a href="${pageContext.request.contextPath}/updateStudent?userid=${student.id}"><input type="button" value="Update" class="btn btn-outline-primary"></a></td>
<td><a href="${pageContext.request.contextPath}/deleteStudent?userid=${student.id}" onclick="if(!(confirm('Are you sure you want to delete this student ?'))) return false"><input type="button" value="Delete" class="btn btn-outline-danger"></a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>