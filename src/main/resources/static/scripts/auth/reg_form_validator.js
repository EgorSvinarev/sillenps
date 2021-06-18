regForm = document.getElementById("regirster_form");

let regValidator = {};

regValidator.loginField = document.getElementsByName("login")[1];
regValidator.passwordField = document.getElementsByName("password")[1];
regValidator.emailField = document.getElementsByName("email")[0];
regValidator.roleField = document.getElementsByName("role");
regValidator.btn = document.getElementsByClassName("reg__buttons")[0].getElementsByTagName("button")[0];

regValidator.btn.onclick = function() {
	if (regValidator.validate() == true) {
		regForm.submit();
	}
}

regValidator.validate = function validate() {
	regValidator.removeErrorBlock();

	const passwordRE = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/
	const loginRE = /^[a-zA-Z][a-zA-Z0-9-_\.]{7,25}$/
	const emailRE = /^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$/

	if (regValidator.loginField.value == "") {
		regValidator.outputErrorMessage("Введите логин.");
		return false;
	}

	if (regValidator.loginField.value.length > 25 || regValidator.loginField.value.length < 8) {
		regValidator.outputErrorMessage("Логин должен быть длиною от 8 до 25 символов.");
		return false;
	}

	if (loginRE.test(regValidator.loginField.value) == false) {
		regValidator.outputErrorMessage("Допустимые символы для логина: a-zA-Z0-9.");
		return false;
	}


	if (regValidator.passwordField.value == "") {
		regValidator.outputErrorMessage("Введите пароль.");
		return false;
	}

	if (regValidator.loginField.value.length > 25 || regValidator.loginField.value.length < 8) {
		regValidator.outputErrorMessage("Пароль должен быть длиною от 8 до 25 символов.");
		return false;
	}


	if (passwordRE.test(regValidator.passwordField.value) == false) {
		regValidator.outputErrorMessage("Допустимые символы для пароля: a-zA-Z0-9, спецсимволы.");
		return false;
	}



	if (regValidator.emailField.value == "") {
		regValidator.outputErrorMessage("Введите Email.");
		return false
	}

	if (emailRE.test(regValidator.emailField.value) == false) {
		regValidator.outputErrorMessage("Некорректный Email.");
		return false
	}

	if (regValidator.emailField.value.length > 255) {
		regValidator.outputErrorMessage("Недопустимая длина Email.");
		return false
	}

	if (!regValidator.isRoleSelected()) {
		regValidator.outputErrorMessage("Укажите статус пользователя.");
		return false;
	}

	return true;
}	

regValidator.isRoleSelected = function isRoleSelected() {
	let flag = false;

	for (let i = 0; i < regValidator.roleField.length; i++) {
		if (regValidator.roleField[i].checked) flag = true;
	}

	return flag;
}

regValidator.removeErrorBlock = function removeErrorBlock() {
	errorBlocks = document.getElementsByClassName("reg__error");

	if (errorBlocks.length == 0) return;

	for (let i = 0; i < errorBlocks.length; i++){
		errorBlocks[i].remove();
	}
}

regValidator.outputErrorMessage = function outputErrorMessage(message) {
	linkBlock = document.getElementsByClassName("reg__links")[0];

	childNode = document.createElement("div")
	childNode.classList.add("reg__error");
	childNode.innerHTML = message;


	parentBlock = linkBlock.parentNode;

	parentBlock.insertBefore(childNode, linkBlock);
} 