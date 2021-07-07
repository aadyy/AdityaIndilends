package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageclass.Base;

public class WebActions extends Base {

	 public static void CaptureScreen(WebDriver driver) {
		 Date currentdate=new Date();
		 String screenshotdate=currentdate.toString().replace(" ", "-").replace(":", "-");
		 System.out.println("Current date is: "+screenshotdate);
		 
		    TakesScreenshot oScn = (TakesScreenshot) driver;
		    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
//		    Date date = new Date();
//			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmm");
//			String strDate = formatter.format(date);
		    File oDest = new File(System.getProperty("user.dir") + "//screenshot//Live//"+screenshotdate+".png");
		    try {
		        FileUtils.copyFile(oScnShot, oDest);
		    } catch (IOException e) {
		        System.out.println(e.getMessage());
		    }
		}
	 
	 public static void ExplicitWait(WebElement ele) {
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOf(ele));
	}
	 
	 public static void MoveToElement(WebElement target) {
		 Actions ac=new Actions(driver);
		 ac.moveToElement(target).build().perform();
	 }
	 public static void DragAndDrop(WebElement source,WebElement target) {
		 Actions ac=new Actions(driver);
		 ac.dragAndDrop(source, target);
	 }
	 
	 public static void scroll(WebElement element) {
     JavascriptExecutor js=(JavascriptExecutor) driver;
     js.executeAsyncScript("arguments[0].scrollIntoView();", element );

	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 	
	 
}
