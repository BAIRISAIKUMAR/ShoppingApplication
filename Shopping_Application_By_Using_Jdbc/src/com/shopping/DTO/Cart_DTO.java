package com.shopping.DTO;

import java.io.Serializable;

public class Cart_DTO implements Serializable
{
	private int cart_Id;
	private int customer_Id;
	private int product_Id;
	private int product_Quantity;
	
	public Cart_DTO() {}

	public Cart_DTO(int cart_Id, int customer_Id, int product_Id, int product_Quantity) {
		super();
		this.cart_Id = cart_Id;
		this.customer_Id = customer_Id;
		this.product_Id = product_Id;
		this.product_Quantity = product_Quantity;
	}

	public int getCart_Id() {
		return cart_Id;
	}

	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
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
	
	public void display_Cart_Details()
	{
		System.out.println("Cart_Id: "+getCart_Id());
		System.out.println("Customer_Id: "+getCustomer_Id());
		System.out.println("Product_Id: "+getProduct_Id());
		System.out.println("Product_Quantity: "+getProduct_Quantity());
	}

	@Override
	public String toString() {
		return "Cart_Details [cart_Id=" + cart_Id + ", customer_Id=" + customer_Id + ", product_Id=" + product_Id
				+ ", product_Quantity=" + product_Quantity + "]";
	}
	
	

}
