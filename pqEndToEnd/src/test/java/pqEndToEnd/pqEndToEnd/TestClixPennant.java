package pqEndToEnd.pqEndToEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pqUserCreation.CreatePquser;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetOtp;
import utilities.GetdataForPL;
import utilities.WebActions;

public class TestClixPennant extends Base {
	CreatePquser crPQuserObj;
	UpdatePQDBvalues updatepqobj;
	@BeforeTest
	private void createPQuserAndopenUrl() {
	try {
	crPQuserObj=new CreatePquser();
	crPQuserObj.createPQuserFun();
	Thread.sleep(5000);
	loadBrowser("https://uatweb.indialends.com"); 
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}		
	}
	
	ClixPennant obj;
	@Test(enabled = false)
	public void testClixPennantFun() throws InterruptedException {
	obj=new ClixPennant(driver);	
	obj.ClixPennanatJavaFun();
	}
	
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}

	@Test(dataProvider = "getTestDataUtilsFu")
	public void ApplyPreQualifiedLoan(String name,String email,String pincode,String company,String salary) throws InterruptedException{
	driver.findElement(By.xpath("//li[@class=\"nav-item active\"]//a")).click();	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id=\"li_display_name\"]")).sendKeys(name);
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("pincode")).sendKeys(pincode);
	driver.findElement(By.id("employment")).click();
	Thread.sleep(4000);
	driver.findElement(By.id("div_employment_type")).click();
	driver.findElement(By.id("companyName")).sendKeys(company);
	Thread.sleep(5000);
	java.util.List<WebElement> list= driver.findElements(By.xpath("//ul[@class=\"dropdown-menu display-block\"]//li"));
		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i).getText();
			System.out.println("List of companies :"+str);
		}
	driver.findElement(By.id("a_loc1")).click();
	driver.findElement(By.id("monthlyIncome")).sendKeys(salary);
	//pquser received
	String str=updatepqobj.recivedPquser;
	driver.findElement(By.id("mobile")).sendKeys(str);
	driver.findElement(By.id("li_submit")).click();
	Thread.sleep(4000);
	String useridforotp=UpdatePQDBvalues.userId;
	String otp=GetOtp.getOtpViaUseridFun(useridforotp);
	System.out.println("user id is: "+useridforotp);
	System.out.println("The otp we received is :"+otp);
	driver.findElement(By.id("txt_otp")).sendKeys(otp);
	Thread.sleep(4000);
	driver.findElement(By.id("control-indicator")).click();
	driver.findElement(By.id("btn_mobile_verify")).click();
	Thread.sleep(4000);
	driver.navigate().refresh();
	
	WebActions.CaptureScreen(driver, "C:\\Users\\Adityayadav\\git\\AdityaIndilends\\pqEndToEnd\\screenshot");
	
    driver.findElement(By.xpath("//*[@class=\"wrapping text-l-sm sm-marg10l border-right-none-sm\"]")).click();
    driver.findElement(By.xpath("//*[@class=\"display-block font15\"]")).click();
    Thread.sleep(4000);
	}
	
	@Test
	public void Panform() throws InterruptedException {
		//PAN FORM TO ADDITIONAL FORM
	    driver.findElement(By.id("loanAmt")).sendKeys("500000");
	    driver.findElement(By.xpath("//label[contains(text(),\"Male\")]")).click();
	    driver.findElement(By.id("dob")).sendKeys("10/10/1990");
	    Thread.sleep(3000);
	  //  driver.findElement(By.id("panNo")).sendKeys("akopy4346h");
	  // driver.findElement(By.xpath("//span[contains(text(),'Mode of Salary')]")).click();
	    
	    List<WebElement> modeofsal=driver.findElements(By.xpath("//span[contains(text(),'Mode of Salary')]"));
	    int sizee=modeofsal.size();
	    System.out.println("Mode of sal size :"+sizee);
	    for (int i = 0; i < sizee; i++) {
	    	modeofsal.get(i).click();
		}
	    driver.findElement(By.xpath("//div[@class=\"custom-select-menu sources opened\"]//descendant::div//span[contains(text(),\"Bank\")]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("salary-account-bank")).click();
	    driver.findElement(By.id("bankname")).sendKeys("ICICI");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//ul[@id=\"companynamedata\"]//li[contains(text(),\"ICICI BANK LTD\")]")).click();
	    driver.findElement(By.id("address1")).sendKeys("Current address line1");
	    driver.findElement(By.id("address2")).sendKeys("Current address line2");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		}
    
	@Test
    public void personalDetails() throws InterruptedException {
		//Personal Details
	    driver.findElement(By.xpath("//span[contains(text(),\"Highest Educational Qualification\")]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@class=\"custom-options\"]//span[@data-value=\"Post Graduate\"]")).click();
	    driver.findElement(By.xpath("//label[contains(text(),\"Single\")]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),\"Current Residence Type\")]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@class=\"custom-options\"]//span[@data-value=\"Rented with family\"]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),\"How long have you been staying here?\")]")).click();
	    Thread.sleep(3000);
	   
	    List<WebElement> howLongList= driver.findElements(By.xpath("//div[@class=\"custom-options\"]//span[contains(text(),\"More than 24 months\")]"));  
	    int size=howLongList.size();
	    System.out.println("number of how long have u been stay element present : "+size);
	    for (int i = 0; i < howLongList.size(); i++) {
		String data=howLongList.get(i).getText();
		System.out.println("How long have been staying here:->"+data);
		howLongList.get(i).click();
		break;
//		Isselected=howLongList.get(i).isSelected();
//		if (!Isselected) {
//		howLongList.get(i).click();
//		}
		}
	    Thread.sleep(3000);
	    driver.findElement(By.id("btnPersonalDetails")).click();
		}
    @Test
    public void offileDetails() throws InterruptedException {
    	//office details
	   Thread.sleep(3000);
	   
	  List<WebElement> listt= driver.findElements(By.xpath("//span[contains(text(),\"Work Experience\")]"));
      for (int i = 1; i < listt.size(); i++) {
    	System.out.println("Number of work exp elements :"+listt.get(i).getText());  
		listt.get(i).click();
	}	
	  
    	List<WebElement> workEmpSel=driver.findElements(By.xpath("//div[@class=\"custom-options\"]//span[contains(text(),\"More than 24 months\")]"));
        int workExpSize=workEmpSel.size();
        System.out.println("No of Work experience Elements present:"+workExpSize);
        for (int i = 0; i < workExpSize; i++) {
			workEmpSel.get(i).click();
			break;
		}

//        driver.findElement(By.name("officePincode")).sendKeys("110030");
//        driver.findElement(By.name("offAddress1")).sendKeys("office address line number 1");
//        driver.findElement(By.name("addresoffAddress2s2")).sendKeys("office address line number 2");

       
//        driver.findElement(By.id("btnOtherDetails")).click();
		}
		
   

}
