<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		<h1>Add New Course</h1>
		
		<div class="row">
			<div class="col-4">
				<c:url var="saveUrl" value="/courses"></c:url>
				<form action="saveUrl" method="post">

					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							name="name" placeholder="Enter course name" required="required"
							class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label">Fee</label> <input type="text"
							name="fees" placeholder="Enter course fee" required="required"
							class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label">Duration</label> <input type="text"
							name="duration" placeholder="Enter course duration"
							required="required" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label">Description</label>
						<textarea name="description" cols="40" rows="4" required="required"
							class="form-control"></textarea>
					</div>
					<a href="/" class="btn btn-danger">Cancel</a>	
					<input type="submit" value="Save course" class="btn btn-primary" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>