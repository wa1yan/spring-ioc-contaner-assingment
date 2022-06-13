<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-4">
		<h1>Registered Student for ${ course.name }</h1>
		<div class="mt-4">
			<c:url var="registerEdit" value="/registration-edit">
				<c:param name="courseId" value="${ course.id }"></c:param>
				<c:param name="classId" value="${classId}"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${ registerEdit }">Register</a>
		</div>
		<div class="row mt-4">
			<div class="col-12">

				<c:choose>
					<c:when test="${ empty registration }">
						<div>
							There is no student for ${ course.name } of ${ openClass.teacher }. Please register new student.
						</div>
					</c:when>
					<c:otherwise>
						<table class="table table-striped">
							<thead>
								<tr>
									<td>ID</td>
									<td>Student Name</td>
									<td>Phone</td>
									<td>Email</td>
									<td>Course Name</td>								
									<td>Teacher</td>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="r" items="${ registration }" varStatus="stat">
								<tr>
									<td>${	stat.index + 1 }</td>
									<td>${	r.student }</td>
									<td>${	r.phone }</td>
									<td>${	r.email }</td>
									<td>${	r.openClass.course.name }</td>
									<td>${	r.openClass.teacher }</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
				<a href="/">Home</a>
			</div>
		</div>
	</div>
</body>
</html>