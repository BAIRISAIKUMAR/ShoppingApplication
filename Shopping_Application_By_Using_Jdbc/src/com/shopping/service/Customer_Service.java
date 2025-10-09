package com.shopping.service;
import java.util.List;
import java.util.Scanner;
import com.shopping.DAO.CustomerDAO;
import com.shopping.DAO.Order_DAO;
import com.shopping.DAO.payment_DAO;
import com.shopping.DTO.Cart_DTO;
import com.shopping.DTO.Customer_DTO;
import com.shopping.DTO.Order_DTO;
import com.shopping.DTO.Product_DTO;
import com.shopping.exception.CustomerDataInvalidException;

public class Customer_Service {
	
	Scanner sc=new Scanner(System.in);
	CustomerDAO customerDAO=new CustomerDAO();
	Product_Service product_Service=new Product_Service();
	Cart_Service cart_Service=new Cart_Service();
	Order_Service order_Service=new Order_Service();
	Customer_DTO customer_DTO;
	
	public void customer_Registration()
	{
		Customer_DTO customer_Details=new Customer_DTO();
		List<Customer_DTO> listOfCustomers =customerDAO.selectAllCustomerDetails();
		System.out.println("Enter customer name");
		String cname=sc.next();
		while(true)
		{
			System.out.println("Enter Customer Email_Id");
			String cemail=sc.next();
			long emailCount=listOfCustomers.stream().filter((customer)-> customer.getCusomer_Email_Id().equals(cemail)).count();
	
			try {
				if(!cemail.endsWith("@gmail.com")) throw new CustomerDataInvalidException("Invalid email id");
				if(emailCount>0) throw new CustomerDataInvalidException("Email already existed");
				else {
					customer_Details.setCusomer_Email_Id(cemail);
					break;
				}}
			
			catch (CustomerDataInvalidException  e) 
			{
				System.err.println(e.getException());
				System.out.println("Please provide the valid email id");
			}
		}
		
		
		System.out.println("Enter mobile number");
		while(true)
		{
			long cmob=sc.nextLong();
			long mobileCount=listOfCustomers.stream().filter((customer)->customer.getCustomer_Mobile_No()==cmob).count();

			try {
				if(!(cmob>=6000000000l && cmob<=9999999999l)) throw new CustomerDataInvalidException("Invalid mobile number");
				if(mobileCount>0) throw new CustomerDataInvalidException("Mobile numebr already existed");
				else 
				{
					customer_Details.setCustomer_Mobile_No(cmob);
					break;
				}
			}
			catch (CustomerDataInvalidException e) 
			{
				System.err.println(e.getException());
				System.out.println("Please provide valid mobile number.....");
			}
		}
		
		System.out.println("Enter Customer address");
		String ca=sc.next();
		
		System.out.println("Enter customer gender");
		String cg=sc.next();
		if(!(cg.contains("male")|| cg.contains("female"))) throw new CustomerDataInvalidException("Invalid gender");
		
		System.out.println("Enter customer password");
		while(true)
		{
			String cp=sc.next();
			long passwordCount=listOfCustomers.stream().filter((customer)-> customer.getCustomer_Password().equals(cp)).count();
			try{
				if(cp==null) throw new CustomerDataInvalidException("Password is not empty");
				if(passwordCount>0) throw new CustomerDataInvalidException("password already existed");
				else {
					customer_Details.setCustomer_Password(cp);
					break;
				}
			}
			catch (CustomerDataInvalidException e) 
			{
				System.err.println(e.getException());
				System.out.println("Please provide valid password....");
			}
		}
		
		customer_Details.setCustomer_Name(cname);
		customer_Details.setCustomer_Address(ca);
		customer_Details.setCustomer_Gender(cg);
		
		if(customerDAO.insertCustomerDetails(customer_Details)) System.out.println("Hey... "+cname +" Your Registration successful ");
		else System.out.println("Server 500");
	}
	
	
	
	public void customerLogin() 
	{
		System.out.println("Enter customer email id or mobile number");
		String emailOrMobileNo=sc.next();
		System.out.println("Enter customer password");
		String password=sc.next();
		
		customer_DTO=customerDAO.selectCustomerDetailsByUsingEmailIdOrMobileNumberAndPassword(emailOrMobileNo, password);
		if(customer_DTO!=null) { System.out.println("Login successful");
		if(customer_DTO.getCustomer_Gender().equalsIgnoreCase("male")) System.out.println("Helloo mr's : "+customer_DTO.getCustomer_Name());
		if(customer_DTO.getCustomer_Gender().equalsIgnoreCase("female")) System.out.println("Helloo miss : "+customer_DTO.getCustomer_Name());
		
		System.out.println("Enter....\n 1.For All Product Details  \n 2.For Cart Details  \n 3.For Order Details");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:{
				System.out.println("Product Details");
				List<Product_DTO> allProductDetails=product_Service.allProductDetails();
				int i=1;
				for(Product_DTO product_DTO:allProductDetails)
				{
					System.out.println("slno: "+i++);
					System.out.println("Product Name: "+product_DTO.getProduct_Name());
					System.out.println("Product Brand: "+product_DTO.getProduct_Brand());
					System.out.println("Product Price: "+product_DTO.getProduct_Price());
					System.out.println("Product Category: "+product_DTO.getProduct_Catagory());
					System.out.println("Product MF Date: "+product_DTO.getProduct_EXP_Date());
					System.out.println("Product EXP Date: "+product_DTO.getProduct_EXP_Date());
					System.out.println("Product Discount: "+product_DTO.getProduct_Discount());
					System.out.println("....................................................");
				}
				System.out.println("select s.No To add to cart Or buy....");
				Product_DTO product_DTO=allProductDetails.get(sc.nextInt()-1);
				System.out.println("Product Name: "+product_DTO.getProduct_Name());
				System.out.println("Product Brand: "+product_DTO.getProduct_Brand());
				System.out.println("Product Price: "+product_DTO.getProduct_Price());
				System.out.println("Product Category: "+product_DTO.getProduct_Catagory());
				System.out.println("Product MF Date: "+product_DTO.getProduct_EXP_Date());
				System.out.println("Product EXP Date: "+product_DTO.getProduct_EXP_Date());
				System.out.println("Product Discount: "+product_DTO.getProduct_Discount());
				
				System.out.println("select \n 1.To add the product into cart \n 2.To Buy");
				switch (sc.nextInt()) {
				case 1:
				{
					System.out.println("Adding the product into cart");
					System.out.println("Enter Product quantity");
					int quantity=sc.nextInt();
					Cart_DTO cart_DTO=new Cart_DTO();
					cart_DTO.setCustomer_Id(customer_DTO.getCustomer_Id());
					cart_DTO.setProduct_Id(product_DTO.getProduct_Id());
					cart_DTO.setProduct_Quantity(quantity);
					cart_Service.addCartDetails(cart_DTO);
				}
					break;
				case 2:
				{
					Payment_Service payment_Service=new Payment_Service();
					Order_Service order_Service=new Order_Service();
					System.out.println("Purchaging the product from cart");
					System.out.println("Enter the product quantity...");
					int quantity=sc.nextInt();
					System.out.println("Product Name: "+product_DTO.getProduct_Name());
					System.out.println("Product Brand: "+product_DTO.getProduct_Brand());
					System.out.println("Product Price: "+product_DTO.getProduct_Price());
					System.out.println("Product catogary: "+product_DTO.getProduct_Catagory());
					double totalPrice= product_DTO.getProduct_Price()*quantity;
					double discount=totalPrice*product_DTO.getProduct_Discount()/100;
					double amountToPay=totalPrice-discount;
					System.out.println("Total Price: "+totalPrice);
					System.out.println("Total Discount: "+discount);
					System.out.println("Total amount should pay: "+amountToPay);
					System.out.println("..................................");
					if(payment_Service.paymentProcessDetails(customer_DTO.getCustomer_Id(),product_DTO.getProduct_Id(),amountToPay))
					{
						order_Service.addOrderDetails(customer_DTO.getCustomer_Id(), product_DTO.getProduct_Id(), quantity);
					}
					else System.err.println("Payment failed.......");
				}
					break;

				default: System.out.println("Invalid choice...enter again");
				}
				 
		}
		break;
		
		case 2:{
				System.out.println("Cart Details");
				List<Cart_DTO> allCartDetails=cart_Service.allCartDetails();
				System.out.println("Hello Mr/Miss "+customer_DTO.getCustomer_Name()+"....Here is your cart details");
				System.out.println("=============================================");
				for(Cart_DTO cart_DTO:allCartDetails)
				{
					if(customer_DTO.getCustomer_Id()==cart_DTO.getCustomer_Id())
					{
						System.out.println("Cart ID: "+cart_DTO.getCart_Id());
						System.out.println("Product ID: "+cart_DTO.getProduct_Id());
						System.out.println("Customer ID: "+cart_DTO.getCustomer_Id());
						System.out.println("Product Quantity: "+cart_DTO.getProduct_Quantity());
						System.out.println("---------------------------------------------------");
					}
					
				}
				
		}
		break;
		
		case 3:{
				System.out.println("Order Details");
				List<Order_DTO> allOrderDetails=order_Service.getOrderDetails();
				System.out.println("Hello Mr/Miss "+customer_DTO.getCustomer_Name()+"....Here is your Order details");
				for(Order_DTO order_DTO:allOrderDetails)
				{
					if(customer_DTO.getCustomer_Id()==order_DTO.getCustomer_Id())
					{
						System.out.println("Order ID: "+order_DTO.getOrder_Id());
						System.out.println("Customer ID: "+order_DTO.getCustomer_Id());
						System.out.println("Product ID: "+order_DTO.getProduct_Id());
						System.out.println("Product Quantity: "+order_DTO.getProduct_Quantity());
						System.out.println("Order Address: "+order_DTO.getOrder_Address());
						System.out.println("Order Date: "+order_DTO.getOrder_Date());
						System.out.println("------------------------------------------------");
					}
				}
		}
		break;
		default:System.out.println("Invalid choice....");
		}
		
		}
		else System.out.println("Invalid details......");
	}

}
