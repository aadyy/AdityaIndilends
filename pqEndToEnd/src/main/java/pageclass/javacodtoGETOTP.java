package pageclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class javacodtoGETOTP {
	
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	static String otprecived="";
	
	public static void main(String[] args) {
//		getOtpFun("12000087");
//		pqLeadDetailsOffer("8126715818");
		Date currentdate=new Date();
		 System.out.println("current date is: "+currentdate);
		 String screenshotdata=currentdate.toString().replace(" ", "-").replace(":", "-");
		 System.out.println("updated date is: "+screenshotdata);
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
	public static void pqLeadDetailsOffer(String mobileNumber) {
		try {
		String query= "select UI.u_mobile_number,PQLD.PqLeadid,PLO.Nbfcid,* from user_information UI\r\n" + 
				"inner join pqleadsdetails PQLD ON PQLD.MobileNumber=UI.u_mobile_number\r\n" + 
				"inner join PqLeadoffers PLO ON PLO.PqLeadId=PQLD.PqLeadId where UI.u_mobile_number = '"+mobileNumber+"'";
		Connection con=DriverManager.getConnection(dbURL,dbuser,dbpassword);
		System.out.println("DB connected");
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
			String mobileno=res.getObject("u_mobile_number").toString();
			String userid=res.getObject("u_user_id").toString();
			String pqleadid=res.getObject("PqLeadid").toString();
			String nbfcid=res.getObject("Nbfcid").toString();
			System.out.println(nbfcid);
			System.out.println(pqleadid);
			System.out.println(mobileno);
			System.out.println(userid);
		}
		} catch (SQLException e) {e.printStackTrace();
		}
	}
	
}
