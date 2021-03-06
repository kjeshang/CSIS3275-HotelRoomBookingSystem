package Model.Guest;

public class GuestInfo {
	
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private String nationality;
	private String purposeOfStay;
	
	public GuestInfo(String firstName, String lastName, String address, String email, String phone, String nationality, String purposeOfStay) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setEmail(email);
		setPhone(phone);
		setNationality(nationality);
		setPurposeOfStay(purposeOfStay);
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
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getPurposeOfStay() {
		return purposeOfStay;
	}
	public void setPurposeOfStay(String purposeOfStay) {
		this.purposeOfStay = purposeOfStay;
	}
	
	public boolean validInfo() {
		boolean status = true;
		if(getFirstName().equals("") || getLastName().equals("") || getAddress().equals("") || getEmail().equals("") || getPhone().equals("") || getNationality().equals("") || getPurposeOfStay().equals("")) {
			status = false;
		}
		else {
			status = true;
		}
		return status;
	}

	@Override
	public String toString() {
		return "First Name: " + getFirstName() + "\n" +
			   "Last Name: " + getLastName() + "\n" +
			   "Address: " + getAddress() + "\n" +
			   "Email: " + getEmail() + "\n" +
			   "Phone: " + getPhone() + "\n" +
			   "Nationality: " + getNationality() + "\n" +
			   "Purpose of Stay: " + getPurposeOfStay();
	}
}
