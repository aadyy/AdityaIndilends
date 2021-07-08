package pageclass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeneres implements ITestListener  {

	public void onTestStart(ITestResult result) {System.out.println("onTestStart called"+result.getName());}
	public void onTestSuccess(ITestResult result) {System.out.println("onTestSuccess called"+result.getName());}
	public void onTestFailure(ITestResult result) {System.out.println("onTestfail called"+result.getName());}
	public void onTestSkipped(ITestResult result) {System.out.println("onTestSkipped called"+result.getName());}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {System.out.println("onTestFailedButWithinSuccessPercentage called "+result.getName());}
	public void onStart(ITestContext context) {System.out.println("onStart called"+context.getName());}
	public void onFinish(ITestContext context)	{System.out.println("onFinish called"+context.getName());}

}
