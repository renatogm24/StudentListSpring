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
				<h3 class="text-danger">Class: ${classAux.getName()}</h3>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Student Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${classAux.getStudents()}">
							<tr>
								<td><a href="/students/${student.getId()}"><c:out
											value="${student.getName()}" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<a class="my-3 btn btn-sm btn-danger" href="/">Go back</a>
			</div>

		
		</div>
	</div>

</body>
</html>