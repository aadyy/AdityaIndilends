package pageclass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locatores.PLlocatores;

public class PLofficeDetails extends Base {
	
	PLlocatores plloc;
	WebDriverWait wait=new WebDriverWait(driver, 10);

	public PLadditionalDetails PlofficeDetailsFun()  {
	plloc=new PLlocatores(driver);	
	//office details
	List<WebElement> workexp= driver.findElements(By.xpath("//span[@class=\"custom-select-trigger\" and contains(text(),\"Work Experience\")]"));
	for (int i = 0; i < workexp.size(); i++) {
	System.out.println("Number of work exp elements :"+workexp.get(i).getText());  
	workexp.get(i).click();
	break;
	}
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id=\"currentExpMonth\"]//following::span[contains(text(),\"More than 24 months\")]")));
 	List<WebElement> MoreThen= driver.findElements(By.xpath("//select[@id=\"currentExpMonth\"]//following::span[contains(text(),\"More than 24 months\")]"));
	for (int i = 0; i < MoreThen.size(); i++) {
	System.out.println("Work Experience :"+MoreThen.get(i).getText());  
	MoreThen.get(i).click();
	break;
	}
	plloc.ofcpincode.sendKeys("110033");
	plloc.ofcaddress1.sendKeys("ofc adress linenumner 1");
	plloc.ofcaddress2.sendKeys("ofc address linenumber 2");
	plloc.totalWorkExp.click();
	wait.until(ExpectedConditions.elementToBeClickable(plloc.morethen24Month));
	plloc.morethen24Month.click();
	wait.until(ExpectedConditions.elementToBeClickable(plloc.Buttonofcdetails));
    plloc.Buttonofcdetails.click();
	return new PLadditionalDetails();
    
//    if (plloc.sorry.isDisplayed()) {
//		System.out.println("Application has been rejected "+plloc.sorry.getText());
//	}else {
//		System.out.println("Application is ON additional form");
//	}
	}

}
