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
		Object[] ob= {name,email};
		mydata.add(ob);
		}
	return mydata;
	}
}
