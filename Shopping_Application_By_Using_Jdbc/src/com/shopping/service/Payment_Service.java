package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.DAO.payment_DAO;
import com.shopping.DTO.Payment_DTO;

public class Payment_Service {
	Scanner sc=new Scanner(System.in);
		payment_DAO payment_DAO=new payment_DAO();
		
		
		public boolean paymentProcessDetails(int cid,int pid, double amount) {
			Payment_DTO payment_DTO=new Payment_DTO();
			payment_DTO.setCustomer_Id(cid);
			payment_DTO.setPayment_Date(LocalDate.now());
			
			System.out.println("Enter \n 1.For UPI \n 2.Cash On Delivery \n 3.Debit Card \n 4.Net Banking \n 5.EMI ");
			switch(sc.nextInt())
			{
			case 1:{
				payment_DTO.setPayment_Tyoe("UPI");
				payment_DTO.setPayment_Status("Payment Success");
			}
			break;
			case 2:{
				payment_DTO.setPayment_Tyoe("Cash on delivery");
				payment_DTO.setPayment_Status("Under processing");
			}
			break;
			case 3:{
				payment_DTO.setPayment_Tyoe("Debit Card");
				payment_DTO.setPayment_Status("Payment Success");
			}
			break;
			case 4:{
				payment_DTO.setPayment_Tyoe("Net Banking");
				payment_DTO.setPayment_Status("Payment Success");
			}
			break;
			case 5:{
				payment_DTO.setPayment_Tyoe("EMI");
				payment_DTO.setPayment_Status("Under Processing");
			}
			break;
			default:System.out.println("Invalid Option.......");
			break;
		}
			System.out.println("Enter the amount to payyyy.....");
			double newamount=sc.nextDouble();
			if(amount==newamount) {
				payment_DTO.setCustomer_Id(cid);
				payment_DTO.setPayment_Date(LocalDate.now());
				payment_DTO.setProduct_Id(pid);
				payment_DTO.setAmount(newamount);
				if(payment_DAO.insertIntoPaymentDetails(payment_DTO)) {
					System.out.println("Order placed successfully");
					return true;
				}
				else System.out.println("Server error 500");
			}
			else System.out.println("Invalid amount");
			return false;
		}
		
	
	
}
