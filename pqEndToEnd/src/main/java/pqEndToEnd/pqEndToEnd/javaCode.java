package pqEndToEnd.pqEndToEnd;

import java.util.Random;
import utilities.ExcelReader;

public class javaCode {

	public static void main(String[] args) {
	javaCode obj=new javaCode();
	obj.javaCodeWriteinExcelFun();
	randomACMCid();
	obj.deactivateUserFun();
	}
	
	ExcelReader er=new ExcelReader("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
	
	public static String randomACMCid(){
  	  Random random = new Random();
		  int index = random.nextInt(20);
		  System.out.println(index);
		  String [] id = {"24975", "24974","24973","24972","24971","24970","24969","24968", "24967","24966",
				  		  "24965", "24964","24963","24962","24961","24960","24959","24958","24957","24956"};
	      String txt= id[index];
	      System.out.println(txt);
	      return txt;
	 }
	
	public void javaCodeWriteinExcelFun() {
		boolean insert= er.writeDataExcelFun("sheet1", "u_user_id", 2, "123456");
		System.out.println("data has been insterted :"+ insert);
	}
	
	public static void deactivateUserFun() {
		ExcelReader excel=new ExcelReader("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
		String mobilenumber=excel.getCellData("Sheet1", "Mobile_number", 2);
		System.out.println(mobilenumber);
	}
}
