<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-4">

		<h3>Add New Class for ${ course.name }</h3>
				<c:url var="saveUrl" value="/class-edit">
				</c:url>
				<form action="${saveUrl}" method="post">
					<input type="hidden" name="courseId" value="${course.id}" />
					<div class="row mt-4">
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Teacher</label>
								<input type="text" name="teacher" placeholder="Enter course teacher" required="required"
									class="form-control" />
									
							</div>
						</div>
							<div class="col-2">
								<div class="mb-3">
									<label class="form-label">Start Date</label>
									<input type="date" name="start" placeholder="Enter course start date" required="required"
										class="form-control" />
										
								</div>
						</div>
					</div>
					<div class="row">
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Duration</label>
								<input disabled type="number" placeholder="Enter course duration" required="required"
									class="form-control" value="${ course.duration }" />
									
							</div>
						</div>
						<div class="col-2">
							<div class="mb-3">
								<label class="form-label">Fee</label>
								<input disabled type="number" placeholder="Enter course fee" required="required"
									class="form-control" value="${ course.fees }"/>
									
							</div>
						</div>						
					</div>	
					<c:url var="back" value="/classes">
						<c:param name="courseId" value="${ course.id }"></c:param>
					</c:url>
					<a href="${ back }" class="btn btn-danger">Cancel</a>
					<input type="submit" value="Open Class" class="btn btn-primary" class="form-control"/>					
				</form>
			</div>
</body>
</html>