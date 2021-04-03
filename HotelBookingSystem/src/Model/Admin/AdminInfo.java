package Model.Admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminInfo {
	
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	
	public AdminInfo(String firstName, String lastName, String address, String email, String phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
	}
	
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
		if(getFirstName().equals("") || getLastName().equals("") || getAddress().equals("") || getEmail().equals("") || getPhone().equals("")) {
			status = false;
		}
		else if(checkEmail() == false || checkPhone() == false) {
			status = false;
		}
		else {
			status = true;
		}
		return status;
	}
	
	private boolean checkEmail() {
//		boolean status = false;
		boolean status = true;
		if(getEmail().length() < 3) {
			status = false;
		}
		else {
			if(!getEmail().endsWith(".com") && !getEmail().endsWith(".ca")) {
				status = false;
			}
			else {
				String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
		                "[a-zA-Z0-9_+&*-]+)*@" +
		                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
		                "A-Z]{2,7}$";
		        Pattern p = Pattern.compile(regex);
		        Matcher m = p.matcher(getEmail());
		        status =  m.matches();
//				if(!getEmail().contains("@")) {
//					status = false;
//				}
//				else {
//					status = true;
//				}
			}
		}
		return status;
	}
	
	private boolean checkPhone() {
		boolean status = true;
		if(getPhone().length() < 10) {
			status = false;
		}
		else {
			String regex = "[0-9]+";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(getPhone());
	        status =  m.matches();
//			for(int i = 0; i < getPhone().length(); i++) {
//				char ch = getPhone().charAt(i);
//				if(!Character.isDigit(ch)) {
//					status = false;
//				}
//				else {
//					status = true;
//				}
//			}
		}
		return status;
	}
	
	@Override
	public String toString() {
		return "First Name: " + getFirstName() + "\n" +
			   "Last Name: " + getLastName() + "\n" +
			   "Address: " + getAddress() + "\n" +
			   "Email: " + getEmail() + "\n" +
			   "Phone: " + getPhone() + "\n"; 
	}
	
}
