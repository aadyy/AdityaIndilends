package pqEndToEnd.pqEndToEnd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locatores.PLlocatores;

public class PLpanForm extends Base{
	
	PLlocatores plloc;
	WebDriverWait wait;
	public PLpersonalDetails PLpanformFun() throws InterruptedException {
	plloc=new PLlocatores(driver);
	wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(plloc.loanAmt));
		 plloc.loanAmt.sendKeys("300000");
		 plloc.male.click();
		 plloc.dob.sendKeys("10/10/1990");
		 plloc.modeofSal.click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Mode of Salary')]//following::span[contains(text(),\"Bank\")]")));
		 List<WebElement> modeofsalselect=driver.findElements(By.xpath("//span[contains(text(),'Mode of Salary')]//following::span[contains(text(),\"Bank\")]"));
		 int sizee=modeofsalselect.size();
		 System.out.println("Mode of sal size :"+sizee);
		 for (int i = 0; i < sizee; i++) {
		 modeofsalselect.get(i).click();
		 }
		 plloc.Modeisbank.click();
		 wait.until(ExpectedConditions.elementToBeClickable(plloc.bankName));
		 plloc.bankName.click();
		 plloc.bankName.sendKeys("ICICI BANK LTD");
		 Thread.sleep(2000);
		 plloc.selctBankName.click();
		 wait.until(ExpectedConditions.elementToBeClickable(plloc.address1));
		 plloc.address1.sendKeys("Current address lineNumber1");
		 plloc.address2.sendKeys("Current address lineNumber2");
		 Thread.sleep(2000);
		 plloc.ButtonpanFormNext.click();
		return new PLpersonalDetails();	
	}

}
