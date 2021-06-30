package pqEndToEnd.pqEndToEnd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locatores.PLlocatores;

public class PLpersonalDetails extends Base {
	
	PLlocatores plloc;
	WebDriverWait wait=new WebDriverWait(driver, 10);
	public PLofficeDetails PLpersonalDetailsFun()  {
	plloc=new PLlocatores(driver);
	//Personal Details
			plloc.HighEducation.click();
			wait.until(ExpectedConditions.elementToBeClickable(plloc.PostGraducation));
			plloc.PostGraducation.click();
			plloc.Single.click();
		    plloc.currentResidence.click();
			wait.until(ExpectedConditions.elementToBeClickable(plloc.rentedWithFamily));
		    plloc.rentedWithFamily.click();
		    plloc.HowLongUhaveBeenStaying.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"custom-options\"]//span[contains(text(),\"More than 24 months\")]")));
		    List<WebElement> howLongList= driver.findElements(By.xpath("//div[@class=\"custom-options\"]//span[contains(text(),\"More than 24 months\")]"));  
		    int size=howLongList.size();
		    System.out.println("number of how long have u been stay element present : "+size);
		    for (int i = 0; i < howLongList.size(); i++) {
			String data=howLongList.get(i).getText();
			System.out.println("How long have been staying here:->"+data);
			howLongList.get(i).click();
			break;
//			Isselected=howLongList.get(i).isSelected();
//			if (!Isselected) {
//			howLongList.get(i).click();
//			}
			}
			wait.until(ExpectedConditions.elementToBeClickable(plloc.ButtonPersonalDetails));
			plloc.ButtonPersonalDetails.click();
			return new PLofficeDetails();
	
	}

}
