package com.ecomm.UserTest;

import java.io.IOException;



import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecom.basetest.BaseClass;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.fileutility.PropertyFileUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.Eletronpage;
import com.oneclick.ecom.generic.objectrepositoryutility.HomePage;
import com.oneclick.ecom.generic.objectrepositoryutility.Mycartpage;
import com.oneclick.ecom.generic.objectrepositoryutility.UserLoginPage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class NavigatingtoPlaceorderTest extends BaseClass {

	String cnfrmMsg="Product has been added to the cart";
	@Test
	public void placeorderTest() throws IOException {
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		
		String email=plib.getDataFromPropertiesFile("email");
		String password=plib.getDataFromPropertiesFile("password");
		
		HomePage hp=new HomePage(driver);
		hp.getLoginlink().click();
		
		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.loginToApp1(email, password);
		
		hp.getElectronicbtn().click();
		wlib.scrolldownBypixel(driver,300);
		
		Eletronpage elp=new Eletronpage(driver);
		elp.getAddtocartbtn().click();
		
		
		Alert ale = driver.switchTo().alert();
		String actConfirmation = ale.getText();

		Assert.assertEquals(actConfirmation,cnfrmMsg);
		System.out.println("product is added");
		wlib.waitForPagetoLoad(driver);
		ale.accept();
		
		Mycartpage mlp=new Mycartpage(driver);
		wlib.sleepinmilisecondss(2000);
		mlp.getUpdateshopcartbtn().click();
		
		
		
		
		
		
		
		
	}
}
