<! DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="org.students.bean.CourseBean"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1,shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>View Courses</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="index.html">Student Portal</a>
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
						<a class="dropdown-item" href="getAllCourses">Add</a> <a
							class="dropdown-item" href="students">View Students</a><a
							class="dropdown-item" href="studentcoursesenrolled">View
							Student Courses</a>
					</div></li>
			</ul>
		</div>
	</nav>
	<div class="clearfix">
		<br /> <br /> <br /> <br />
	</div>
	<div class="container">
		<%
			if (request.getAttribute("COURSE_LIST") != null
					&& ((List<CourseBean>) request.getAttribute("COURSE_LIST")).size() > 0) {
		%>
		<table id="coursesTable" class="table clear-fix" cellspacing="0"
			width="100%">
			<thead class="table-success">
				<tr class="table-inverse">
					<th>ID</th>
					<th>Code</th>
					<th>Name</th>
					<th>Description</th>
					<th>Create date</th>
				</tr>
			</thead>
			<tbody>

				<%
					List<CourseBean> courses = (List<CourseBean>) request.getAttribute("COURSE_LIST");
						for (CourseBean courseBean : courses) {
				%>
				<tr class="table-warning">
					<td><%=courseBean.getId().longValue()%></td>
					<td><%=courseBean.getCode()%></td>
					<td><%=courseBean.getName()%></td>
					<td><%=courseBean.getDescription()%></td>
					<td><%=courseBean.getCreationDate()%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<%
			}
		%>

	<form name="ViewCoursesForm" id="ViewCoursesForm" action="viewCourseInfo" method="get">
	<br/>
		<div class="form-group row">
			<div class="col-lg-3">
				<button type="button" class="btn btn-info disabled" id="editButton" disabled="disabled">Edit
					Course</button>
			</div>
		</div>
	</div>
	<input type="hidden" name="courseId" id="courseId"/>
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

	<script type="text/javascript" class="init">
		$(document).ready(function() {
			var table = $('#coursesTable').DataTable({
				"pageLength" : 5
			});

			$('#coursesTable tbody').on('click', 'tr', function() {
				table.$('tr.table-info').addClass('table-warning');
				table.$('tr.table-info').removeClass('table-info');
				$(this).removeClass('table-warning');
				$(this).addClass('table-info');
				$('#editButton').removeClass('disabled');
				$('#editButton').removeAttr('disabled')
			});
			
			$('#editButton').click(function(){
				var data = table.rows('.table-info').data();
		        var formObj =$('#ViewCoursesForm');
		        $('#courseId').val(data[0][0]);
		        formObj.attr('action','viewCourseInfo?courseId='+data[0][0]).trigger('submit');
			});
		});
	</script>
</body>
</html>