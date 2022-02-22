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
			<div>
				<h3 class="text-danger">Student: ${student.getName()}</h3>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Class Name</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="classAux" items="${student.getClasses()}">
							<tr>
								<td><a href="/classes/${classAux.getId()}"><c:out
											value="${classAux.getName()}" /></a></td>
											<td> <a href="/students/retirar/${student.getId()}/${classAux.getId()}">Retirar</a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<h3 class="text-danger">Sign to class</h3>
				
				<form:form
				class="row g-2 justify-content-center bg-dark text-light py-4 px-3 rounded"
				action="/students/${student.getId()}/addClass" method="post">
				
				<select name="class_id">
					<c:forEach var="classAux" items="${classesNotSigned}">
						<option value="${classAux.getId()}">
							${classAux.getName()}
						</option>
					</c:forEach>
				</select>

				<button class="btn btn-primary mt-4" type="submit">Add
					Class to student</button>
			</form:form>
			</div>

		
		</div>
	</div>

</body>
</html>