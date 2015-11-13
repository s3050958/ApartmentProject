package th.co.aware.apartment.login;

public class LoginValidation {

	public int validate(String username, String password) {

		int n = 0;

		if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			n = 1;
		} else if (username.equalsIgnoreCase("user") && password.equalsIgnoreCase("user")) {
			n = 2;
		}

		return n;
	}

}
