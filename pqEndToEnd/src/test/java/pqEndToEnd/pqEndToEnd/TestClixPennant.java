package pqEndToEnd.pqEndToEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import locatores.PLlocatores;
import pageclass.Base;
import pageclass.CLixStepperPage;
import pageclass.LoginPage;
import pageclass.PLadditionalDetails;
import pageclass.PLofficeDetails;
import pageclass.PLpanForm;
import pageclass.PLpersonalDetails;
import pageclass.PLshortForm;
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
	 }  catch (InterruptedException e) {e.printStackTrace();}		
	}
	
	
	@Test(priority = 0, groups = {"LaunchBrowser"})
	private void launchBrowser() {
	try {
		loadBrowser("https://uatweb.indialends.com");
	} catch (IOException e) {e.printStackTrace();}
	}
	
	@DataProvider(name = "getTestDataUtilsFu")
	public Iterator<Object[]> getDataFromExcel() {
	ArrayList<Object[]> iterate=GetdataForPL.getTestDataUtilsFun();
	return iterate.iterator();
	}

	LoginPage obj;
	@Test(priority = 1,enabled = false)
	public void testLoginAndOffer() {
	obj=new LoginPage();
	obj.ClixPennanatLoginJavaFun();
	}
	
	@Test(priority = 2,enabled = true,dataProvider = "getTestDataUtilsFu",groups = {"shortpan"},dependsOnGroups = {"LaunchBrowser"})
	public void shortFormPanFormDetails(String name,String email,String pincode,String company,String salary) throws InterruptedException{
	PLshortForm obj=new PLshortForm();
	PLpanForm pan=obj.PlshortFormFun(name, email, pincode, company, salary);
	pan.PLpanformFun();
	}

	@Test(priority = 3,enabled = true,groups = {"personalofcdetails"},dependsOnGroups = {"shortpan"})
    public void personalandOfficeDetailsDetails()  {
	PLpersonalDetails pp=new PLpersonalDetails();
	PLofficeDetails ofc=pp.PLpersonalDetailsFun();
	ofc.PlofficeDetailsFun();
	}
   
	@Test(priority = 4,  enabled = true,groups = {"additional"},dependsOnGroups = {"personalofcdetails"})
	private void additionalDetails() throws InterruptedException{
	PLadditionalDetails ad=new PLadditionalDetails();
	ad.PLadditionalDetailsFun();
	}
	
	@Test(priority = 5, enabled = true,groups = {"clixstepper"},dependsOnGroups = {"additional"})
	private void TestClixStepper() throws InterruptedException {
	CLixStepperPage clix=new CLixStepperPage();
	clix.CLixStepperPageFun();
	}
	

}