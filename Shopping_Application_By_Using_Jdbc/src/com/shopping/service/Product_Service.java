package com.shopping.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.DAO.Product_DAO;
import com.shopping.DTO.Product_DTO;

public class Product_Service {
	
	Scanner sc=new Scanner(System.in);
	Product_DAO product_DAO=new Product_DAO();
	Product_DTO product_DTO=new Product_DTO();

	public void storeProductDetails() 
	{
		System.out.println("Enter product Name");
		String pname=sc.next();
		System.out.println("Enter product Brand");
		String pbrand=sc.next();
		System.out.println("Enter product Price");
		double pprice=sc.nextDouble();
		System.out.println("Enter product MF date");
		String pMFDate=sc.next();
		System.out.println("Enter Product EXP date");
		String pEXPDate=sc.next();
		System.out.println("Enter product quantity");
		int pQuantity=sc.nextInt();
		System.out.println("Enter product catogary");
		String pcatogary=sc.next();
		System.out.println("Enter product discount");
		double pdiscount=sc.nextDouble();
		
		product_DTO.setProduct_Name(pname);
		product_DTO.setProduct_Brand(pbrand);
		product_DTO.setProduct_Price(pprice);
		product_DTO.setProduct_MF_Date(Date.valueOf(pEXPDate));
		product_DTO.setProduct_EXP_Date(Date.valueOf(pEXPDate));
		product_DTO.setProduct_Quantity(pQuantity);
		product_DTO.setProduct_Catagory(pcatogary);
		product_DTO.setProduct_Discount(pdiscount);
		
		if(product_DAO.insertProductDetails(product_DTO)) System.out.println("Hey your product: " +pname+ " data is inserted...");
		else System.out.println("Your data is invalid.....");
	}
	
	public void insertProductBasedOnBrand() 
	{
		System.out.println("Enter product Brand");
		String pbrand=sc.next();
		System.out.println("Enter number of products under "+pbrand+" brand");
		int nop=sc.nextInt();
		
		while(nop>0)
		{
			System.out.println("Enter product Name");
			String pname=sc.next();
			System.out.println("Enter product Price");
			double pprice=sc.nextDouble();
			System.out.println("Enter product MF date");
			String pMFDate=sc.next();
			System.out.println("Enter Product EXP date");
			String pEXPDate=sc.next();
			System.out.println("Enter product quantity");
			int pQuantity=sc.nextInt();
			System.out.println("Enter product catogary");
			String pcatogary=sc.next();
			System.out.println("Enter product discount");
			double pdiscount=sc.nextDouble();
				product_DTO.setProduct_Name(pname);
				product_DTO.setProduct_Brand(pbrand);
				product_DTO.setProduct_Price(pprice);
				product_DTO.setProduct_MF_Date(Date.valueOf(pEXPDate));
				product_DTO.setProduct_EXP_Date(Date.valueOf(pEXPDate));
				product_DTO.setProduct_Quantity(pQuantity);
				product_DTO.setProduct_Catagory(pcatogary);
				product_DTO.setProduct_Discount(pdiscount);
				
				if(product_DAO.insertProductDetails(product_DTO)) System.out.println("Hey your product: " +pname+ " data is inserted successfully...");
				else System.out.println("Your data is invalid.....");
				nop--;
		}
		}
	
	public List<Product_DTO> allProductDetails()
	{
		return product_DAO.getProductDetails();
	}
	}


