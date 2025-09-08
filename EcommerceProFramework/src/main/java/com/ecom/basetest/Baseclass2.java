package com.ecom.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.oneclick.ecom.generic.databaseutility.DatabaseUtility;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.fileutility.PropertyFileUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.UserLoginPage;
import com.oneclick.ecom.generic.webdriverutility.JavaUtility;
import com.oneclick.ecom.generic.webdriverutility.UtilityClassObject;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class Baseclass2 {

	public DatabaseUtility dblib = new DatabaseUtility();
	public PropertyFileUtility plib = new PropertyFileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wdlib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println("connect to DB , Report Config");
		dblib.getDBConnection(); 
		spark=new ExtentSparkReporter("./Reportfolder/report3.html");
		spark.config().setDocumentTitle("ecomm testSuiteResults");
		spark.config().setReportName("ecomm report");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();  //Manages the report (attach reporter, add system info)
		report.attachReporter(spark);
		report.setSystemInfo("OS","window-10");
		report.setSystemInfo("browser","chrome-100");
	}
	
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws IOException
	{
		System.out.println("launch the browser");
		String browser = plib.getDataFromPropertiesFile("browser");
	
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
			}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
		System.out.println("Login");
		
		UserLoginPage l = new UserLoginPage(driver);
		String url=plib.getDataFromPropertiesFile("url");
		//l.logintooApp(url);
		//String email=plib.getDataFromPropertiesFile("email");
		//String password=plib.getDataFromPropertiesFile("password");
		//l.logintoApp(url, email, password);
		
		driver.get(url);
	    driver.manage().window().maximize();	
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{	
		System.out.println("Logout");
	} 
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("close the browser");	
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException
	{
		System.out.println("close DB, Report Backup");	
		dblib.closeDBConnection();
}
}

