package com.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.DTO.Cart_DTO;
import com.shopping.util.JDBCConnection;

public class Cart_DAO 
{
	private static final String getCartDetails="select * from cart_details";
	private static final String insertCartDetails="insert into cart_details(Product_Id, Customer_Id, Product_Quantity) values(?,?,?)";
	
	public List<Cart_DTO> getCartDetails() {
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(getCartDetails);
			ResultSet resultSet= preparedStatement.executeQuery();
			List<Cart_DTO> listOfItems=new ArrayList<Cart_DTO>();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					Cart_DTO cart_DTO=new Cart_DTO();
					cart_DTO.setCart_Id(resultSet.getInt("Cart_Id"));
					cart_DTO.setProduct_Id(resultSet.getInt("Product_Id"));
					cart_DTO.setCustomer_Id(resultSet.getInt("Customer_Id"));
					cart_DTO.setProduct_Quantity(resultSet.getInt("Product_Quantity"));

					listOfItems.add(cart_DTO);
				}
			}
			return listOfItems;
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		return null;
	}
	
	public boolean insertCartDetails(Cart_DTO cart_DTO) {
		try {
			Connection connection= JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(insertCartDetails);
			preparedStatement.setInt(1, cart_DTO.getProduct_Id());
			preparedStatement.setInt(2, cart_DTO.getCustomer_Id());
			preparedStatement.setInt(3, cart_DTO.getProduct_Quantity());
			int result=preparedStatement.executeUpdate();
			if(result!=0) return true;
			else return false;
		}
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
	}
}
