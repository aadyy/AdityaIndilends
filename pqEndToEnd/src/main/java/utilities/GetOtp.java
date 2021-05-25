package utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pqEndToEnd.pqEndToEnd.Base;

public class GetOtp {
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	public static String otprecivedviUserID="";
	public static String otprecivedviaMobilenumber="";
	
	public static String getOtpViaUseridFun(String useridforOtp) {
		
		try {
			String getotpquery="select top 10 * from mobileverification_encryption where u_user_id ='"+useridforOtp+"'";
			Connection con=DriverManager.getConnection(dbURL,dbuser,dbpassword);
			System.out.println("Connected to DB to GETotp");
			if (con!=null) {
			PreparedStatement prpstmt=con.prepareStatement(getotpquery);
			ResultSet result=prpstmt.executeQuery();
			while (result.next()) {
			otprecivedviUserID=result.getObject("v_code").toString();
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return otprecivedviUserID;
		}
	
	public static String getOtpviaMobilenumberFun(String mobilenumber) {
		try {
			Connection connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
				try {
					CallableStatement pstmt = connection.prepareCall("{call PrcGetOtpLogForTestingTeam(?,?)}");
					pstmt.setObject("MobileNo", mobilenumber); 
					pstmt.setObject("PlainTextMobileNo", mobilenumber); 
					//System.out.println("Mobile no OTP Page: "+Mobile_no);
					ResultSet result = pstmt.executeQuery();

					while (result.next()) {					 
					otprecivedviaMobilenumber=String.valueOf(result.getObject(4));
					System.out.println("OTP is :"+otprecivedviaMobilenumber);	                
					}
					
				} finally {
					connection.close();
				}

			} 
		} catch (SQLException e) {
			System.out.println("Exception is:" + e.getMessage());
			e.printStackTrace();
			}
		return otprecivedviaMobilenumber;
		}
	
}
