package com.shopping.DTO;

import java.io.Serializable;
import java.sql.Date;

public class Product_DTO implements Serializable
{
	private int product_Id;
	private String product_Name;
	private String product_Brand;
	private double product_Price;
	private Date Product_MF_Date;
	private Date product_EXP_Date;
	private int product_Quantity;
	private String product_Catagory;
	private double product_Discount;
	
	public Product_DTO() {}
	
	public Product_DTO(int product_Id, String product_Name, String product_Brand, double product_Price,
			Date product_MF_Date, Date product_EXP_Date, int product_Quantity, String product_Catagory,
			double product_Discount) {
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Brand = product_Brand;
		this.product_Price = product_Price;
		this.Product_MF_Date = product_MF_Date;
		this.product_EXP_Date = product_EXP_Date;
		this.product_Quantity = product_Quantity;
		this.product_Catagory = product_Catagory;
		this.product_Discount = product_Discount;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Brand() {
		return product_Brand;
	}

	public void setProduct_Brand(String product_Brand) {
		this.product_Brand = product_Brand;
	}

	public double getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}

	public Date getProduct_MF_Date() {
		return Product_MF_Date;
	}

	public void setProduct_MF_Date(Date date) {
		Product_MF_Date = date;
	}

	public Date getProduct_EXP_Date() {
		return product_EXP_Date;
	}

	public void setProduct_EXP_Date(Date product_EXP_Date) {
		this.product_EXP_Date = product_EXP_Date;
	}

	public int getProduct_Quantity() {
		return product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	public String getProduct_Catagory() {
		return product_Catagory;
	}

	public void setProduct_Catagory(String product_Catagory) {
		this.product_Catagory = product_Catagory;
	}

	public double getProduct_Discount() {
		return product_Discount;
	}

	public void setProduct_Discount(double product_Discount) {
		this.product_Discount = product_Discount;
	}
	
	public void display_Product_Details()
	{
		System.out.println("Product Id: "+getProduct_Id());
		System.out.println("Product name: "+getProduct_Name());
		System.out.println("Product brand: "+getProduct_Brand());
		System.out.println("Product price: "+getProduct_Price());
		System.out.println("Product MF date: "+getProduct_MF_Date());
		System.out.println("Product exp date: "+getProduct_EXP_Date());
		System.out.println("Product quantity: "+getProduct_Quantity());
		System.out.println("Product catagory: "+getProduct_Catagory());
		System.out.println("Product discount: "+getProduct_Id());

	}

	@Override
	public String toString() {
		return "Product_Details [product_Id=" + product_Id + ", product_Name=" + product_Name + ", product_Brand="
				+ product_Brand + ", product_Price=" + product_Price + ", Product_MF_Date=" + Product_MF_Date
				+ ", product_EXP_Date=" + product_EXP_Date + ", product_Quantity=" + product_Quantity
				+ ", product_Catagory=" + product_Catagory + ", product_Discount=" + product_Discount + "]";
	}
	
	
	
	

}
