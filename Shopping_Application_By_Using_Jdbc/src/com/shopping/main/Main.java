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
		System.out.println("Enter \n 1.For Admin Login \n 2.For Customer Registration \n 3.For Customer Login ");
		switch(sc.nextInt())
		{
		case 1:
		{
			Admin_Service admin_Service=new Admin_Service();
			System.out.println("Admin Login");
			if(startingYesOrNo()) admin_Service.adminLogin();
			else thankYou();
		} break;
				
		case 2: 
		{
			System.out.println("Customer registration");
			if(startingYesOrNo()) customer_Service.customer_Registration();
			else thankYou();
		} break;
				
	
		case 3: 
		{
			System.out.println("Customer Login");
			if(startingYesOrNo()) customer_Service.customerLogin();
			else thankYou();
		}break;
				
		default:System.out.println("Invalid request");
		}
		sc.close();
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
	
	private static boolean startingYesOrNo()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Do You want to continue....Enter \n yes \n no");
		if(sc.next().equalsIgnoreCase("yes")) return true;
		else return false;
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
