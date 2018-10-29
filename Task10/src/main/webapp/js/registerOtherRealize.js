const firstName = 'first-name-input';
const lastName = 'last-name-input';
const email = 'email-name-input';
const password = 'password-name-input';
const verifyPassword = 'password-verify-name-input';

const nameRegexp = /^[a-zA-Z ]+$/i;
const passwordRegexp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
const emailRegexp = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;

const validationMap = {
	'first-name-input': function firstNameValidator(value) {
		if (value && nameRegexp.test(value)) return;

		return {
			message: 'First Name is not valid, should contains just letters',
			element: 'first-name-input'
		}
	},
	'last-name-input': function lastNameValidator(value) {
		if (value && nameRegexp.test(value)) return;

		return {
			message: 'Lats Name is not valid, should contains just letters',
			element: 'last-name-input'
		}
	},
	'email-name-input': function emailValidator(value) {
		if (value && emailRegexp.test(value)) return;

		return {
			message: 'Email is not valid, should be *****@**.**',
			element: 'email-name-input'
		}
	},
	'password-name-input': function passwordValidator(value) {
		if (value && passwordRegexp.test(value)) return;

		return {
			message: 'Password should contain letters and at least one digit, min length = 8',
			element: 'password-name-input'
		}
	},
	'password-verify-name-input': function verifyPasswordValidator(value) {
		if (value && value === document.getElementById(password).value) return;

		return {
			message: "Verify password doesn't match password",
			element: 'password-verify-name-input'
		}
	}
};

function registerCustomer() {
	const inputs = document.getElementById('register-form').elements;

	validateInput(inputs);
}

function validateInput(inputs) {
	for (let i = 0; i < inputs.length - 1; i++) {
		validateInputData(inputs[i]);
	}
}

function displayError(errorData) {
	const element = document.getElementById(errorData.element);
	element.style.borderColor = 'red';

	const parentSpan = document.getElementById(errorData.element).parentElement;
	const messageSpan = document.createElement('span');
	const textNode = document.createTextNode(errorData.message);
	messageSpan.appendChild(textNode);
	messageSpan.style.color = 'red';

	parentSpan.insertBefore(messageSpan, element);
}

function validateInputData(element) {

	const validationResult = validationMap[element.id](element.value);

	if (validationResult && !element.previousElementSibling) {
		displayError(validationResult);
	} else if (!validationResult && element.previousElementSibling) {
		element.previousElementSibling.remove();
		element.removeAttribute('style');
}
}

document.getElementById("butt").addEventListener("click", registerCustomer);
document.getElementById(firstName).addEventListener("focusout", function () {
	validateInputData(document.getElementById(firstName));
});
document.getElementById(lastName).addEventListener("focusout", function () {
	validateInputData(document.getElementById(lastName));
});
document.getElementById(email).addEventListener("focusout", function () {
	validateInputData(document.getElementById(email));
});
document.getElementById(password).addEventListener("focusout", function () {
	validateInputData(document.getElementById(password));
});
document.getElementById(verifyPassword).addEventListener("focusout", function () {
	validateInputData(document.getElementById(verifyPassword));
});