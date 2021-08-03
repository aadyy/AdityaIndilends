package newpl;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locatores.NewPLLocator;
import pageclass.Base;
import utilities.GetOtp;

public class NewPLShortForm extends Base{
	
		NewPLLocator newplLoc;
		WebDriverWait wait;
		
		public void NewPlshortFormFun(String name,String company,String salary,String pincode,String pan,String email) throws InterruptedException {
		newplLoc=new NewPLLocator(driver);
		wait=new WebDriverWait(driver, 20);
		newplLoc.PL.click();
		wait.until(ExpectedConditions.visibilityOf(newplLoc.name));
		newplLoc.name.sendKeys(name);
		newplLoc.male.click();
		newplLoc.dob.sendKeys("10/10/1990");
		newplLoc.emptype.click();
		wait.until(ExpectedConditions.visibilityOf(newplLoc.EmpSalaried));
		newplLoc.EmpSalaried.click();
		newplLoc.companyName.click();
		newplLoc.companynamesearch.sendKeys(company);
	
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id=\"companynamedata\"]//li"));
		int size=list.size();
		System.out.println("compaylist size "+ size);
		Thread.sleep(3000);
		newplLoc.listedCompany.click();
		
		newplLoc.monthlyIncome.sendKeys(salary);
		newplLoc.pincode.sendKeys(pincode);
		newplLoc.panNo.sendKeys(pan);
		String randomnumber=Base.randomMobile();
		newplLoc.mobile.sendKeys(randomnumber);
		newplLoc.email.sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(newplLoc.btnShortForm));
		newplLoc.btnShortForm.click();
			
		String otp=GetOtp.getOtpviaMobilenumberFun(randomnumber);
		System.out.println("Mobile Number is:"+randomnumber);
		wait.until(ExpectedConditions.visibilityOf(newplLoc.otp));
		newplLoc.otp.sendKeys(otp);
		newplLoc.tnc.click();
		newplLoc.submit.click();
		Thread.sleep(3000);
		newplLoc.tataoffer.click();
		newplLoc.loanAmt.sendKeys("300000");
		Thread.sleep(2000);
		newplLoc.modeofsal.click();
		newplLoc.bank.click();
		newplLoc.salaryaccountbank.click();
		Thread.sleep(2000);
		newplLoc.banknamesearch.sendKeys("HDFC");
		newplLoc.searchedBankName.click();
		newplLoc.address1.sendKeys("automation testing aditya1");		
		newplLoc.address2.sendKeys("automation testing aditya2");
		}
		
		public void loanamountfun() throws InterruptedException {
			
			System.out.println("second method");
		}
}
