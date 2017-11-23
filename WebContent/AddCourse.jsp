<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Course</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<script src="js/core.js"></script>
<script src="js/course.js"></script>
<style>
body {
	padding-top: 5rem;
}
</style>

<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="index.html">Add Course Details</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#StudentMenu" aria-controls="StudentMenu"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="StudentPortalMenu">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.html">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown01"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Course</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a class="dropdown-item" href="AddCourse.jsp">Add</a> <a
							class="dropdown-item" href="courses">View All</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown01"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Students</a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a class="dropdown-item" href="getAllCourses">Add</a> <a class="dropdown-item"
							href="students">View All</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<form name="CourseForm" id="CourseForm" action="courses"
			method="post">
			<%
				if (request.getAttribute("ACTION_KEY") != null) {
			%>
			<div class="row" style="margin-left: 15px;">
				<div class="<%=(String) request.getAttribute("ACTION_KEY")%> col-lg-11"
					role="alert" id="msgDiv">
					<%=(String) request.getAttribute("ACTION_VALUE")%>
				</div>
			</div>
			<%
				}
			%>
			<div class="row" style="margin-left: 15px;">
				<div class="alert alert-danger col-lg-11" role="alert"
					style="display: none;" id="errorDiv">
					<span id="errorMsg"></span>
				</div>
			</div>
			<div class="card border-info">
				<div class="card-header bg-info">Student Portal</div>
				<div class="card-block">
					<br />
					<div class="form-group row">
						<div class="col-lg-3 text-right">
							<label for="courseCode">Course Code</label>
						</div>
						<div class="col-lg-3">
							<input type="text" class="form-control" id="courseCode"
								name="courseCode" placeholder="Enter course code">
						</div>
					</div>

					<div class="form-group row">
						<div class="col-lg-3 text-right">
							<label for="courseCode">Course Name</label>
						</div>
						<div class="col-lg-3">
							<input type="text" class="form-control" id="courseName"
								name="courseName" placeholder="Enter course name">
						</div>
					</div>

					<div class="form-group row">
						<div class="col-lg-3 text-right">
							<label for="courseCode">Course Description</label>
						</div>
						<div class="col-lg-3">
							<input type="text" class="form-control" id="courseDesc"
								name="courseDesc" placeholder="Enter course description">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-lg-3">&nbsp;</div>
						<div class="col-lg-3">
							<button type="button" class="btn btn-info"
								onclick="return validateCourseFields();submitCourseForm();">Add
								Course</button>
						</div>
					</div>

					<br />
				</div>

			</div>

		</form>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
	integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</html>