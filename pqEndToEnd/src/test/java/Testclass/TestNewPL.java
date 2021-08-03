package Testclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import newpl.NewPLShortForm;
import pageclass.Base;
import utilities.GetdataForPL;


public class TestNewPL extends Base {
	
	NewPLShortForm newpl;
	
	@BeforeTest
	private void fun() throws IOException {
	loadBrowser("https://uatweb.indialends.com");
	System.out.println("Browser launched");
	}
	
	@DataProvider(name = "getTestDataForNewPL")
	public Iterator<Object[]> getData() {
	ArrayList<Object[]> arr=GetdataForPL.getTestDataForNewPL();
	return arr.iterator();
	}
	      
	@Test(priority = 1,dataProvider = "getTestDataForNewPL")
	public void TestNewPLFUn(String name,String company,String salary,String pincode,String pan,String email) throws InterruptedException{
	newpl=new NewPLShortForm();
	newpl.NewPlshortFormFun(name, company, salary, pincode, pan, email);
	}
	
	@Test(priority = 2)
	public void Testloanamountpage() throws InterruptedException{
	newpl=new NewPLShortForm();
	newpl.loanamountfun();
	}
	
	
	@Test(enabled = false)
	public void tearDownn() throws InterruptedException {
	Thread.sleep(4000);
	driver.close();
	}

}
