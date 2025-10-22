package com.shopping.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.DTO.Order_DTO;
import com.shopping.util.JDBCConnection;

public class Order_DAO 
{
	
	private static final String getDetails="select * from order_details";
	private static final String insertOrderDetails="insert into order_details(Customer_Id, Product_Id, Product_Quantity, Order_Address, Order_Date) values(?,?,?,?,?)";
	
	public List<Order_DTO> getOrderDetails() {
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(getDetails);
			ResultSet resultSet= preparedStatement.executeQuery();
			List<Order_DTO> lostOfOrders=new ArrayList<Order_DTO>();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					Order_DTO order_DTO=new Order_DTO();
					order_DTO.setOrder_Id(resultSet.getInt("Order_Id"));
					order_DTO.setCustomer_Id(resultSet.getInt("Customer_Id"));
					order_DTO.setProduct_Id(resultSet.getInt("Product_Id"));
					order_DTO.setProduct_Quantity(resultSet.getInt("Product_Quantity"));
					order_DTO.setOrder_Address(resultSet.getString("Order_Address"));
					order_DTO.setOrder_Date(resultSet.getDate("Order_Date"));
					lostOfOrders.add(order_DTO);
				
				}
			}
			return lostOfOrders;
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public boolean insertOrderDetails(Order_DTO order_DTO) {		
		try {
			Connection connection= JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(insertOrderDetails);
			preparedStatement.setInt(1, order_DTO.getCustomer_Id());
			preparedStatement.setInt(2, order_DTO.getProduct_Id());
			preparedStatement.setInt(3, order_DTO.getProduct_Quantity());
			preparedStatement.setString(4, order_DTO.getOrder_Address());
			preparedStatement.setDate(5, order_DTO.getOrder_Date());
			int result=preparedStatement.executeUpdate();
			if(result!=0) return true;
			else return false;
			} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
	}

}
