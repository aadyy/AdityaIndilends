package pqEndToEnd.pqEndToEnd;

import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import locatores.PLlocatores;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;
import utilities.GetdataForPL;
import utilities.WebActions;

public class PLshortForm extends Base{
	
	PLlocatores plloc;
	UpdatePQDBvalues updatepqobj; 
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}
	
	public PLpanForm PlshortFormFun(String name,String email,String pincode,String company,String salary) throws InterruptedException {
	plloc=new PLlocatores(driver);
	Thread.sleep(4000);
	plloc.personalLoan.click();
	plloc.username.sendKeys(name);
	plloc.emailid.sendKeys(email);
	plloc.pincode.sendKeys(pincode);
	plloc.employment.click();
	Thread.sleep(4000);
	plloc.salaried.click();
	plloc.companyName.sendKeys(company);
	Thread.sleep(5000);
	java.util.List<WebElement> list= driver.findElements(By.xpath("//ul[@class=\"dropdown-menu display-block\"]//li"));
		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i).getText();
			System.out.println("List of companies :"+str);
		}
	plloc.companyslect.click();
	plloc.monthlyIncome.sendKeys(salary);
	
	//pquser received
	String str=updatepqobj.recivedPquser;
	plloc.mobile.sendKeys(str);
	plloc.ButtonPLsubmit.click();
	Thread.sleep(4000);
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("user id is: "+useridforotp);
	System.out.println("The otp we received is :"+otp);
	plloc.otp.sendKeys(otp);
	Thread.sleep(4000);
	plloc.ihearby.click();
	plloc.otpverify.click();
	Thread.sleep(4000);
	driver.navigate().refresh();
	WebActions.CaptureScreen(driver, "C:\\Users\\Adityayadav\\git\\AdityaIndilends\\pqEndToEnd\\screenshot");
	plloc.widgit.click();
	plloc.ButtonOTPnextClick.click();
    Thread.sleep(4000);
	return new PLpanForm();
	}
	

}
