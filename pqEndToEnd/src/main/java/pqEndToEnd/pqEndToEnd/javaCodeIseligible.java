package pqEndToEnd.pqEndToEnd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class javaCodeIseligible {

     static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	 static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	 static String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	 public static Connection connection;
	
	 public static void main(String[] args) {
		isEligiblefun();

	}
	public static void isEligiblefun() {
		try {
			connection=DriverManager.getConnection(dbURL, dbuser, dbpassword);
			CallableStatement callstmt=connection.prepareCall("{call PrcGetIsPqEligible(?)}");
			callstmt.setObject("g_user_id","E7A70155-926F-4A90-A9CD-49A09DEE2254");
			ResultSet result=callstmt.executeQuery();
			
			while (result.next()) {
				String UserId=result.getObject("pq_eligible").toString();
				System.out.println("is_eligible-->:"+UserId);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
