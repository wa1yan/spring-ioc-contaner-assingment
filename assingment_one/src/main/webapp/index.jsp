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
		<h1>Courses</h1>
		<c:url var="addCourse" value="/course-edit"></c:url>
		<a class="btn btn-primary mt-4" href="${addCourse}">Add New Course</a>
		<div class="mt-4">
			<c:choose>
				<c:when test=" ${ empty courses }">
					<div class="alert alert-warning">There is no course. Please
						create new course.</div>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Duration</th>
								<th>Fees</th>
								<th>Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="course" items="${ courses }" varStatus="stat">
								<tr>
									<td><c:out value="${stat.index + 1 }"></c:out></td>
									<td><c:out value="${course.name}"></c:out></td>
									<td><c:out value="${course.duration}"></c:out></td>
									<td><c:out value="${course.fees}"></c:out></td>
									<td><c:out value="${course.description}"></c:out></td>
									<td><c:url var="classes" value="/classes">
											<c:param name="courseId" value="${course.id}"></c:param>
										</c:url> <a href="${ classes }" class="btn btn-info">Open Classes</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>