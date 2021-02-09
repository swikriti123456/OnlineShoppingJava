package com.model;

public class user 
{
	private String firstName,lastName,email,address,mobileNumber,password,role,code;
	private int uid;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String code) {
		super();
		
		this.code=code;
	
	}
	public user(int uid,String firstName, String lastName, String email, String address, String mobileNumber, String password,
			String role) {
		super();
		this.role=role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.password = password;
	
		this.uid=uid;
	}
	public user(String firstName, String lastName, String email, String address, String mobileNumber, String password,
			String role) {
		super();
		this.role=role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.password = password;
	
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", password=" + password
				+ "]";
	}
	
	
}
