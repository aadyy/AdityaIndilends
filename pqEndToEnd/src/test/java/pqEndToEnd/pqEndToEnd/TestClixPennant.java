package pqEndToEnd.pqEndToEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import locatores.PLlocatores;
import pqUserCreation.CreatePquser;
import pqUserCreation.UpdatePQDBvalues;
import utilities.GetdataForPL;

public class TestClixPennant extends Base {
	CreatePquser crPQuserObj;
	UpdatePQDBvalues updatepqobj; 
	PLlocatores plloc;
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
	
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}

	LoginPage obj;
	@Test(priority = 0,enabled = false)
	public void testLoginAndOffer() throws InterruptedException {
	obj=new LoginPage();
	obj.ClixPennanatLoginJavaFun();
	}
	
	@Test(priority = 1,enabled = true,dataProvider = "getTestDataUtilsFu")
	public void shortFormPanFormDetails(String name,String email,String pincode,String company,String salary) throws InterruptedException{
	PLshortForm obj=new PLshortForm();
	PLpanForm pan=obj.PlshortFormFun(name, email, pincode, company, salary);
	pan.PLpanformFun();
	}

	@Test(priority = 2)
    public void personalandOfficeDetailsDetails() throws InterruptedException {
	PLpersonalDetails pp=new PLpersonalDetails();
	PLofficeDetails ofc=pp.PLpersonalDetailsFun();
	ofc.PlofficeDetailsFun();
	}
   
	@Test(priority = 3)
	private void additionalDetails() throws InterruptedException {
	PLadditionalDetails ad=new PLadditionalDetails();
	ad.PLadditionalDetailsFun();
	}
}