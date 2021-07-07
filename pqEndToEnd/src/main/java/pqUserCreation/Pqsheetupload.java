package pqUserCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pageclass.Base;

public class Pqsheetupload {
	
	public static void pqsheetuploadFun(String UserId,String Mobileno) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Base.getPropertyFile("mylinksdata.properties", "docuploadurl"));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#txt_emailid")).sendKeys("ayesha@indialends.com");
		driver.findElement(By.cssSelector("#txt_password")).sendKeys("test");
		driver.findElement(By.cssSelector("#btn_login")).click();
		Thread.sleep(2000);
		driver.get("https://crmuat.indialends.com/admin/pq_docupload_customer_contact.aspx");
		
//		List<WebElement> listofnbfc= driver.findElements(By.xpath("//select[@id=\"li_nbfc\"]//option"));
//		String nbfcs = null;
//		for (int i = 0; i < listofnbfc.size(); i++) {
//			 nbfcs=listofnbfc.get(i).getAttribute("value");
//			System.out.println("Nbfcs are :"+nbfcs);
//		}
		 driver.findElement(By.id("li_nbfc")).click();
		 Select sel=new Select(driver.findElement(By.id("li_nbfc")));
		// sel.selectByVisibleText("NBFC value as selected is: "+System.getProperty("sel"));
		 sel.selectByVisibleText(Base.getPropertyFile("mylinksdata.properties", "nbfcidname"));
		 WebElement uploadElement = driver.findElement(By.cssSelector("#fileSelect"));
	
		 uploadElement.sendKeys("C:\\Users\\Adityayadav\\eclipse-workspace\\pqEndToEnd\\src\\main\\java\\myproperty\\PQ_lead.xlsx");
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector("#btn_insert")).click();
		 Thread.sleep(2000);
		 driver.switchTo().alert().dismiss();
		 driver.close();
		UpdatePQDBvalues.CheckPqleadDetailsTableFun(UserId,Mobileno);
		}	
}
