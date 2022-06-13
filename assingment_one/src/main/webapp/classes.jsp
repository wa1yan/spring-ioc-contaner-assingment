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
		<h1>Classes for ${ course.name }</h1>
		<div class="mt-4">
			<c:url var="addNew" value="/class-edit">
				<c:param name="courseId" value="${ course.id }"></c:param>
			</c:url>
			<a class="btn btn-primary" href="${ addNew }">Add New CLass</a>
		</div>
		<div class="row mt-4">
			<div class="col-12">

				<c:choose>
					<c:when test="${ empty classes }">
						<div>
							There is no classes for ${ course.name }. Please create new class.
						</div>
					</c:when>
					<c:otherwise>
						<table class="table table-striped">
							<thead>
								<tr>
									<td>ID</td>
									<td>Teacher</td>
									<td>Start Date</td>
									<td>Duration</td>
									<td>Fees</td>								
									<td>Description</td>
									<td>Action</td>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="c" items="${ classes }" varStatus="stat">
								<tr>
									<td>${	stat.index + 1 }</td>
									<td>${	c.teacher }</td>
									<td>${	c.startDate }</td>
									<td>${	c.course.duration }</td>
									<td>${	c.course.fees }</td>
									<td>${	c.course.description }</td>
									<td>
									<c:url var="registration" value="/registration">
										<c:param name="courseId" value="${ course.id }"></c:param>
										<c:param name="classId" value="${c.id}"></c:param>
									</c:url>
									<a href="${ registration }" class="btn btn-info">Student Registration</a>
									</td>
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