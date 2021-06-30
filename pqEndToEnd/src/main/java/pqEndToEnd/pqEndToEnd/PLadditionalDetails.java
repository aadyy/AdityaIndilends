package pqEndToEnd.pqEndToEnd;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locatores.PLlocatores;
import utilities.WebActions;

public class PLadditionalDetails extends Base {
	
	PLlocatores plloc;
	WebDriverWait wait=new WebDriverWait(driver, 10);
	public CLixStepperPage PLadditionalDetailsFun() throws InterruptedException  {
		plloc=new PLlocatores(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		plloc.FathersFullName.sendKeys("AutomationFather TestName");
		Thread.sleep(2000);
		plloc.mobileLinkedNO.click();
		plloc.MothersFullName.sendKeys("AutomationMother TestName");
		//plloc.LoanPurpose.click();
		//plloc.marriage.click();
		List<WebElement> loanpurpose=driver.findElements(By.xpath("//span[contains(text(),\"Loan Purpose\")]"));
		for (int i = 0; i < loanpurpose.size(); i++) {
			loanpurpose.get(i).click();
			break;
		}
		Thread.sleep(2000);
		List<WebElement> marriage=driver.findElements(By.xpath("//div[@class=\"custom-options\"]//following::span[contains(text(),\"Marriage\")]"));
		for (int i = 0; i < marriage.size(); i++) {
			marriage.get(i).click();
			break;
		}
		
		plloc.IsPermaYES.click();
		plloc.Landmark.sendKeys("AdityaHotel Landmark");
		plloc.CurrentlandMark.sendKeys("AdityaRoyHotel CurrentLandmark");
		plloc.OfficelandMark.sendKeys("AdityaBirlaOffice landMark");
		plloc.livingSince.click();
		Thread.sleep(2000);
		plloc.livingSinceMoreThen24Month.click();
		plloc.permanentResidence.click();
		wait.until(ExpectedConditions.elementToBeClickable(plloc.permanentresidenceRetesdwithFamily));
		plloc.permanentresidenceRetesdwithFamily.click();
		plloc.typeOfOrg.click();
		wait.until(ExpectedConditions.elementToBeClickable(plloc.typeofOrgIsPrivate));
		plloc.typeofOrgIsPrivate.click();
		plloc.ButtonverifiyAdditional.click();
		
		//T&C part
		wait.until(ExpectedConditions.elementToBeClickable(plloc.firstTnC));
		plloc.firstTnC.click();
		System.out.println("First TnC :"+plloc.firstTnC.getText());
		plloc.secondTnC.click();
		plloc.thirdTnC.click();
		wait.until(ExpectedConditions.elementToBeClickable(plloc.buttionAdditionalTandC));
		plloc.buttionAdditionalTandC.click();
		String currentURL=driver.getCurrentUrl();
		assertEquals(currentURL, "https://uatweb.indialends.com/dashboard/Emicalculation/PQStepper");
		System.out.println("Current URL is: "+currentURL);
		WebActions.CaptureScreen(driver);
		return new CLixStepperPage();
	}

}
