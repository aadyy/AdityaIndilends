package pageclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	static public WebDriver driver;
	public static Properties property;
	
	//#1. property reading
	public static String getPropertyFile(String filename,String key)  {
		File file=new File("C:\\Users\\Adityayadav\\git\\AdityaIndilends\\pqEndToEnd\\src\\main\\java\\myproperty\\"+filename);
	try {
			FileInputStream fis = new FileInputStream(file);
			property=new Properties();
			property.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("GetpropertyFile Exception :"+e.getMessage());
		}
		return property.getProperty(key);
	}
	
	//#2 load browser
	//@BeforeTest(enabled = false)
	public static void loadBrowser(String url) throws IOException {
		String Browser=getPropertyFile("mylinksdata.properties", "Browser");
		if (Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		ChromeDriver ch=new ChromeDriver();
		driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")){
		driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("IE")) {
		driver=new InternetExplorerDriver();
		}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	}
	
	//#3 Randowm MobileNumber creation
	public static String randomMobile() {
		String numStart = "6161";
		Random rand = new Random();
		int d1 = rand.nextInt(10);
		int d2 = rand.nextInt(10);
		int d3 = rand.nextInt(10);
		int d4 = rand.nextInt(10);
		int d5 = rand.nextInt(10);
		int d6 = rand.nextInt(10);
		String  str1, str2, str3, str4, str5, str6;
		str1 = Integer.toString(d1);
		str2 = Integer.toString(d2);
		str3 = Integer.toString(d3);
		str4 = Integer.toString(d4);
		str5 = Integer.toString(d5);
		str6 = Integer.toString(d6);
	String	numRemaining = str1 + "" + str2 + "" + str3 + "" + str4 + "" + str5 + "" + str6 + "";
	String  numComplete = "" + numStart + "" + numRemaining + "";
	return numComplete;
	}
	
	//#4 Some random numbers&pan&email ids
	private static int gen() {
	    	Random r = new Random( System.currentTimeMillis() );
	        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	    }
	 public static String randommEmail() {
	        return "AdityaAutomation3" +/* UUID.randomUUID().toString() +*/ gen()+ "@gmail.com";
	    }
	 public static String randommPAN() {
	        return "XCAPA" +/* UUID.randomUUID().toString() +*/ gen()+ "G";
	    }
	 public static String randomACMCid(){
	    	  Random random = new Random();
			  int index = random.nextInt(20);
			  String [] id = {"24975", "24974","24973","24972","24971","24970","24969","24968", "24967","24966",
					  		  "24965", "24964","24963","24962","24961","24960","24959","24958","24957","24956"};
		      String txt= id[index];
		      return txt;
		      
		 }	 
	 
	@AfterMethod(enabled = false)
	public void tearDown() throws InterruptedException {
	Thread.sleep(7000);
	driver.close();
	}
}
