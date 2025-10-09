package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.DTO.Admin_DTO;

public class Admin_DAO
{
	Admin_DTO admin_DTO=new Admin_DTO();
	private static final String insert_Into_Admin_Details="insert into admin(Admin_Email_ID, Admin_Password, Admin_Role) values(?,?,?)";
	private static final String admin_Login="select * from admin where (Admin_Email_ID=?) and (Admin_Password=?)";
	
	public boolean insert_Into_Admin_Details(Admin_DTO admin_DTO) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a14_ecommerse?user=root&password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(insert_Into_Admin_Details);
			preparedStatement.setString(1, admin_DTO.getAdmin_Email_Id());
			preparedStatement.setString(2, admin_DTO.getAdmin_Password());
			preparedStatement.setString(3, admin_DTO.getAdmin_Role());
			int result=preparedStatement.executeUpdate();
			if(result!=0) return true;
			else return false;
			} 
		catch (SQLException | ClassNotFoundException e)
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		} 
	}
	
	public boolean selectAdminDetailsByUsingEmailAndPAssword(String email,String password)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a14_ecommerse?user=root&password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(admin_Login);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) return true;
			else return false;
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		
	}

}
