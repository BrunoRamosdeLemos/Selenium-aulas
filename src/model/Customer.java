package model;

public class Customer {
	
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String company;
	private String address;
	private String city;
	private String state;
	private String postal_code;
	private String country;
	private String home_phone;
	private String mobile_phone;
	private String address_alias;
	
	
	public Customer(String first_name, String last_name, String email, String password, String company, String address,
			String city, String state, String postal_code, String country, String home_phone, String mobile_phone,
			String address_alias) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.company = company;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.country = country;
		this.home_phone = home_phone;
		this.mobile_phone = mobile_phone;
		this.address_alias = address_alias;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getAddress_alias() {
		return address_alias;
	}
	public void setAddress_alias(String address_alias) {
		this.address_alias = address_alias;
	}

	
	

}
