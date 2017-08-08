package application;
import java.io.Serializable;
import java.lang.Throwable;
public abstract class Person implements Serializable{
	
	private String name;
	private String phoneNum;
	private String address;
	private String city;
	private String zipCode;
	private String state;
	private int idNo;
	
	public Person()
	{
		
	}
	
	public Person(String name, String phoneNum, 
			String address, String city,
			String zipCode, String state, int idNo) throws IllegalInput {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.idNo = idNo;
		
		if(name.length() == 0 || name == null)
		{
			throw new IllegalInput("The name field cannot be blank.");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String toString() {
		return "Person [name=" + name + ", phoneNum=" + phoneNum + ", address="
				+ address + ", city=" + city + ", zipCode=" + zipCode
				+ ", state=" + state + ", idNo=" + idNo + ", getName()="
				+ getName() + ", getPhoneNum()=" + getPhoneNum()
				+ ", getAddress()=" + getAddress() + ", getCity()=" + getCity()
				+ ", getZipCode()=" + getZipCode() + ", getState()="
				+ getState() + ", getIdNo()=" + getIdNo() + "]";
	}
	

}
