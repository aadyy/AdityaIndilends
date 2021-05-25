package pqUserCreation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import pqEndToEnd.pqEndToEnd.Base;

public class UpdatePQDBvalues {
	
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	static String acmcid=Base.randomACMCid();
	static public String PqLeadId="";
	static public String userId="";
	static public String guserId="";
	public static String recivedPquser="";
	static protected Connection connection;

	public static void CheckPqleadDetailsTableFun(String userid,String mobilenumber) {
		try {
			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the databaset to check check PQsetails & ceck eligibility");
				try {
				   System.out.println("Mobile no is:"+mobilenumber);
					String query = "select * from PqLeadsDetails where MobileNumber='"+mobilenumber+"'";
					System.out.println("query is: "+query);
					PreparedStatement pstmtmv = connection.prepareStatement(query);
					ResultSet result =pstmtmv.executeQuery();
					while (result.next()) {
					System.out.println("PQ lead id is :"+result.getObject("PqLeadId"));
					PqLeadId=result.getObject("PqLeadId").toString();
				}
					String query1 = "select * from user_information where u_mobile_number='"+mobilenumber+"'";
					System.out.println("query is: "+query1);
					PreparedStatement pstmtmv1 = connection.prepareStatement(query1);
					ResultSet result1 =pstmtmv1.executeQuery();
					while (result1.next()) {
					  System.out.println("G_User_ID is: "+result1.getObject("u_g_user_id"));
					  recivedPquser=result1.getObject("u_phone_number").toString();
					  guserId=result1.getObject("u_g_user_id").toString();
					  userId=result1.getObject("u_user_id").toString();
					  System.out.println("user id from UpdatePQDBvalues and userInfo Table :"+userId);
						}
				pstmtmv.close();
			}	 finally {
					connection.close();
			}

			} else {
				System.out.println("not able to Connect database");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	insertIntoACMCfun(mobilenumber, userId, PqLeadId);
	isEligiblefun(guserId);
	}
		
//	public static void updatePQDBvaluesFun(String UserId,String Mobileno,String PqLeadId) {
//		try {  
//			if(connection!=null) {
//			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
//			System.out.println("conected to DB for update query");
//			String query = "UPDATE  ameyo_customer_manager_contacts" + 
//	    "Set mobile_no="+Mobileno+",lead_id=800,campaign_id=230,u_user_id="+UserId+",PqLeadId="+PqLeadId+",admin_id= -1,created_date='2021-05-15 12:19:07.670',crdate='2021-05-15 12:19:07.670' where acmc_id="+acmcid;
//	    System.out.println("query is: "+query);
//		PreparedStatement updatequery = connection.prepareStatement(query);		
//		updatequery.executeQuery();	
//		updatequery.close();
//				} 
//	}catch (SQLException e) {
//				e.printStackTrace();
//				}
//		} 
	
public static void insertIntoACMCfun(String insMobileNumber,String insUserID,String insPqleadID) {
		try {
			String inserQuery="insert into ameyo_customer_manager_contacts(mobile_no,lead_id,campaign_id,u_user_id,PqLeadId,admin_id,created_date,crdate)"+"VALUES (?,?,?,?,?,?,?,?)";
			connection=DriverManager.getConnection(dbURL, dbuser, dbpassword);
			System.out.println("Connected to DB for Instert into ACMC");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 
			PreparedStatement prepStmt=connection.prepareStatement(inserQuery);
			System.out.println("insert query is :"+ inserQuery);
			
			prepStmt.setObject(1,insMobileNumber );
			prepStmt.setObject(2,800);
			prepStmt.setObject(3,230);
			prepStmt.setObject(4,insUserID );
			prepStmt.setObject(5,insPqleadID );
			prepStmt.setObject(6,-1);
			prepStmt.setObject(7,dtf.format(now));
			prepStmt.setObject(8,dtf.format(now));
   		  	prepStmt.executeQuery();
   		
		prepStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	public static void isEligiblefun(String isEliGuserID) {
		try {
			connection=DriverManager.getConnection(dbURL, dbuser, dbpassword);
			CallableStatement callstmt=connection.prepareCall("{call PrcGetIsPqEligible(?)}");
			callstmt.setObject("g_user_id",isEliGuserID);
			ResultSet result=callstmt.executeQuery();
			
			while (result.next()) {
			String str=result.getObject("pq_eligible").toString();
			System.out.println("is_eligible-->:"+str);				
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
				
}
