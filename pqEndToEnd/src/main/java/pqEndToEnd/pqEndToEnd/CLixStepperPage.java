package pqEndToEnd.pqEndToEnd;

import org.openqa.selenium.support.ui.WebDriverWait;
import locatores.ClixStepperLocator;

public class CLixStepperPage extends Base{
	
	ClixStepperLocator clixloc;
	WebDriverWait wait=new WebDriverWait(driver, 10);
	public void CLixStepperPageFun() throws InterruptedException {
	clixloc=new ClixStepperLocator(driver);	
	clixloc.congratulation.isDisplayed();
	clixloc.clixLogo.isDisplayed();
	System.out.println("Text written on Email verification tab is: "+clixloc.emailverification.getText());
	clixloc.emailverification.click();
	clixloc.requiredsemail.sendKeys("adityayadav@indialends.com");
	clixloc.requiredemailbtn.click();
	//clixloc.otp.sendKeys("");
	
	}

}
