package com.ecom.basetest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

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

import com.oneclick.ecom.generic.databaseutility.DatabaseUtility;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.fileutility.PropertyFileUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminLoginPage;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminPage;
import com.oneclick.ecom.generic.objectrepositoryutility.HomePage;
import com.oneclick.ecom.generic.objectrepositoryutility.UserLoginPage;
import com.oneclick.ecom.generic.webdriverutility.JavaUtility;
import com.oneclick.ecom.generic.webdriverutility.UtilityClassObject;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class BaseClassAdmin {
	
	public DatabaseUtility dblib = new DatabaseUtility();
	public PropertyFileUtility plib = new PropertyFileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wdlib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() {
		System.out.println("connect to DB , Report Config");
		dblib.getDBConnection();
	}

	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws IOException {
		System.out.println("launch the browser");
	String browser = plib.getDataFromPropertiesFile("browser");
//		String browser=System.getProperty("browser");
//		System.out.println(browser);

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
//		sdriver = driver;
//		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException {

		AdminLoginPage alp = new AdminLoginPage(driver);
		String url = plib.getDataFromPropertiesFile("url");
		String adminusn = plib.getDataFromPropertiesFile("adminusn");
		String adminpwd = plib.getDataFromPropertiesFile("adminpwd");
//		String url=System.getProperty("url");
//		String adminusn=System.getProperty("adminusn");
//		String adminpwd=System.getProperty("adminpwd");
		//alp.logintoApp1(url, adminusn, adminpwd);
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		System.out.println("Login");

	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM() {
		AdminPage ap = new AdminPage(driver);
		ap.getLogoutlink().click();
		System.out.println("Logout");
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("close the browser");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close DB, Report Backup");
		dblib.closeDBConnection();
	}

}
