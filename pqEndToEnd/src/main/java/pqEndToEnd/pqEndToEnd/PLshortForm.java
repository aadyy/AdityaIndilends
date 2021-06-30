package pqEndToEnd.pqEndToEnd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import locatores.PLlocatores;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;
import utilities.GetdataForPL;
import utilities.WebActions;

public class PLshortForm extends Base{
	
	PLlocatores plloc;
	UpdatePQDBvalues updatepqobj; 
	WebDriverWait wait;
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}

	public PLpanForm PlshortFormFun(String name,String email,String pincode,String company,String salary) throws InterruptedException {
	plloc=new PLlocatores(driver);
	wait=new WebDriverWait(driver, 20);
	plloc.personalLoan.click();
	plloc.username.sendKeys(name);
	plloc.emailid.sendKeys(email);
	plloc.pincode.sendKeys(pincode);
	plloc.employment.click();
	wait.until(ExpectedConditions.elementToBeClickable(plloc.salariedEmp));
	plloc.salariedEmp.click();
	plloc.companyName.sendKeys(company);
	Thread.sleep(2000);
	plloc.monthlyIncome.sendKeys(salary);
	//pquser received
	String str=updatepqobj.recivedPquser;
	plloc.mobile.sendKeys(str);
	wait.until(ExpectedConditions.elementToBeClickable(plloc.ButtonPLsubmit));
	plloc.ButtonPLsubmit.click();
	wait.until(ExpectedConditions.elementToBeClickable(plloc.otp));
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("The otp we received is :"+otp);
	plloc.otp.sendKeys(otp);
	plloc.ihearby.click();
	plloc.otpverify.click();
	Thread.sleep(2000);
	driver.navigate().refresh();
	WebActions.CaptureScreen(driver);
	wait.until(ExpectedConditions.elementToBeClickable(plloc.widgit));
	plloc.widgit.click();
	plloc.ButtonOTPnextClick.click();
    
	return new PLpanForm();
	}
	

}
