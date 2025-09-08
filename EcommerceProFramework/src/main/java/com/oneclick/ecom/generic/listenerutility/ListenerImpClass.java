package com.oneclick.ecom.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ecom.basetest.BaseClass;
import com.oneclick.ecom.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass  implements ITestListener, ISuiteListener 
{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("Report Configuration");
		String d = new Date().toString();
		String timeStamp = d.replaceAll(":", "-").replaceAll(" ", "_");
				
	    spark = new ExtentSparkReporter("./Reportfolder/report3_"+timeStamp+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// adv env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+">====START===="); //gets the name of the currently running test method.
	    test = report.createTest(result.getMethod().getMethodName()); //creates a new test entry in the ExtentReport with the test method’s name.
	    //stores the created test object in a utility class (usually a ThreadLocal wrapper) 
	    //so it can be accessed safely across parallel tests.
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED <===");
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===="+result.getMethod().getMethodName()+">====END====");
	    test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED <===");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		Date d = new Date();
		String d1 = d.toString();
		String time = d1.replaceAll(":", "-").replaceAll(" ", "_");
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(filepath,testname +"_"+ time);  //attaches the screenshot to the ExtentReport.
	    test.log(Status.FAIL, result.getMethod().getMethodName()+"===> FAILED <===");
	    test.log(Status.FAIL, result.getThrowable()); //logs the exception/error stack trace.

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
        System.out.println("test case skipped");
	}
	
	
	
	
}
 