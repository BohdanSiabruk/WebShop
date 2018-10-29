const firstName = 'first-name-input';
const lastName = 'last-name-input';
const email = 'email-name-input';
const password = 'password-name-input';
const verifyPassword = 'password-verify-name-input';

const nameRegexp = /^[a-z ,.`-]{1,20}/i;
const passwordRegexp = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
const emailRegexp = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
const validate = (validateValue, message) => v => {
    if (v && validateValue(v)) return;

    return message;
};
const validationMap = {
    [firstName]: validate(v => nameRegexp.test(v), {
      message: 'First Name is not valid, should contains just letters',
      element: 'first-name-input'
    }),
    [lastName]: validate(v => nameRegexp.test(v), {
      message: 'Lats Name is not valid, should contains just letters',
      element: 'last-name-input'
    }),
    [email]: validate(v => emailRegexp.test(v), {
      message: 'Email is not valid, should be *****@**.**',
      element: 'email-name-input'
    }),
    [password]: validate(v => passwordRegexp.test(v), {
      message: 'Password should contain letters and at least one digit',
      element: 'password-name-input'
    }),
    [verifyPassword]: validate(v => v === document.getElementById(password).value, {
      message: "Verify password doesn't match password",
      element: 'password-verify-name-input'
    })
};

function registerCustomer() {
  const firstNameValue = document.getElementById(firstName).value;
  const lastNameValue = document.getElementById(lastName).value;
  const emailValue = document.getElementById(email).value;
  const passwordValue = document.getElementById(password).value;
  const verifyPasswordValue = document.getElementById(verifyPassword)
    .value;

  validateInput({ [firstName]: firstNameValue, [lastName]: lastNameValue, [email]: emailValue, [password]: passwordValue, [verifyPassword]: verifyPasswordValue });
}

function validateInput(input) {
  Object.keys(validationMap)
    .map(key => validationMap[key](input[key]))
    .filter(m => m)
    .forEach(message => displayError(message));
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
    element.previousElementSibling.innerHTML = '';
    element.removeAttribute('style');
  }
}
