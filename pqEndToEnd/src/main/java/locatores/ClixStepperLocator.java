package locatores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageclass.Base;

public class ClixStepperLocator extends Base {
	
	public ClixStepperLocator(WebDriver idriver) {
		this.driver=idriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class=\"col-8 text-left pt-0\"]")
	public WebElement congratulation;
	@FindBy(xpath = "//div[@class=\"category-container active\"]")
	public WebElement emailverification; 
	@FindBy(xpath = "//div[@class=\"col-4 p-0 pr-4 text-right\"]//img")
	public WebElement clixLogo;
	@FindBy(xpath = "//div[@class=\"col-12\"]//b")
	public WebElement error;
	@FindBy(id="required-email")
	public WebElement requiredsemail;
	@FindBy(id ="required-email-btn")
	public WebElement requiredemailbtn;
	@FindBy(id="txtOtp0")
	public WebElement otp;

}
