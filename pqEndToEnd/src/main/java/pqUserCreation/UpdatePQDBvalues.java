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

public class UpdatePQDBvalues extends Base{
	
	static String dbURL = Base.getPropertyFile("databasedata.properties","url");
	static String dbuser = Base.getPropertyFile("databasedata.properties","user");
	static  String dbpassword = Base.getPropertyFile("databasedata.properties","password");
	static protected Connection connection;
	
	public static String recivedPquser="";
	static public String userId="";
	static public String PqLeadId="";
	static public String nbfcid="";
	static public String guserId="";
	public static void CheckPqleadDetailsTableFun(String userid,String mobilenumber) {
	try {
		String query= "select UI.u_mobile_number,PQLD.PqLeadid,PLO.Nbfcid,* from user_information UI\r\n" + 
			"inner join pqleadsdetails PQLD ON PQLD.MobileNumber=UI.u_mobile_number\r\n" + 
			"inner join PqLeadoffers PLO ON PLO.PqLeadId=PQLD.PqLeadId where UI.u_mobile_number = '"+mobilenumber+"'";
			Connection con=DriverManager.getConnection(dbURL,dbuser,dbpassword);
			System.out.println("To fetch PQ leadDetails data DB connected");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while (res.next()) {
				recivedPquser=res.getObject("u_mobile_number").toString();
				userId=res.getObject("u_user_id").toString();
				guserId=res.getObject("u_g_user_id").toString();
				PqLeadId=res.getObject("PqLeadid").toString();
				nbfcid=res.getObject("Nbfcid").toString();
				System.out.println("NBFCID :"+nbfcid);
				System.out.println("PQleadID :"+PqLeadId);
				System.out.println("PQuser :"+recivedPquser);
				System.out.println("UserID :"+userId);
				System.out.println("GuserID :"+guserId);
			}
			} catch (SQLException e) {e.printStackTrace();
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
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	String inserQuery="insert into ameyo_customer_manager_contacts(mobile_no,lead_id,campaign_id,u_user_id,PqLeadId,admin_id,created_date,crdate)"+"VALUES (?,?,?,?,?,?,?,?)";
	PreparedStatement prepStmt;
	
	try {
		connection=DriverManager.getConnection(dbURL, dbuser, dbpassword);
		System.out.println("Connected to DB for Instert into ACMC");
				prepStmt=connection.prepareStatement(inserQuery);
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
			} 
			catch (SQLException e) {e.printStackTrace();}	
	
		
		 
}

	public static void isEligiblefun(String isEliGuserID) {
		try {
			connection=DriverManager.getConnection(dbURL, dbuser, dbpassword);
			CallableStatement callstmt=connection.prepareCall("{call PrcGetIsPqEligible(?)}");
			callstmt.setObject("g_user_id",isEliGuserID);
			ResultSet result=callstmt.executeQuery();
			
			while (result.next()) {
			System.out.println("PQ_User is_eligible-->: "+result.getObject("pq_eligible"));	

			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
				
}
