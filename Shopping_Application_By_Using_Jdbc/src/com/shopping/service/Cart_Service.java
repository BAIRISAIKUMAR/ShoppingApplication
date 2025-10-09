package com.shopping.service;

import java.util.List;

import com.shopping.DAO.Cart_DAO;
import com.shopping.DTO.Cart_DTO;

public class Cart_Service
{
	Cart_DAO cart_DAO=new Cart_DAO();
	public List<Cart_DTO> allCartDetails()
	{
		return cart_DAO.getCartDetails();
	}
	
	
	public void addCartDetails(Cart_DTO cart_DTO)
	{
		if(cart_DAO.insertCartDetails(cart_DTO))System.out.println("Product added to the cart");
		else System.out.println("Server error 500");
	}
}
