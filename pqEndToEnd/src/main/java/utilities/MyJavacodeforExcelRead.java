package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MyJavacodeforExcelRead {
	
	
	
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
		try {
			FileInputStream fis=new FileInputStream(file);
			Workbook workbook=WorkbookFactory.create(fis);
			Sheet sheet=workbook.getSheetAt(0);
//			Row row=sheet.getRow(0);
//			Cell cell=row.getCell(3);
//			System.out.println(cell);
			
	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
