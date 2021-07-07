package pqUserCreation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import pageclass.Base;
import utilities.MypqSheetWrite;

public class CreatePquser extends Base{
	
	 String dbURL = Base.getPropertyFile("databasedata.properties","url");
	 String dbuser = Base.getPropertyFile("databasedata.properties","user");
	 String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	 String mobile=Base.randomMobile();
	 protected String UserId="";
	 public  String Mobileno="";
	 protected static Connection connection;
		
	 //@Test
	 public String createPQuserFun() throws InterruptedException {
	 try {
			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {
					CallableStatement callstmt = connection.prepareCall("{call prcCRMUserCreation(?,?,?,?,?)}");
					callstmt.setObject("mobilenumber", mobile); 
					callstmt.setObject("p_monthly_income", "50000"); 
					callstmt.setObject("u_emp_tpe", "1"); 
					callstmt.setObject("p_pincode", "110012");
					callstmt.setObject("Dob", "1990-10-10"); 

					System.out.println("---> User creation done <---");
					ResultSet result = callstmt.executeQuery();
					
					while (result.next()) {
			UserId=result.getObject("u_user_id").toString();
			Mobileno=result.getString("mobilenumber");
						System.out.println("User_Id :"+UserId);
						System.out.println("Mobile No: "+Mobileno);
						}
		
				} finally {
					connection.close();
				}

			} else {
				System.out.println("not able to Connect database");
			}
		} catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
		}
		//return UserId+" "+Mobileno;
		MypqSheetWrite.MypqSheetWritefun(UserId, Mobileno);
		return Mobileno;
}	
}
