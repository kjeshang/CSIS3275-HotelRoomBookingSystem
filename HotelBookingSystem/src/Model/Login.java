package Model;

public class Login {
	
	private String username;
	private String password;
	
	public Login(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validLogin() {
		if(checkUsername() == true && checkPassword() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkUsername() {
		boolean status = false;
		if(getUsername().length() < 5) {
			status = false;
		}
		else {
			status = true;
		}
		return status;
	}
	
	private boolean checkPassword() {
		int numCount = 0;
		int numChar = 0;
		boolean status = false;
		if(getPassword().length() < 5) {
			status = false;
		}
		else {
			for(int i = 0; i < getPassword().length(); i++) {
				char ch = getPassword().charAt(i);
				if(Character.isDigit(ch)) {
					numCount++;
				}
				if(Character.isAlphabetic(ch)) {
					numChar++;
				}
			}
			if(numCount < 1 || numChar < 4) {
				status = false;
			}
			else {
				status = true;
			}
		}
		return status;
	}

	@Override
	public String toString() {
		return "Username: " + getUsername() + "\n" +
			   "Password: " + getPassword();
	}
}
