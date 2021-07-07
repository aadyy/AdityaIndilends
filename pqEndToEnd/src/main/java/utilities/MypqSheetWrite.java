package utilities;

import pageclass.Base;
import pqUserCreation.Pqsheetupload;

public class MypqSheetWrite extends Base {
	
	static ExcelReader excel=new ExcelReader("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
	public static void MypqSheetWritefun(String userid,String mobilenumber ) {
		
	try {
			excel.writeDataExcelFun("sheet1", "u_user_id", 2, userid);
			boolean bolleanmobilenumber= excel.writeDataExcelFun("sheet1", "Mobile_number", 2, mobilenumber);
			System.out.println("Data inserted to PQuserSheet? :"+ bolleanmobilenumber);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	try {
		Pqsheetupload.pqsheetuploadFun(userid, mobilenumber);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
