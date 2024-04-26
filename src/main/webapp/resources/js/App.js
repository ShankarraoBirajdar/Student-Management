/**
 * 
 */

function validateForm() {

	if (validateUserName()) {
		return true;
	} else if (validateCrushName()) {
		return true;
	}
	else if (validateTermsAndConditions()) {
		return true;
	} else {
		return false;
	}
}
function validateUserName() {
	var userName = document.getElementById('un').value;

	if (userName.length < 3) {
		alert('User Name length should not less than 3');
		return false;
	}
	else {
		return true;
	}
}

function validateCrushName() {
	var userName = document.getElementById('cn').value;

	if (userName.length < 3) {
		alert('Crush Name length should not less than 3');
		return false;
	}
	else {
		return true;
	}
}

function validateTermsAndConditions() {
	var checkBox = document.getElementById('check');
	if (checkBox.checked == false) {
		alert('Please select the checkbox to agree	 our terms and conditions');
		return false;
	}
	else {
		return true;
	}
}