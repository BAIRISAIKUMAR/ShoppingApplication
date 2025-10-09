package com.shopping.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Order_DTO implements Serializable
{
	private int order_Id;
	private int customer_Id;
	private int product_Id;
	private int product_Quantity;
	private String order_Address;
	private Date Order_Date;
	
	public Order_DTO() {}

	public Order_DTO(int order_Id, int customer_Id, int product_Id, int product_Quantity, String order_Address,
			Date order_Date) {
		this.order_Id = order_Id;
		this.customer_Id = customer_Id;
		this.product_Id = product_Id;
		this.product_Quantity = product_Quantity;
		this.order_Address = order_Address;
		Order_Date = order_Date;
	}

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public int getProduct_Quantity() {
		return product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	public String getOrder_Address() {
		return order_Address;
	}

	public void setOrder_Address(String order_Address) {
		this.order_Address = order_Address;
	}

	public Date getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(Date Date) {
		Order_Date = Date;
	}
	
	
	public void display_Order_Details()
	{
		System.out.println("Order Id: "+getOrder_Id());
		System.out.println("Customer Id: "+getCustomer_Id());
		System.out.println("Product Id: "+getProduct_Id());
		System.out.println("Product quantity: "+getProduct_Quantity());
		System.out.println("Order Address: "+getOrder_Address());
		System.out.println("Order date: "+getOrder_Date());
		System.out.println("------------------------------");
	}

	@Override
	public String toString() {
		return "Order_Details [order_Id=" + order_Id + ", customer_Id=" + customer_Id + ", product_Id=" + product_Id
				+ ", product_Quantity=" + product_Quantity + ", order_Address=" + order_Address + ", Order_Date="
				+ Order_Date + "]";
	}
	
	
	
	
	
}
