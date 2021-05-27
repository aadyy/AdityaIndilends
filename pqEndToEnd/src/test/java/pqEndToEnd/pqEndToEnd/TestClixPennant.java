package pqEndToEnd.pqEndToEnd;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pqUserCreation.CreatePquser;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;
import utilities.GetdataForPL;

public class TestClixPennant extends Base {
	CreatePquser crPQuserObj;
	UpdatePQDBvalues updatepqobj;
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
	@Test(enabled = false)
	public void testClixPennantFun() throws InterruptedException {
	obj=new ClixPennant(driver);	
	obj.ClixPennanatJavaFun();
	}
	
//	@DataProvider(name = "getTestDataUtilsFu")
//	public Iterator<Object[]> getDataFromExcel() {
//	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
//	return iterate.iterator();
//	}

	@Test(enabled = true)
	public void ApplyPreQualifiedLoan() throws InterruptedException{
	driver.findElement(By.xpath("//li[@class=\"nav-item active\"]//a")).click();	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id=\"li_display_name\"]")).sendKeys("Aditya yadav");
	driver.findElement(By.id("email")).sendKeys("aditya@gmail.com");
	driver.findElement(By.id("pincode")).sendKeys("110030");
	driver.findElement(By.id("employment")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("div_employment_type")).click();
	driver.findElement(By.id("companyName")).sendKeys("IBM");
	Thread.sleep(4000);
	java.util.List<WebElement> list= driver.findElements(By.xpath("//ul[@class=\"dropdown-menu display-block\"]//li"));
		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i).getText();
			System.out.println("List of companies :"+str);
		}
	driver.findElement(By.xpath("//*[@id=\"a_loc1\"]")).click();
	driver.findElement(By.id("monthlyIncome")).sendKeys("50000");
	String str=updatepqobj.recivedPquser;
	driver.findElement(By.id("mobile")).sendKeys(str);
	driver.findElement(By.id("li_submit")).click();
	Thread.sleep(4000);
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("user id is: "+useridforotp);
	System.out.println("The otp we received is :"+otp);
	driver.findElement(By.id("txt_otp")).sendKeys(otp);
	Thread.sleep(4000);
	driver.findElement(By.id("control-indicator")).click();
	driver.findElement(By.id("btn_mobile_verify")).click();
	Thread.sleep(4000);
	driver.navigate().refresh();
	
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Adityayadav\\git\\AdityaIndilends\\pqEndToEnd\\screenshot\\ad.png"));
    } catch (IOException e) {
        System.out.println(e.getMessage());
    	}
    driver.findElement(By.xpath("//*[@class=\"wrapping text-l-sm sm-marg10l border-right-none-sm\"]")).click();
    driver.findElement(By.xpath("//*[@class=\"display-block font15\"]")).click();
    Thread.sleep(4000);
    //PAN FORM TO ADDITIONAL FORM
    driver.findElement(By.id("loanAmt")).sendKeys("500000");
    driver.findElement(By.xpath("//label[contains(text(),\"Male\")]")).click();
    driver.findElement(By.id("dob")).sendKeys("10/10/1990");
    Thread.sleep(3000);
    driver.findElement(By.id("panNo")).sendKeys("akopy4346h");
    Thread.sleep(3000);
    java.util.List<WebElement> li= driver.findElements(By.xpath("//*[@class=\"custom-select-trigger\"]"));
    for (int i = 0; i < list.size(); i++) {
		String stri=list.get(i).getText();
		System.out.println("List of companies :"+stri);
	}
    Select sc=new Select(driver.findElement(By.xpath("//select[@name=\"payMode\"]")));
    sc.selectByValue("bank transfer");
    driver.findElement(By.xpath("//div[@class=\"custom-select-menu sources opened\"]//descendant::div//span[contains(text(),\"Bank\")]")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("salary-account-bank")).click();
    driver.findElement(By.id("bankname")).sendKeys("ICICI");
    Thread.sleep(4000);
    driver.findElement(By.xpath("//ul[@id=\"companynamedata\"]//li[contains(text(),\"ICICI BANK LTD\")]")).click();
    driver.findElement(By.id("address1")).sendKeys("Current address line1");
    driver.findElement(By.id("address2")).sendKeys("Current address line2");
    driver.findElement(By.id("btnPanForm")).click();
    
    
    
}	
}
