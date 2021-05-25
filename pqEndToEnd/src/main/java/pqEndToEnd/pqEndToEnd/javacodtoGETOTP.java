package pqEndToEnd.pqEndToEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class javacodtoGETOTP {
	
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	static String otprecived="";
	
	public static void main(String[] args) {
		getOtpFun("11999643");
	}
	
	public static void getOtpFun(String userid) {
	try {
			String getotpquery="select top 10 * from mobileverification_encryption where u_user_id ='"+userid+"'";
			Connection con=DriverManager.getConnection(dbURL,dbuser,dbpassword);
			System.out.println("Connected to DB to GETotp");
			PreparedStatement prpstmt=con.prepareStatement(getotpquery);
			ResultSet result=prpstmt.executeQuery();			
			while (result.next()) {
			otprecived=result.getObject("v_code").toString();
			System.out.println("The u_user_id is :"+result.getObject("u_user_id"));
			System.out.println("The OTP is :"+otprecived);
			}
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
		}
}
