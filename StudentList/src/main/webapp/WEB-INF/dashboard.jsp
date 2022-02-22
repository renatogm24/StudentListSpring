<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3 class="text-danger">All Classes</h3>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="classAux" items="${classes}">
							<tr>
								<td><a href="/classes/${classAux.getId()}"><c:out
											value="${classAux.getName()}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h3 class="text-center mb-3">Create a Class!</h3>
				<div class="mx-auto">
					<form:form
						class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
						action="/classes" method="post" modelAttribute="classObj">

						<form:label for="name" path="name" class="form-label">Name:</form:label>
						<form:errors path="name" class="text-danger" />
						<form:input type="text" path="name" class="form-control"
							id="name" />						
							
						<button class="btn btn-primary mt-4" type="submit">Submit</button>
					</form:form>
				</div>
			</div>

			<div class="col-sm-6">
			<h3 class="text-danger">All Students</h3>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${students}">
							<tr>
								<td><a href="/students/${student.getId()}"><c:out
											value="${student.getName()}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h3 class="text-center mb-3">Create a Student!</h3>
				<div class="mx-auto">
					<form:form
						class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
						action="/students" method="post" modelAttribute="student">

						<form:label for="name" path="name" class="form-label">Name:</form:label>
						<form:errors path="name" class="text-danger" />
						<form:input type="text" path="name" class="form-control"
							id="name" />						
							
						<button class="btn btn-primary mt-4" type="submit">Submit</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>