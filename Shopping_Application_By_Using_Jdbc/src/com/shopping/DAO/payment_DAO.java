package com.shopping.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.shopping.DTO.Payment_DTO;
import com.shopping.util.JDBCConnection;

public class payment_DAO
{
	private static final String insertPaymentDetails="insert into payment_details(Customer_Id, Product_Id, Payment_Type, Payment_Status, Amount, Payment_Date)"
			+ "values(?,?,?,?,?,?)";
	public boolean insertIntoPaymentDetails(Payment_DTO payment_DTO) {
		try {
			Connection connection= JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(insertPaymentDetails);
			preparedStatement.setInt(1, payment_DTO.getCustomer_Id());
			preparedStatement.setInt(2, payment_DTO.getProduct_Id());
			preparedStatement.setString(3, payment_DTO.getPayment_Tyoe());
			preparedStatement.setString(4, payment_DTO.getPayment_Status());
			preparedStatement.setDouble(5, payment_DTO.getAmount());
			preparedStatement.setDate(6, Date.valueOf(payment_DTO.getPayment_Date()));
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
