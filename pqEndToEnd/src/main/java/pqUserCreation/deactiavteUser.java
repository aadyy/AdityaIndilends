package pqUserCreation;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageclass.Base;
import utilities.ExcelReader;
import utilities.GetOtp;

public class deactiavteUser extends Base {

	
	@BeforeTest(enabled = true)
	public void openurl() {
	try {
		loadBrowser("https://uatweb.indialends.com/dashboard/deactivate");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
		@Test
		private void deactivateUserFun() throws InterruptedException {
		ExcelReader excel=new ExcelReader("D:\\PQ_lead.xlsx");
		int count= excel.getRowCount("Sheet1");
		String mobilenumber = null;
		for (int i = 2; i <= count; i++) {
		 mobilenumber=excel.getCellData("Sheet1", "Mobile_number", i);
		 System.out.println("Mobile number is:"+mobilenumber);
		 System.out.println("Number of Rows :"+ count);
		}
		driver.findElement(By.id("userName")).sendKeys("User deactivation");
		driver.findElement(By.id("mobileNumber")).sendKeys(mobilenumber);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@class=\"checkbox_container\"]")).click();
		driver.findElement(By.id("deactivate-input-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Your offers are not relevant')]")).click();
		driver.findElement(By.id("reason-submit-btn")).click();
		
		String otp=GetOtp.getOtpviaMobilenumberFun(mobilenumber);
		System.out.println("The otp to deactivate user is: "+otp);
		
//			driver.findElement(By.id("txt_otp0")).sendKeys(otp);
//			driver.findElement(By.id("btn_verifyMobile")).click();
	
//		WebElement enterRegisterNum=driver.findElement(By.xpath("//span[contains(text(),\"Please enter a Registered mobile number!\")]"));
//		WebElement deactivateContent=driver.findElement(By.xpath("//p[contains(text(),\"Your account has now\")]"));
//		WebElement wrongOtp=driver.findElement(By.xpath("//span[contains(text(),\"Please enter a valid OTP !\")]"));
//
//		if (deactivateContent.isDisplayed()) {
//				System.out.println("User number has been deactivated succesfully");
//		}
//		else if (enterRegisterNum.isDisplayed()) {
//				System.out.println("Please enter register number");
//			}
//		else if (wrongOtp.isDisplayed()) {
//				System.out.println("user enterd wrong OTP");
//		}
}
}
