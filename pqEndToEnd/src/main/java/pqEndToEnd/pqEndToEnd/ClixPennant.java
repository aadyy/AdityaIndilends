package pqEndToEnd.pqEndToEnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;

public class ClixPennant extends Base {
	
public ClixPennant(WebDriver idriver) {
		Base.driver=idriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class=\"btn btn-outline-primary ml-4 mt-lg-0 mt-5 d-lg-block d-none\"]")
	WebElement loginButton;
	@FindBy(id = "txt_mobile_number")
	WebElement loginnumber;
	@FindBy(id = "btnSendOTP")
	WebElement getOpt;
	@FindBy(id = "txtOtp0")
	WebElement insertotp;
	@FindBy(xpath = "//*[contains(text(),\"I hereby declare\")]")
	WebElement tandc;
	@FindBy(id = "btnVerifyOtp")
	WebElement verifyandClick;
	
	public void ClixPennanatJavaFun() throws InterruptedException {
	String str=UpdatePQDBvalues.recivedPquser;
	System.out.println("PQuser we received is:"+str);
	loginButton.click();
	loginnumber.sendKeys(str);
	getOpt.click();
	
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("user id is: "+useridforotp);
	System.out.println("The otp we received is :"+otp);
	insertotp.sendKeys(otp);
	tandc.click();
	verifyandClick.click();
	driver.findElement(By.xpath("//a[@class=\"btn btn-blue secondary\"]")).click();
	driver.findElement(By.id("prefil_no")).click();
	}

}
