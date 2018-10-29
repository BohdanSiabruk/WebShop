$(document).ready(function() {
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
        element: firstName
      }),
      [lastName]: validate(v => nameRegexp.test(v), {
        message: 'Lats Name is not valid, should contains just letters',
        element: lastName
      }),
      [email]: validate(v => emailRegexp.test(v), {
        message: 'Email is not valid, should be *****@**.**',
        element: email
      }),
      [password]: validate(v => passwordRegexp.test(v), {
        message: 'Password should contain letters and at least one digit',
        element: password
      }),
      [verifyPassword]: validate(v => v === $(`#${password}`).val(), {
        message: "Verify password doesn't match password",
        element: verifyPassword
      })
  };

  function registerCustomer() {
    const firstNameValue = $(`#${firstName}`).val();
    const lastNameValue = $(`#${lastName}`).val();
    const emailValue = $(`#${email}`).val();
    const passwordValue = $(`#${password}`).val();
    const verifyPasswordValue = $(`#${verifyPassword}`)
      .val();

    validateInput();

    console.log(`
        Register customer:
         - name: ${firstNameValue}
         - second name: ${lastNameValue}
         - email: ${emailValue}
         - password: ${passwordValue}
         - password verify: ${verifyPasswordValue}
    `);
  }

  function validateInput() {
    Object.keys(validationMap).forEach(validateInputData);
  }

  function displayError(errorData) {
    $(`#${errorData.element}`)
      .css('border-color', 'red')
      .before(`<span style="color:red;">${errorData.message}</span>`);
  }

  function validateInputData(elementId) {
    const element = $(`#${elementId}`);
    const validationResult = validationMap[elementId](element.val());

    if (validationResult && element.prev().length === 0) {
      displayError(validationResult);
    } else if (!validationResult) {
      element.css('border-color', '').prev().remove();
    }
  }

  $('.myButton').on('click', registerCustomer);
  $('#first-name-input').on('focusout', elementItem => validateInputData(elementItem.target.id));
  $('#last-name-input').on('focusout', elementItem => validateInputData(elementItem.target.id));
  $('#email-name-input').on('focusout', elementItem => validateInputData(elementItem.target.id));
  $('#password-name-input').on('focusout', elementItem => validateInputData(elementItem.target.id));
  $('#password-verify-name-input').on('focusout', elementItem => validateInputData(elementItem.target.id));
});
