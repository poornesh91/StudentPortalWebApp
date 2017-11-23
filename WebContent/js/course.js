function validateCourseFields(){
	if(document.getElementById("errorDiv")!== undefined){
		document.getElementById("errorDiv").style.display ="none";
	}
	if(document.getElementById("msgDiv") && document.getElementById("msgDiv").style){
		document.getElementById("msgDiv").style.display ="none";
	}
	if(isEmpty(document.getElementById("courseCode").value)){
		document.getElementById("errorMsg").innerHTML = "Please enter a course Code";
		document.getElementById("errorDiv").style.display ="inline";
		return false;
	}
	if(isEmpty(document.getElementById("courseName").value)){
		document.getElementById("errorMsg").innerHTML = "Please enter a course name";
		document.getElementById("errorDiv").style.display ="inline";
		return false;
	}
	if(isEmpty(document.getElementById("courseDesc").value)){
		document.getElementById("errorMsg").innerHTML = "Please enter a course Description";
		document.getElementById("errorDiv").style.display ="inline";
		return false;
	}
	return true;
}


function submitCourseForm(){
	document.getElementById("CourseForm").submit();
}