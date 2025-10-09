package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.DTO.Product_DTO;
import com.shopping.util.JDBCConnection;

public class Product_DAO 
{
	private final static String insert_Product_Details=
			"insert into product_details(Product_Name, Product_Brand, Product_Price, Product_MF_Date, Product_EXP_Date, Product_Quantity, Product_Catagory, Product_Discount)"
			+ "values(?,?,?,?,?,?,?,?)";
	private final static String get_Product_Details="select * from product_details";
	
	public boolean insertProductDetails(Product_DTO product_DTO) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a14_ecommerse?user=root&password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(insert_Product_Details);
			preparedStatement.setString(1, product_DTO.getProduct_Name());
			preparedStatement.setString(2, product_DTO.getProduct_Brand());
			preparedStatement.setDouble(3, product_DTO.getProduct_Price());
			preparedStatement.setDate(4, product_DTO.getProduct_MF_Date());
			preparedStatement.setDate(5, product_DTO.getProduct_EXP_Date());
			preparedStatement.setInt(6, product_DTO.getProduct_Quantity());
			preparedStatement.setString(7, product_DTO.getProduct_Catagory());
			preparedStatement.setDouble(8, product_DTO.getProduct_Discount());
			int result=preparedStatement.executeUpdate();
			if(result!=0) return true;
			else return false;
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public List<Product_DTO> getProductDetails()
	{
		try {
			Connection connection = JDBCConnection.forMySqlConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(get_Product_Details);
			ResultSet resultSet= preparedStatement.executeQuery();
			List<Product_DTO> listOfProducts=new ArrayList<Product_DTO>();
			if(resultSet.isBeforeFirst()) {
				while(resultSet.next())
				{
					Product_DTO product_DTO=new Product_DTO();
					product_DTO.setProduct_Id(resultSet.getInt("Product_Id"));
					product_DTO.setProduct_Name(resultSet.getString("Product_Name"));
					product_DTO.setProduct_Brand(resultSet.getString("Product_Brand"));
					product_DTO.setProduct_Price(resultSet.getDouble("Product_Price"));
					product_DTO.setProduct_MF_Date(resultSet.getDate("Product_MF_Date"));
					product_DTO.setProduct_EXP_Date(resultSet.getDate("Product_EXP_Date"));
					product_DTO.setProduct_Quantity(resultSet.getInt("Product_Quantity"));
					product_DTO.setProduct_Catagory(resultSet.getString("Product_Catagory"));
					product_DTO.setProduct_Discount(resultSet.getDouble("Product_Discount"));

					listOfProducts.add(product_DTO);
				}
			}
			return listOfProducts;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
