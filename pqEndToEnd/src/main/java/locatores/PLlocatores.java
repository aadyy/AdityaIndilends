package locatores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageclass.Base;

public class PLlocatores extends Base{
	
	public PLlocatores(WebDriver idriver) {
	this.driver=idriver;
	PageFactory.initElements(driver, this);
	}
	
	// LOGIN BUTTON ELEMENTS
		@FindBy(xpath = "//a[@class=\"btn btn-outline-primary ml-4 mt-lg-0 mt-5 d-lg-block d-none\"]")
		public WebElement loginButton;
		@FindBy(id = "txt_mobile_number")
		public WebElement loginnumber;
		@FindBy(id = "btnSendOTP")
		public WebElement getOpt;
		@FindBy(id = "txtOtp0")
		public WebElement insertotp;
		@FindBy(xpath = "//*[contains(text(),\"I hereby declare\")]")
		public WebElement tandc;
		@FindBy(id = "btnVerifyOtp")
		public WebElement verifyandClick;
		
		//PERSONAL LOAN Short Form Elements
		@FindBy(xpath = "//li[@class=\"nav-item active\"]//a")
		public WebElement personalLoan;
		@FindBy(xpath = "//input[@id=\"li_display_name\"]")
		public WebElement username;
		@FindBy(id = "email")
		public WebElement emailid;
		@FindBy(id = "pincode")
		public WebElement pincode;
		@FindBy(id = "employment")
		public WebElement employment;
		@FindBy(id = "div_employment_type")
		public WebElement salariedEmp;
		@FindBy(id = "companyName")
		public WebElement companyName;
		@FindBy(id = "a_loc1")
		public WebElement companyslect;
		@FindBy(id = "monthlyIncome")
		public WebElement monthlyIncome;
		@FindBy(id = "mobile")
		public WebElement mobile;
		@FindBy(id = "li_submit")
		public WebElement ButtonPLsubmit;
		@FindBy(id = "txt_otp")
		public WebElement otp;
		@FindBy(id = "control-indicator")
		public WebElement ihearby;
		@FindBy(id = "btn_mobile_verify")
		public WebElement otpverify;
		@FindBy(xpath = "//*[@class=\"wrapping text-l-sm sm-marg10l border-right-none-sm\"]")
		public WebElement widgit;
		@FindBy(xpath = "//*[@class=\"display-block font15\"]")
		public WebElement ButtonOTPnextClick;
		
		//Personal Loan PAN FORM 
		@FindBy(id = "loanAmt")
		public WebElement loanAmt;
		@FindBy(xpath = "//label[contains(text(),\"Male\")]")
		public WebElement male;
		@FindBy(id = "dob")
		public WebElement dob;
		@FindBy(id="panNo")
		public WebElement pancard;
		
		@FindBy(xpath = "//span[@class=\"custom-select-trigger\" and contains(text(),\"Mode of Salary\")]")
		public WebElement modeofSal;
		@FindBy(id= "salary-account-bank")
		public WebElement Modeisbank;
		@FindBy(id = "bankname")
		public WebElement bankName;
		@FindBy(xpath = "//ul[@id=\"companynamedata\"]//li")
		public WebElement selctBankName;
		@FindBy(id = "address1")
		public WebElement address1;
		@FindBy(id = "address2")
		public WebElement address2;
		@FindBy(xpath = "//button[@class=\"btn btn-primary\"]" )
		public WebElement ButtonpanFormNext;
		
		//Personal Loan PersonalDetails Form
		@FindBy(xpath = "//span[contains(text(),\"Highest Educational Qualification\")]" )
		public WebElement HighEducation;
		@FindBy(xpath = "//div[@class=\"custom-options\"]//span[@data-value=\"Post Graduate\"]" )
		public WebElement PostGraducation;
		@FindBy(xpath = "//label[contains(text(),\"Single\")]" )
		public WebElement Single;
		@FindBy(xpath = "//span[contains(text(),\"Current Residence Type\")]")
		public WebElement currentResidence;
		@FindBy(xpath = "//div[@class=\"custom-options\"]//span[@data-value=\"Rented with family\"]")
		public WebElement rentedWithFamily;
		@FindBy(xpath = "//span[@class=\"custom-select-trigger\" and contains(text(),\"How\")]")
		public WebElement HowLongUhaveBeenStaying;
		@FindBy(id = "btnPersonalDetails")
		public WebElement ButtonPersonalDetails;
		
		//Office Details form Elements
		@FindBy(xpath = "//input[@id=\"officePincode\"]")
		public WebElement ofcpincode;
		@FindBy(xpath = "//input[@id=\"offAddress1\"]")
		public WebElement ofcaddress1;
		@FindBy(xpath = "//input[@id=\"offAddress2\"]")
		public WebElement ofcaddress2;
		@FindBy(xpath = "//span[@class=\"custom-select-trigger\" and contains(text(),\"Work Experience\")]")
		public WebElement totalWorkExp;
		@FindBy(xpath = "//span[contains(text(),\"Total\")]//following::span[contains(text(),\"More than 24 months\")]")
		public WebElement morethen24Month;
		@FindBy(id = "btnOtherDetails")
		public WebElement Buttonofcdetails;
		@FindBy(xpath = "//div[@class=\"col-12 text-center\"]//p")
		public WebElement sorry;
		
		//additional details
		@FindBy(id="FathersFullName")
		public WebElement FathersFullName;
		@FindBy(id="MothersFullName")
		public WebElement MothersFullName;
		@FindBy(xpath = "//div[@class=\"custom-select-menu\"]//following::span[contains(text(),\"Loan Purpose\")]")
		public WebElement LoanPurpose;
		@FindBy(xpath = "//div[@class=\"custom-select-menu\"]//following::span[contains(text(),\"Marriage\")]")
		public WebElement marriage;
		@FindBy(xpath = "//label[@for=\"mobileLinkedtoAadhar\"]")
		public WebElement mobileLinkedYES;
		@FindBy(xpath = "//label[@for=\"mobileLinkedtoAadhar2\"]")
		public WebElement mobileLinkedNO;
		@FindBy(xpath = "//label[@for=\"isPerAddSame\" and contains(text(),\"Yes\")]")
		public WebElement IsPermaYES;
		@FindBy(id="Landmark")
		public WebElement Landmark;
		@FindBy(id="CurrentlandMark")
		public WebElement CurrentlandMark;
		@FindBy(id="OfficelandMark")
		public WebElement OfficelandMark;
		@FindBy(xpath = "//span[contains(text(),\"Living Since\")]")
		public WebElement livingSince;
		@FindBy(xpath = "//span[contains(text(),\"Living Since\")]//following::span[contains(text(),\"More than 24 months\")]")
		public WebElement livingSinceMoreThen24Month;
		@FindBy(xpath = "//span[contains(text(),\"Permanent Residence Type\")]")
		public WebElement permanentResidence;
		@FindBy(xpath = "//span[contains(text(),\"Permanent Residence Type\")]//following::span[contains(text(),\"Rented with Family\")]")
		public WebElement permanentresidenceRetesdwithFamily;
		@FindBy(xpath = "//span[contains(text(),\"Type Of Organization\")]")
		public WebElement typeOfOrg;
		@FindBy(xpath = "//span[contains(text(),\"Type Of Organization\")]//following::span[contains(text(),\"Private Sector\")]")
		public WebElement typeofOrgIsPrivate;
		@FindBy(id = "additionalsubmitverify")
		public WebElement ButtonverifiyAdditional;
		
		@FindBy(xpath = "//div[@class=\"small-scroll\" and contains(text(),\" I/We authorize Clix\")]")
		public WebElement firstTnC;
		@FindBy(xpath = "//div[@class=\"small-scroll\" and contains(text(),\" as required by the Regulator\")]")
		public WebElement secondTnC;
		@FindBy(xpath ="//div[@class=\"small-scroll h-auto\" and contains(text(),\"I voluntarily submit my\")]")
		public WebElement thirdTnC;
		@FindBy(id="additionalsubmit")
		public WebElement buttionAdditionalTandC;
			
}
