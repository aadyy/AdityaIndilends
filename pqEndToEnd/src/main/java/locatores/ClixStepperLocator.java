package locatores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pqEndToEnd.pqEndToEnd.Base;

public class ClixStepperLocator extends Base {
	
	public ClixStepperLocator(WebDriver idriver) {
		this.driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class=\"col-8 text-left pt-0\"]")
	public WebElement congratulation;
	@FindBy(xpath = "//div[@class=\"category-container active\"]")
	public WebElement emailverification; 

}
