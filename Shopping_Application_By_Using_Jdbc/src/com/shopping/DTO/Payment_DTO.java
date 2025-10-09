package com.shopping.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment_DTO implements Serializable
{
	private int payment_Id;
	private int Customer_Id;
	private int product_Id;
	private String payment_Tyoe;
	private String payment_Status;
	private double amount;
	private LocalDate payment_Date;
	
	public Payment_DTO() {}

	public Payment_DTO(int payment_Id, int customer_Id, int product_Id, String payment_Tyoe, String payment_Status,
			double amount, LocalDate payment_Date) {
		this.payment_Id = payment_Id;
		Customer_Id = customer_Id;
		this.product_Id = product_Id;
		this.payment_Tyoe = payment_Tyoe;
		this.payment_Status = payment_Status;
		this.amount = amount;
		this.payment_Date = payment_Date;
	}

	public int getPayment_Id() {
		return payment_Id;
	}

	public void setPayment_Id(int payment_Id) {
		this.payment_Id = payment_Id;
	}

	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getPayment_Tyoe() {
		return payment_Tyoe;
	}

	public void setPayment_Tyoe(String payment_Tyoe) {
		this.payment_Tyoe = payment_Tyoe;
	}

	public String getPayment_Status() {
		return payment_Status;
	}

	public void setPayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPayment_Date() {
		return payment_Date;
	}

	public void setPayment_Date(LocalDate payment_Date) {
		this.payment_Date = payment_Date;
	}
	
	public void display_Payment_Details()
	{
		System.out.println("payment id: "+getProduct_Id());
		System.out.println("customer id: "+getCustomer_Id());
		System.out.println("Product id: "+getProduct_Id());
		System.out.println("payment type: "+getPayment_Tyoe());
		System.out.println("payment status: "+getPayment_Status());
		System.out.println("payment amount: "+getAmount());
		System.out.println("payment date: "+getPayment_Date());
	}

	@Override
	public String toString() {
		return "Payment_Details [payment_Id=" + payment_Id + ", Customer_Id=" + Customer_Id + ", product_Id="
				+ product_Id + ", payment_Tyoe=" + payment_Tyoe + ", payment_Status=" + payment_Status + ", amount="
				+ amount + ", payment_Date=" + payment_Date + "]";
	}
}
