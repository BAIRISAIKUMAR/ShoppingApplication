package com.shopping.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.shopping.DAO.Order_DAO;
import com.shopping.DTO.Order_DTO;

public class Order_Service {
	
	Order_DTO order_DTO=new Order_DTO();
	Order_DAO order_DAO=new Order_DAO();
	public List<Order_DTO> getOrderDetails() {
		return order_DAO.getOrderDetails();
	}
	
	public void addOrderDetails(int cid,int pid,int quantity) {
		Scanner sc=new Scanner(System.in);
		order_DTO.setOrder_Date(Date.valueOf(LocalDate.now()));
		order_DTO.setCustomer_Id(cid);
		order_DTO.setProduct_Id(pid);
		order_DTO.setProduct_Quantity(quantity);

			System.out.println("select address to deliver the product  \n 1.Lingampalli  \n 2.Change address");
			switch(sc.nextInt())
			{
			case 1: {
				String address="Lingampalli";
				order_DTO.setOrder_Address(address);
				break;
			}
			case 2: 
				{
					System.out.println("Enter new Address");
					String address=sc.next();
					order_DTO.setOrder_Address(address);
				}
				break;
				
			default: System.out.println("Invalid choice....");
				break;
			}
		if(order_DAO.insertOrderDetails(order_DTO))System.out.println("Order placed successfully");
		else System.out.println("Server error 500");

		sc.close();
	}
	
//	System.out.println("Enter order address........");
//	String address=sc.next();
//	order_DTO.setOrder_Address(address);
//	if(order_DAO.insertOrderDetails(order_DTO)) System.out.println("Order Placed...");
//	else System.out.println("Order not placed.....");
//	if(payment_DAO.insertIntoPaymentDetails())System.out.println("Order placed");
//	else System.out.println("Order invalid");
//	

}
