package pqEndToEnd.pqEndToEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pqUserCreation.CreatePquser;
import utilities.GetdataForPL;

public class TestClixPennant extends Base {
	CreatePquser crPQuserObj;
	@BeforeTest
	private void openUrl() {
	try {
	crPQuserObj=new CreatePquser();
	crPQuserObj.createPQuserFun();
	Thread.sleep(5000);
	loadBrowser("https://uatweb.indialends.com"); 
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}	
	}
	
	ClixPennant obj;
	@Test(enabled = true)
	public void testClixPennantFun() throws InterruptedException {
	obj=new ClixPennant(driver);	
	obj.ClixPennanatJavaFun();
	}
	
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}
	@Test(dataProvider = "getTestDataUtilsFu")
	public void ApplyPreQualifiedLoan(String uname,String uemail) throws InterruptedException{
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id=\"li_display_name\"]")).sendKeys(uname);
	driver.findElement(By.id("email")).sendKeys(uemail);
	}
	
	@Test
	public void shortForm() {
	System.out.println("sort form definition");	
	}
}
