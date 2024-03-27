package com.zsgs.librarymanagement.login;

class LoginModel {

	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void validateUser(String userName, String password) throws Exception {
		if (isValidUserName(userName)) {
			if (isValidPassword(userName,password)) {
				loginView.onSuccess();
			} else {
				loginView.onLoginFailed("Invalid password");
			}
		} else {
			loginView.onLoginFailed("Invalid User Name");
		}
	}

	private boolean isValidUserName(String userName) {
		return userName.equals("zsgs")||userName.equals("zsgsAdmin");
	}

	private boolean isValidPassword(String userName, String password) {
		return (userName.equals("zsgs")&&password.equals("admin"))||(userName.equals("zsgsAdmin")&&password.equals("admin123"));
	}
}
