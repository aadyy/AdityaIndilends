package utilities;

import java.util.ArrayList;
public class GetdataForPL {
	
	static ExcelReader ex;
	public static ArrayList<Object[]> getTestDataUtilsFun() {
		
	ArrayList<Object[]> mydata=new ArrayList<Object[]>();
	ex=new ExcelReader("D:\\pldata.xlsx");	
	for (int i = 2; i <= ex.getRowCount("pl"); i++) {
		String name=ex.getCellData("pl", "name", i);
		System.out.println("user name from sheet: "+name);
		
		String email=ex.getCellData("pl", "email", i);
		System.out.println("user email from sheet: "+email);
		
		String pincode=ex.getCellData("pl", "pincode", i);
		System.out.println("user pincode from sheet: "+pincode);
		
		String company=ex.getCellData("pl", "companyname", i);
		System.out.println("user company_name from sheet: "+company);
		
		String salary=ex.getCellData("pl", "salary", i);
		System.out.println("user salary from sheet: "+salary);
		
		Object[] ob= {name,email,pincode,company,salary};
		mydata.add(ob);
		}
	return mydata;
	}
	
	
	
	public static ArrayList<Object[]> getTestDataForNewPL() {
		
		ArrayList<Object[]> newdata=new ArrayList<Object[]>();
		ex=new ExcelReader("D:\\pldata.xlsx");
		for (int i = 2; i <= ex.getRowCount("newpl"); i++) {
		String name=ex.getCellData("newpl", "name", i);
		System.out.println(name);
		String company=ex.getCellData("newpl", "companyname", i);
		System.out.println(company);
		String salary=ex.getCellData("newpl", "salary", i);
		System.out.println(salary);
		String pincode=ex.getCellData("newpl", "pincode", i);
		System.out.println(pincode);
		String pan=ex.getCellData("newpl", "pan", i);
		System.out.println(pan);
		String email=ex.getCellData("newpl", "email", i);
		System.out.println(email);
		
		Object[] obj= {name,company,salary,pincode,pan,email};
		newdata.add(obj);
		}
		return newdata;
	}
	
}
