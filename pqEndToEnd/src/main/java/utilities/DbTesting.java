package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pageclass.Base;

public class DbTesting {

	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	public static Connection connection;

	static public String mobile="";
	static public String lcityid="";

	public void adminleadobject(String mobilenumber) {

		try {
			String query= "select * from admin_Leads_object where l_mobile_no = '"+mobilenumber+"'";
			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("To fetch PQ leadDetails data DB connected");

			PreparedStatement prp=connection.prepareStatement(query);
			prp.execute();
			ResultSet res=prp.executeQuery();
			while (res.next()) {
				
				mobile=res.getObject("l_mobile_no").toString();
				lcityid=res.getObject("l_city_id").toString();
				String admin_id=res.getObject("admin_id").toString();
				System.out.println("l_city_ID :"+lcityid);
				System.out.println("MobileNumber :"+mobile);
				System.out.println("AdminID :"+admin_id);

				
				
				
			}
		} 
		catch (SQLException e) {e.printStackTrace();}
	}

}



