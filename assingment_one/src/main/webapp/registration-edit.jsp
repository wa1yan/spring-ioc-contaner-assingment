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
		
			<h1>Student Registration</h1>
				<c:url var="saveUrl" value="/registration-edit">
				</c:url>
				<form action="${saveUrl}" method="post">
					<input type="hidden" name="courseId" value="${course.id}" />
					<input type="hidden" name="classId" value="${classId}" />
					<div class="row">
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Course Name</label>
								<input disabled type="text" required="required"
									class="form-control" value="${ openClass.course.name }" />
									
							</div>
						</div>
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Teacher</label>
								<input disabled type="text" required="required"
									class="form-control" value="${ openClass.teacher }" />
									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Start Date</label>
								<input disabled type="text"  required="required"
									class="form-control" value="${ openClass.startDate }" />
									
							</div>
						</div>
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Fee</label>
								<input disabled type="text"  required="required"
									class="form-control" value="${ openClass.course.fees }" />
									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="mb-3">
								<label class="form-label">Student Name</label>
								<input type="text" name="student" placeholder="Enter Student name" required="required"
									class="form-control"/>
									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="mb-3">
								<label class="form-label">Phone</label>
								<input type="tel" name="phone" placeholder="Enter phone number" required="required"
									class="form-control" />
									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="mb-3">
								<label class="form-label">Email</label>
								<input type="email" name="email" placeholder="Enter email address" required="required"
									class="form-control" />
									
							</div>
						</div>
					</div>	
					<c:url var="back" value="/registration">
						<c:param name="courseId" value="${ course.id }"></c:param>
						<c:param name="classId" value="${classId}"></c:param>
					</c:url>
					<a href="${ back }" class="btn btn-danger">Cancel</a>				
					<input type="submit" value="Register" class="btn btn-primary" />
				</form>
			</div>
</body>
</html>