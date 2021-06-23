package pqEndToEnd.pqEndToEnd;

import org.openqa.selenium.By;
import locatores.PLlocatores;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;

public class LoginPage extends Base {
	
	PLlocatores plloc;
	public void ClixPennanatLoginJavaFun() throws InterruptedException {
	plloc=new PLlocatores(driver);
	String str=UpdatePQDBvalues.recivedPquser;
	System.out.println("PQuser we received is:"+str);
	plloc.loginButton.click();
	plloc.loginnumber.sendKeys(str);
	plloc.getOpt.click();
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("user id is: "+useridforotp);
	System.out.println("The otp we received is :"+otp);
	plloc.insertotp.sendKeys(otp);
	plloc.tandc.click();
	plloc.verifyandClick.click();
	driver.findElement(By.xpath("//a[@class=\"btn btn-blue secondary\"]")).click();
	driver.findElement(By.id("prefil_no")).click();
	}
	
	
	

}
