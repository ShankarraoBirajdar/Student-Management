<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/URL_TO_REACH_RESOURCES_FOLDER/css/App.css" />" rel="stylesheet">
<script src="<c:url value="/URL_TO_REACH_RESOURCES_FOLDER/js/App.js" />"></script>
<meta charset="UTF-8">
<title>Update Student</title>
</head>
<body>
	<div>
	<h1  align="center">Update Student</h1>
		<form:form action="save-student" method="post"
			modelAttribute="student">
			<label for="id">ID :</label>
			<form:input id="id" readonly="true" path="id" />
			<br />
			<label for="na">Name :</label>
			<form:input id="na" path="name" />
			<br />
			<label for="mb">Mobile :</label>
			<form:input id="mb" path="mobile" />
			<br />
			<label>Country :</label>
			<form:select path="country">
				<form:option value="India" label="India"></form:option>
				<form:option value="US" label="United State"></form:option>
				<form:option value="UK" label="United Kingdom"></form:option>
				<form:option value="SL" label="Sri lanka"></form:option>
			</form:select>
			<br />
			<input type="submit" value="Update" class="updateStudent">
		</form:form>
	</div>
</body>
</html>