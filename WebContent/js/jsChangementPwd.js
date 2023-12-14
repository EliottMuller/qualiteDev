function verifyPassword(password) {
	if (password.length > 8) {
		let regex = /[A-z0-9&\(\)\[\]\{\}éàè"'ù*$-_,;.:]+/;
		return regex.test(password);
	} else {
		return false;
	}
}

$(document).ready(function() {
	$("input[type='text'][name='oldPwd']").change(function() {
		if ($("input[type='text'][name='oldPwd']").val().length > 0 && verifyPassword($("input[type='text'][name='oldPwd']").val())) {
			$(":text[name='newPwd']").prop('disabled', false);
		} else {
			$(":text[name='newPwd']").prop('disabled', true);
		}
	})
	$("input[type='text'][name='newPwd']").change(function() {
		if ($("input[type='text'][name='newPwd']").val().length > 0 && $("input[type='text'][name='newPwd']").val() != $("input[type='text'][name='oldPwd']").val() && $("input[type='text'][name='newPwd']").val() && verifyPassword($("input[type='text'][name='newPwd']").val())) {
			$(":text[name='newPwdConf']").prop('disabled', false);
		} else {
			$(":text[name='newPwdConf']").prop('disabled', true);
		}
	})
	$("input[type='text']").change(function() {
		if ($("input[type='text'][name='newPwdConf']").val() == $("input[type='text'][name='newPwd']").val() && $("input[type='text'][name='newPwdConf']").val().length > 0) {
			$(":submit[name='submit']").prop('disabled', false);
		} else {
			$(":submit[name='submit']").prop('disabled', true);
		}
	})
})