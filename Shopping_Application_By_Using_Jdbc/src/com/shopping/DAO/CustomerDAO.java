package com.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shopping.DTO.Customer_DTO;
import com.shopping.util.JDBCConnection;

public class CustomerDAO {
	private static final String insert="insert into customer_details(Customer_Name, Customer_EmailId, Customer_Mobile_Number, Customer_Address, Customer_Gender,Customer_Password) "
			+ "values(?,?,?,?,?,?)";
	private static final String select_All_Customer="select * from customer_details";
	private static final String customer_Login="select * from customer_details where (Customer_EmailId=? or Customer_Mobile_Number=?) and Customer_Password=?";
	
	
	public boolean insertCustomerDetails(Customer_DTO customer_Details)
	{
		try {
			Connection connection=JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(insert);
			preparedStatement.setString(1, customer_Details.getCustomer_Name());
			preparedStatement.setString(2, customer_Details.getCusomer_Email_Id());
			preparedStatement.setLong(3, customer_Details.getCustomer_Mobile_No());
			preparedStatement.setString(4, customer_Details.getCustomer_Address());
			preparedStatement.setString(5, customer_Details.getCustomer_Gender());
			preparedStatement.setString(6, customer_Details.getCustomer_Password());
			int result =  preparedStatement.executeUpdate();
			if(result!=0)return true;
			else return false;
			} 
		catch (SQLException | ClassNotFoundException e) 
		{
				e.printStackTrace();
				return false;
		}
		}
	
	
		public List<Customer_DTO> selectAllCustomerDetails() 
		{
			try {
				Connection connection=JDBCConnection.forMySqlConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(select_All_Customer);
				ResultSet resultSet=preparedStatement.executeQuery();
				ArrayList<Customer_DTO> listOfCustomers=new ArrayList<Customer_DTO>();
				while(resultSet.next())
				{
					Customer_DTO customer_DTO=new Customer_DTO();
					customer_DTO.setCusomer_Email_Id(resultSet.getString("Customer_EmailId"));
					customer_DTO.setCustomer_Mobile_No(resultSet.getLong("Customer_Mobile_Number"));
					customer_DTO.setCustomer_Password(resultSet.getString("Customer_Password"));
					listOfCustomers.add(customer_DTO);
				}
				return listOfCustomers;
				} 
			catch (SQLException | ClassNotFoundException e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			return null;
		}
		
		
		public Customer_DTO selectCustomerDetailsByUsingEmailIdOrMobileNumberAndPassword(String emailOrMobileNo,String password) 
		{
			try {
				Connection connection=JDBCConnection.forMySqlConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(customer_Login);
				preparedStatement.setString(1, emailOrMobileNo);
				preparedStatement.setString(2, emailOrMobileNo);
				preparedStatement.setString(3, password);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					Customer_DTO customer_DTO=new Customer_DTO();
					customer_DTO.setCusomer_Email_Id(resultSet.getString("Customer_EmailId"));
					customer_DTO.setCustomer_Id(resultSet.getInt("Customer_Id"));
					customer_DTO.setCustomer_Mobile_No(resultSet.getLong("Customer_Mobile_Number"));
					customer_DTO.setCustomer_Password(resultSet.getString("Customer_Password"));
					customer_DTO.setCustomer_Name(resultSet.getString("Customer_Name"));
					customer_DTO.setCustomer_Gender(resultSet.getString("Customer_Gender"));

					return customer_DTO;
				}
				else return null;

			} catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}


