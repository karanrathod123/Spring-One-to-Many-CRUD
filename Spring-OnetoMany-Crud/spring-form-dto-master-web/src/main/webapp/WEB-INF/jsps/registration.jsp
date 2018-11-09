<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form:form modelAttribute="studentForm" method="post" action="insert"
		class="form-horizontal">
		<fieldset>

			<legend>Student Details</legend>

			<form:input path="id" id="id" type="hidden"
				class="form-control input-md" />

			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Enter First
					Name</label>
				<div class="col-md-4">
					<form:input path="fname" id="name" type="text"
						class="form-control input-md" />
				</div>
			</div>


			<div class="form-group">
				<label class="col-md-4 control-label" for="lastname">Enter
					Last Name </label>
				<div class="col-md-4">
					<form:input path="lname" id="lname" type="text"
						class="form-control input-md" />
				</div>
			</div>



			<c:forEach items="${studentForm.addresslist}" var="address"
				varStatus="row">
				<!-- commandName and list in Student POJO -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="aid"></label>
					<div class="col-md-4">
						<form:input path="addresslist[${row.index}].id" id="aid"
							name="aid" type="hidden" class="form-control input-md"
							required="" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="location">Enter
						Location</label>
					<div class="col-md-4">
						<form:input id="address" path="addresslist[${row.index}].location"
							name="address" type="text" placeholder=""
							class="form-control input-md" required="" />

					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Enter
						City</label>
					<div class="col-md-4">
						<form:input id="address" path="addresslist[${row.index}].city"
							name="address" type="text" placeholder=""
							class="form-control input-md" required="" />

					</div>
				</div>
			</c:forEach>

			<!-- 	Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button id="" name="" class="btn btn-primary">Register</button>
				</div>
			</div>


		</fieldset>
	</form:form>

	<hr>

	<div class="container">
		<h2>Student Information</h2>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>FIRSTNAME</th>
					<th>LASTNAME</th>
					<th>Location</th>
					<th>City</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${studentList}" var="st">
					<tr>
						<td>${st.id}</td>
						<td>${st.fname}</td>
						<td>${st.lname}</td>
						<c:forEach items="${st.addresslist}" var="addrs">
							<td>${addrs.location}${addrs.city}</td>
						</c:forEach>

						<td><a href="edit?id=${st.id}">Edit</a></td>
						<td><a href="delete?id=${st.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>


	</div>



</body>
</html>