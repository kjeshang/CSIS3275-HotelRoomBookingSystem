package Model.Admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminInfo {
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
//	private String username;
//	private String password;

	
	public AdminInfo(String firstName, String lastName, String address, String email, String phone /*,String username, String password*/) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
//		setUsername(username);
//		setPassword(password);
	}
	
/**	public String getUsername() {
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
**/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean validInfo() {
		boolean status = true;
		if(getFirstName().equals("") || getLastName().equals("") || getAddress().equals("") || getEmail().equals("") || getPhone().equals("") /*|| getUsername().equals("") || getPassword().equals("") */) {
			status = false;
		}
		else {
			status = true;
		}
		return status;
	}
	
	public boolean validatePhone(String number) {
		boolean status = true;
		String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(number);
        status =  m.matches();
        return status;
	}
	
	public boolean validateEmail(String email) {
		boolean status = true;
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        status =  m.matches();
        
        return status;
	}

	@Override
	public String toString() {
		return "First Name: " + getFirstName() + "\n" +
			   "Last Name: " + getLastName() + "\n" +
			   "Address: " + getAddress() + "\n" +
			   "Email: " + getEmail() + "\n" +
			   "Phone: " + getPhone() + "\n"; 
//			   " + Username: " + getUsername() + "\n" +
//			   "Password: " + getPassword();
	}

}
