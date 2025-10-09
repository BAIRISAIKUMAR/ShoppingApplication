package com.shopping.DTO;

import java.io.Serializable;

public class Customer_DTO implements Serializable
{
	private int customer_Id;
	private String customer_Name;
	private String cusomer_Email_Id;
	private long customer_Mobile_No;
	private String Customer_Address;
	private String Customer_Gender;
	private String customer_Password;
	
	public Customer_DTO() {} 

	public Customer_DTO(int customer_Id, String customer_Name, String cusomer_Email_Id, long customer_Mobile_No,
			String customer_Address, String customer_Gender, String customer_Password) {
		this.customer_Id = customer_Id;
		this.customer_Name = customer_Name;
		this.cusomer_Email_Id = cusomer_Email_Id;
		this.customer_Mobile_No = customer_Mobile_No;
		this.Customer_Address = customer_Address;
		this.Customer_Gender = customer_Gender;
		this.customer_Password=customer_Password;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_Password() {
		return customer_Password;
	}

	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCusomer_Email_Id() {
		return cusomer_Email_Id;
	}

	public void setCusomer_Email_Id(String cusomer_Email_Id) {
		this.cusomer_Email_Id = cusomer_Email_Id;
	}

	public long getCustomer_Mobile_No() {
		return customer_Mobile_No;
	}

	public void setCustomer_Mobile_No(long customer_Mobile_No) {
		this.customer_Mobile_No = customer_Mobile_No;
	}

	public String getCustomer_Address() {
		return Customer_Address;
	}

	public void setCustomer_Address(String customer_Address) {
		Customer_Address = customer_Address;
	}

	public String getCustomer_Gender() {
		return Customer_Gender;
	}

	public void setCustomer_Gender(String customer_Gender) {
		Customer_Gender = customer_Gender;
	}
	
	public void display_Customer_Details()
	{
		System.out.println("Customer Id: "+getCustomer_Id());
		System.out.println("Customer Name: "+getCustomer_Name());
		System.out.println("Customer Email: "+getCusomer_Email_Id());
		System.out.println("Customer Password: "+getCustomer_Password());
		System.out.println("Customer Mobile NO: "+getCustomer_Mobile_No());
		System.out.println("Customer Address: "+getCustomer_Address());
		System.out.println("Customer gender: "+getCustomer_Gender());

	}

	@Override
	public String toString() {
		return "Customer_Details [customer_Id=" + customer_Id + ", customer_Name=" + customer_Name
				+ ", cusomer_Email_Id=" + cusomer_Email_Id + ", customer_Mobile_No=" + customer_Mobile_No
				+ ", Customer_Address=" + Customer_Address + ", Customer_Gender=" + Customer_Gender
				+ ", customer_Password=" + customer_Password + "]";
	}

	
	
	

	
}
