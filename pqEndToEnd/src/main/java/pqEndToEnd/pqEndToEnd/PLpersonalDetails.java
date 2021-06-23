package pqEndToEnd.pqEndToEnd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import locatores.PLlocatores;

public class PLpersonalDetails extends Base {
	
	PLlocatores plloc;
	public PLofficeDetails PLpersonalDetailsFun() throws InterruptedException {
	plloc=new PLlocatores(driver);
	//Personal Details
			plloc.HighEducation.click();	
			Thread.sleep(3000);
			plloc.PostGraducation.click();
			plloc.Single.click();
		    plloc.currentResidence.click();
		    Thread.sleep(3000);
		    plloc.rentedWithFamily.click();
		    plloc.HowLongUhaveBeenStaying.click();
		    Thread.sleep(3000);
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
		    Thread.sleep(3000);
		    plloc.ButtonPersonalDetails.click();
			return new PLofficeDetails();
	
	}

}
