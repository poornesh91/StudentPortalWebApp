function validateStudentFields() {
	if (document.getElementById("errorDiv") !== undefined) {
		document.getElementById("errorDiv").style.display = "none";
	}
	if (document.getElementById("msgDiv")
			&& document.getElementById("msgDiv").style) {
		document.getElementById("msgDiv").style.display = "none";
	}
	if (isEmpty(document.getElementById("firstName").value)) {
		document.getElementById("errorMsg").innerHTML = "Please enter First Name";
		document.getElementById("errorDiv").style.display = "inline";
		return false;
	}
	if (isEmpty(document.getElementById("lastName").value)) {
		document.getElementById("errorMsg").innerHTML = "Please enter a Last name";
		document.getElementById("errorDiv").style.display = "inline";
		return false;
	}
	if (isEmpty(document.getElementById("ssn").value)) {
		document.getElementById("errorMsg").innerHTML = "Please enter ssn";
		document.getElementById("errorDiv").style.display = "inline";
		return false;
	}
	if (document.getElementById("courses").selectedIndex < 0) {
		document.getElementById("errorMsg").innerHTML = "Please select atleast one course";
		document.getElementById("errorDiv").style.display = "inline";
		return false;
	}
	
	document.getElementById("StudentForm").submit();
}

function isEmpty(str) {
	return (!str || 0 === str.length);
}
