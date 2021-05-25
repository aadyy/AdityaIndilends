package pqEndToEnd.pqEndToEnd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class javaCodeGetotpviaPrc {
	
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	String Mobileno="7007007730";
	
	public static void main(String[] args) {
		javaCodeGetotpviaPrc obj=new javaCodeGetotpviaPrc();
		obj.getOtpFun();
	}
	
	public void getOtpFun() {
		try {
			Connection connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {
					CallableStatement pstmt = connection.prepareCall("{call PrcGetOtpLogForTestingTeam(?,?)}");
					pstmt.setObject("MobileNo", Mobileno); 
					pstmt.setObject("PlainTextMobileNo", Mobileno); 
					//System.out.println("Mobile no OTP Page: "+Mobile_no);
					ResultSet result = pstmt.executeQuery();

					while (result.next()) {					 
					String otp=String.valueOf(result.getObject(4));
					System.out.println(otp);	                
					}
					
				} finally {
					connection.close();
				}

			} 
		} catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
			}
		}
}

