package pqEndToEnd.pqEndToEnd;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import locatores.PLlocatores;
import utilities.WebActions;

public class PLadditionalDetails extends Base {
	
	PLlocatores plloc;
	public void PLadditionalDetailsFun() throws InterruptedException {
		plloc=new PLlocatores(driver);
		Thread.sleep(4000);
		plloc.FathersFullName.sendKeys("DCPAuto yadav");
		plloc.MothersFullName.sendKeys("SSPAuto yadav");
		Thread.sleep(3000);
		//plloc.LoanPurpose.click();
		//plloc.marriage.click();
		List<WebElement> loan=driver.findElements(By.xpath("//span[contains(text(),\"Loan Purpose\")]"));
		for (int i = 0; i < loan.size(); i++) {
			loan.get(i).click();
			break;
		}
		Thread.sleep(3000);
		List<WebElement> marriage=driver.findElements(By.xpath("//div[@class=\"custom-options\"]//following::span[contains(text(),\"Marriage\")]"));
		for (int i = 0; i < marriage.size(); i++) {
			marriage.get(i).click();
			break;
		}
		Thread.sleep(3000);
		
		plloc.IsPermaYES.click();
		plloc.Landmark.sendKeys("AdityaHotel Landmark");
		plloc.CurrentlandMark.sendKeys("AdityaRoy CurrentLandmark");
		plloc.OfficelandMark.sendKeys("AdityaOffice landMark");
		plloc.livingSince.click();
		Thread.sleep(3000);
		plloc.livingSinceMoreThen24Month.click();
		plloc.permanentResidence.click();
		Thread.sleep(3000);
		plloc.permanentresidenceRetesdwithFamily.click();
		plloc.typeOfOrg.click();
		Thread.sleep(3000);
		plloc.typeofOrgIsPrivate.click();
		plloc.ButtonverifiyAdditional.click();
		
		//T&C part
		Thread.sleep(3000);
		plloc.firstTnC.click();
		System.out.println("First TnC :"+plloc.firstTnC.getText());
		plloc.secondTnC.click();
		plloc.thirdTnC.click();
		Thread.sleep(3000);
		plloc.buttionAdditionalTandC.click();
		String currentURL=driver.getCurrentUrl();
		assertEquals(currentURL, "https://uatweb.indialends.com/dashboard/Emicalculation/PQStepper");
		System.out.println("Current URL is: "+currentURL);
		WebActions.CaptureScreen(driver, "C:\\Users\\Adityayadav\\git\\AdityaIndilends\\pqEndToEnd\\screenshot");
	}

}
