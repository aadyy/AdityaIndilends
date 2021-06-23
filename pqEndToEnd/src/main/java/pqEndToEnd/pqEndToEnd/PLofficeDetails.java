package pqEndToEnd.pqEndToEnd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locatores.PLlocatores;

public class PLofficeDetails extends Base {
	
	PLlocatores plloc;
	public PLadditionalDetails PlofficeDetailsFun() throws InterruptedException {
	plloc=new PLlocatores(driver);	
	//office details
	Thread.sleep(3000);
	List<WebElement> listt= driver.findElements(By.xpath("//span[@class=\"custom-select-trigger\" and contains(text(),\"Work Experience\")]"));
	for (int i = 0; i < listt.size(); i++) {
	System.out.println("Number of work exp elements :"+listt.get(i).getText());  
	listt.get(i).click();
	break;
	}
	Thread.sleep(3000);
 	List<WebElement> MoreThen= driver.findElements(By.xpath("//select[@id=\"currentExpMonth\"]//following::span[contains(text(),\"More than 24 months\")]"));
	for (int i = 0; i < MoreThen.size(); i++) {
	System.out.println("Work Experience :"+MoreThen.get(i).getText());  
	MoreThen.get(i).click();
	break;
	}
	Thread.sleep(3000);
	plloc.ofcpincode.sendKeys("110033");
	plloc.ofcaddress1.sendKeys("ofc adress linenumner 1");
	plloc.ofcaddress2.sendKeys("ofc address linenumber 2");
	plloc.totalWorkExp.click();
	Thread.sleep(3000);
	plloc.morethen24Month.click();
    driver.findElement(By.id("btnOtherDetails")).click();
	return new PLadditionalDetails();
    
//    if (plloc.sorry.isDisplayed()) {
//		System.out.println("Application has been rejected "+plloc.sorry.getText());
//	}else {
//		System.out.println("Application is ON additional form");
//	}
	}

}
