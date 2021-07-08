package Testclass;

import java.io.IOException;

import org.testng.annotations.Test;
import pageclass.Base;
import pqUserCreation.CreatePquser;
import utilities.WebActions;

//@Listeners(pageclass.Listeneres.class)
public class TestpquserCreationOnly extends Base {
	
	
	CreatePquser obj;
	@Test(priority = 1,groups = {"sanity"})
	private void Testpquser() throws InterruptedException {
	obj=new CreatePquser();
	obj.createPQuserFun();
	}
	
	@Test(priority = 2,groups = {"sanity"})
	private void title() throws InterruptedException, IOException {
	loadBrowser("https://www.google.com/");
	System.out.println("Title of the page is: "+driver.getTitle());
	driver.close();
	}
	
	@Test(priority = 3,groups = {"regression"})
	private void openIndialends() throws InterruptedException, IOException {
	loadBrowser("https://www.indialends.com/");
	System.out.println("Title of the page is: "+driver.getTitle());
	driver.close();
	}

}
