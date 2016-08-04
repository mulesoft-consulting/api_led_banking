package com.coast;

public class CustomerDemographicsRecord implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 21L;
	private String custId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String province;
	private String country;
	private int age;
	private String married;
	
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	
	
}
