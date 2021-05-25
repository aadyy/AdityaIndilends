package pqEndToEnd.pqEndToEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.collect.Table.Cell;

import utilities.MypqSheetWrite;

public class javaExcelwrite {
	XSSFWorkbook workbook;
	public static void main (String [] args) throws IOException{
		javaExcelwrite obj=new javaExcelwrite();
		obj.javacodeMypqSheetWriteFun("111", "5675670013");
	}
	
	public void javacodeMypqSheetWriteFun(String userid,String mobilenumber)  {
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
		workbook = new XSSFWorkbook(fis);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} 
	
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Map<String, String[]> data = new TreeMap<String, String[]>();
		String[] alldata=data.put("1", new String[] { userid,mobilenumber,"400000","19.75","12","924013.100575945","924013.100575945","924013.100575945","924013.100575945","924013.100575945","2","6777"});
		Row row = sheet.createRow(1);
		row.createCell(0).setCellValue("111");
		
		try {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END OF WRITING DATA IN EXCEL");
	}

}
