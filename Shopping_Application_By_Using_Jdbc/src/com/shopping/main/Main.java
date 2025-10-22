package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.Admin_Service;
import com.shopping.service.Customer_Service;
import com.shopping.service.Product_Service;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Customer_Service customer_Service=new Customer_Service();
		welcome();
		boolean condn=true;
		while(condn)
		{
			System.out.println("Enter \n 1.For Admin Login \n 2.For Customer Registration \n 3.For Customer Login \n 4.Exit");
			switch(sc.nextInt())
			{
			case 1:
			{
				Admin_Service admin_Service=new Admin_Service();
				System.out.println("Admin Login");
				admin_Service.adminLogin();
			}   break;
					
			case 2: 
			{
				System.out.println("Customer registration");
				customer_Service.customer_Registration();
			} break;
					
		
			case 3: 
			{
				System.out.println("Customer Login");
				customer_Service.customerLogin();
				
			}break;
				
			case 4 :
			{
				System.out.println("Exit");
				thankYou();
				condn=false;
			}break;
			
			default:System.out.println("Invalid request");
			}
		}
	}
	
	private static void thankYou()
	{
		String thankyou="........Thank you...Visit again.....";
		for(int i=0;i<thankyou.length();i++)
		{
			System.out.print(thankyou.charAt(i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void welcome()
	{
		String welcome="****____**** Welcome to A14_Shopping____****";
		for(int i=0;i<welcome.length();i++)
		{
			System.out.print(welcome.charAt(i));
			try {
				Thread.sleep(50);
				}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
