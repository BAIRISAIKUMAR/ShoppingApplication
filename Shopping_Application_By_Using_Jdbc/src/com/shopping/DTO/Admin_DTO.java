package com.shopping.DTO;

import java.io.Serializable;

public class Admin_DTO implements Serializable
{
	private int admin_Id;
	private String admin_Email_Id;
	private String admin_Password;
	private String admin_Role;
	
	public Admin_DTO() {}

	public Admin_DTO(int admin_Id, String admin_Email_Id, String admin_Password, String admin_Role)
	{
		this.admin_Id = admin_Id;
		this.admin_Email_Id = admin_Email_Id;
		this.admin_Password = admin_Password;
		this.admin_Role = admin_Role;
	}

	public String getAdmin_Email_Id() {
		return admin_Email_Id;
	}

	public void setAdmin_Email_Id(String admin_Email_Id) {
		this.admin_Email_Id = admin_Email_Id;
	}

	public String getAdmin_Password() {
		return admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		this.admin_Password = admin_Password;
	}

	public String getAdmin_Role() {
		return admin_Role;
	}

	public void setAdmin_Role(String admin_Role) {
		this.admin_Role = admin_Role;
	}

	public int getAdmin_Id() {
		return admin_Id;
	}

	public void display_Admin_Details()
	{
		System.out.println("Admin Id : "+getAdmin_Id());
		System.out.println("Admin email : "+getAdmin_Email_Id());
		System.out.println("Admin password: "+getAdmin_Password());
		System.out.println("Admin role : "+getAdmin_Role());

	}
	
	@Override
	public String toString() {
		return "Admin_Details [admin_Id=" + admin_Id + ", admin_Email_Id=" + admin_Email_Id + ", admin_Password="
				+ admin_Password + ", admin_Role=" + admin_Role + "]";
	}
	
	

}
