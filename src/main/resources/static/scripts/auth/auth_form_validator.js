authForm = document.getElementById("auth__form");

let authValidator = {};

authValidator.loginField = document.getElementsByName("login")[0];
authValidator.passwordField = document.getElementsByName("password")[0];
authValidator.btn = document.getElementsByClassName("auth__buttons")[0].getElementsByTagName("button")[0];


authValidator.btn.onclick = function() {
	if (authValidator.validate() == true) {
		authForm.submit();
	}
}

authValidator.validate = function validate() {
	authValidator.removeErrorBlock();

	const passwordRE = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/
	const loginRE = /^[a-zA-Z][a-zA-Z0-9-_\.]{7,25}$/

	if (authValidator.loginField.value == "") {
		authValidator.outputErrorMessage("Введите логин.");
		return false;
	}

	if (authValidator.loginField.value.length > 25 || authValidator.loginField.value.length < 8) {
		authValidator.outputErrorMessage("Логин должен быть длиною от 8 до 25 символов.");
		return false;
	}

	if (loginRE.test(authValidator.loginField.value) == false) {

		authValidator.outputErrorMessage("Допустимые символы для логина: a-zA-Z0-9.");
		return false;
	}



	if (authValidator.passwordField.value == "") {
		authValidator.outputErrorMessage("Введите пароль.");
		return false;
	}

	if (authValidator.loginField.value.length > 25 || authValidator.loginField.value.length < 8) {
		authValidator.outputErrorMessage("Логин должен быть длиною от 8 до 25 символов.");
		return false;
	}

	if (passwordRE.test(authValidator.passwordField.value) == false) {
		authValidator.outputErrorMessage("Допустимые символы для пароля: a-zA-Z0-9, спецсимволы.");
		return false;
	}

	return true;
}

authValidator.outputErrorMessage = function outputErrorMessage(message) {
	linkBlock = document.getElementsByClassName("auth__links")[0];

	childNode = document.createElement("div")
	childNode.classList.add("auth__error");
	childNode.innerHTML = message;


	parentBlock = linkBlock.parentNode;

	parentBlock.insertBefore(childNode, linkBlock);
}

authValidator.removeErrorBlock = function removeErrorBlock() {
	errorBlocks = document.getElementsByClassName("auth__error");

	if (errorBlocks.length == 0) return;

	for (let i = 0; i < errorBlocks.length; i++){
		errorBlocks[i].remove();
	}
}


formFields = authForm.getElementsByClassName("field");

Array.from(formFields).forEach(function(element){
	element.addEventListener("click", function() {
		authValidator.removeErrorBlock();
	});
});