package com.shopping.service;

import java.util.Scanner;

import com.shopping.DAO.Admin_DAO;
import com.shopping.DTO.Admin_DTO;
import com.shopping.exception.Admin_Data_invalid_Exception;
public class Admin_Service {
	Scanner sc=new Scanner(System.in);
	Admin_DAO admin_DAO=new Admin_DAO();
	Admin_DTO admin_DTO=new Admin_DTO();
	
	public void admin_Registration()
	{
		System.out.println("Enter admin Email Id");
		while(true)
		{
			String aemail=sc.next();
			try {
				if(!(aemail.endsWith("@gmail.com"))) throw new Admin_Data_invalid_Exception("Invalid Email Id");
				else {
					admin_DTO.setAdmin_Email_Id(aemail);
					break;
				}
			}
			catch (Admin_Data_invalid_Exception e) {
				System.out.println("Invalid Email id ...enter email id again....");
			}
		}
		
		System.out.println("Enter admin password");
		while(true)
		{
			String apassword=sc.next();
			try {
				if(apassword==null) throw new Admin_Data_invalid_Exception("Invalid Password");
				else {
					admin_DTO.setAdmin_Password(apassword);
					break;
				}
			}
			catch (Admin_Data_invalid_Exception e) {
				System.out.println("Invalid password Enter password again");
			}
		}
		System.out.println("Enter admin role");
		while(true)
		{
			String arole=sc.next();
			try {
				if(arole==null) throw new Admin_Data_invalid_Exception("Invalid Admin role");
				else {
					admin_DTO.setAdmin_Role(arole);
					break;
				}
			}
			catch (Admin_Data_invalid_Exception e) {
				System.out.println("Invalid Admin role ...enter admin role again..");
			}
		}
		if(admin_DAO.insert_Into_Admin_Details(admin_DTO))System.out.println("Hey...your details are inserted...");
		else System.out.println("Server 500");
	}
	
	public void adminLogin()
	{
		Product_Service product_Service=new Product_Service();
		System.out.println("Enter admin email id");
		String email=sc.next();
		System.out.println("Enter admin password");
		String passsword=sc.next();
		boolean adminLogin=admin_DAO.selectAdminDetailsByUsingEmailAndPAssword(email, passsword);
		
		if(adminLogin) {
			boolean condn=true;
			System.out.println("Admin login successful.....");
			System.out.println("Enter....\n 1.To insert product details \n 2.To insert product based on brand  \n 3.Exit");
			
			switch(sc.nextInt())
			{
			case 1:
			{
				System.out.println("Insert product details...");
				product_Service.storeProductDetails();
			}break;
			
			case 2:
			{
				System.out.println("Insert Product Basesd On Brand");
				product_Service.insertProductBasedOnBrand();
			}
			break;
			
			case 3:
			{
				condn=false;
				System.out.println("Here Is The main menu");
			}break;
			
			default:System.out.println("Choose valid option....");
			}
		}
	else System.out.println("Admin details are invalid.....");
		}
	}


