package locatores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageclass.Base;

public class NewPLLocator extends Base {
	
	
	public NewPLLocator(WebDriver idriver) {
	this.driver=idriver;
	PageFactory.initElements(driver, this);
	}
	
	//NEWPL to button
	@FindBy(xpath = "//a[@class='nav-link'][normalize-space()='Personal Loan']")
	public WebElement PL;
	@FindBy(xpath = "//input[@id='li_display_name']")
	public WebElement name;
	@FindBy(xpath = "//label[normalize-space()='Male']")
	public WebElement male;	
	@FindBy(id = "dob")
	public WebElement dob;
	@FindBy(xpath = "//span[@class='custom-select-trigger']")
	public WebElement emptype;
	@FindBy(xpath = "//span[normalize-space()='Salaried']")
	public WebElement EmpSalaried;
	@FindBy(xpath = "//span[normalize-space()='Self Employed']")
	public WebElement EmpSelefEMP;
	@FindBy(xpath = "//span[normalize-space()='Self Employed (Dr./CA)']")
	public WebElement EmpSelfDRCA;
	@FindBy(id = "companyName")
	public WebElement companyName;
	@FindBy(id = "companynamesearch")
	public WebElement companynamesearch;
	
	@FindBy(xpath = "//ul[@id=\"companynamedata\"]//li")
	public WebElement listedCompany;
	
	@FindBy(id = "monthlyIncome")
	public WebElement monthlyIncome;
	@FindBy(id = "pincode")
	public WebElement pincode;
	@FindBy(id = "panNo")
	public WebElement panNo;
	@FindBy(id = "mobile")
	public WebElement mobile;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "btnShortForm")
	public WebElement btnShortForm;
	
	//Otp Screen
	@FindBy(id = "txt_otp0")
	public WebElement otp;
	@FindBy(xpath  = "//label[@for='tnc']")
	public WebElement tnc;
	@FindBy(id = "btn_MV")
	public WebElement submit;
	
	//LenderListing	
	@FindBy(xpath  = "//div[@class='text-left']//div[1]//label[1]//div[1]//button[1]")
	public WebElement paysenseOffer;
	@FindBy(xpath  = "//div[@class='container p-0 px-md-4']//div[2]//label[1]//div[1]//button[1]")
	public WebElement tataoffer;
	@FindBy(xpath  = "//div[@class='container p-0 px-md-4 ng-scope']//div[3]//label[1]//div[1]//button[1]")
	public WebElement faircentoffer;
	
	//Loanamount Screen
	@FindBy(id = "loanAmt")
	public WebElement loanAmt;
	@FindBy(id = "//span[normalize-space()='Mode of Salary']")
	public WebElement modeofsal;
	@FindBy(xpath = "//span[normalize-space()='Bank']")
	public WebElement bank;
	
	@FindBy(id = "salary-account-bank")
	public WebElement salaryaccountbank;
	@FindBy(id = "bankname")
	public WebElement banknamesearch;
	@FindBy(xpath = "//li[normalize-space()='HDFC BANK LTD']")
	public WebElement searchedBankName;
	
	
	@FindBy(id = "address1")
	public WebElement address1;
	@FindBy(id = "address2")
	public WebElement address2;

	
	
	
	
	
	
	
	
	
	

}
