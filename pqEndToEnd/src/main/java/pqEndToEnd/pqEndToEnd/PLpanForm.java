package pqEndToEnd.pqEndToEnd;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import locatores.PLlocatores;

public class PLpanForm extends Base{
	
	PLlocatores plloc;
	public PLpersonalDetails PLpanformFun() throws InterruptedException {
	plloc=new PLlocatores(driver);
		 plloc.loanAmt.sendKeys("300000");
		 plloc.male.click();
		 plloc.dob.sendKeys("10/10/1990");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[@class=\"custom-select-trigger\" and contains(text(),\"Mode of Salary\")]")).click();
		 Thread.sleep(3000);
		 List<WebElement> modeofsal=driver.findElements(By.xpath("//span[contains(text(),'Mode of Salary')]//following::span[contains(text(),\"Bank\")]"));
		 int sizee=modeofsal.size();
		 System.out.println("Mode of sal size :"+sizee);
		 for (int i = 0; i < sizee; i++) {
		 modeofsal.get(i).click();
		 }
		 plloc.bank.click();
		 Thread.sleep(3000);
		 plloc.bankName.click();
		 plloc.bankName.sendKeys("ICICI");
		 Thread.sleep(4000);
		 plloc.selctBankName.click();
		 plloc.address1.sendKeys("Current address lineNumber1");
		 plloc.address2.sendKeys("Current address lineNumber2");
		 Thread.sleep(4000);
		 plloc.ButtonpanFormNext.click();
		return new PLpersonalDetails();	

	}

}
