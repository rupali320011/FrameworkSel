package com.ecomm.UserTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ecom.basetest.BaseClass;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.fileutility.PropertyFileUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.Eletronpage;
import com.oneclick.ecom.generic.objectrepositoryutility.HomePage;
import com.oneclick.ecom.generic.objectrepositoryutility.Mycartpage;
import com.oneclick.ecom.generic.objectrepositoryutility.UserLoginPage;
import com.oneclick.ecom.generic.objectrepositoryutility.paymentmtdpage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class NavigatingtoPlaceorderTest extends BaseClass {

	@Test
	
	public void placeorderTest() throws IOException {
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		PropertyFileUtility plib=new PropertyFileUtility();
		
		String usernamee=plib.getDataFromPropertiesFile("username");
		String psw=plib.getDataFromPropertiesFile("password");
		
		HomePage hp=new HomePage(driver);
		hp.getLoginlink().click();
		
		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.loginToApp1(usernamee, psw);
		
		hp.getElectronicbtn().click();
		wlib.scrolldownBypixel(driver,300);
		
		Eletronpage elp=new Eletronpage(driver);
		elp.getAddtocartbtn().click();
		wlib.switchToAlertandAccept(driver);
		
		Mycartpage mlp=new Mycartpage(driver);
		wlib.sleepinmilisecondss(2000);
		mlp.getUpdateshopcartbtn().click();
		//wlib.sleepinmilisecondss(2000);
		wlib.switchToAlertandAccept(driver);
		//wlib.sleepinmilisecondss(2000);
		wlib.scrolldownBypixel(driver,500);
		wlib.sleepinmilisecondss(4000);
		mlp.getChkoutbtn().click();
		
		wlib.sleepinmilisecondss(2000);
		paymentmtdpage pmp=new paymentmtdpage(driver);
		pmp.getSubmitbtn().click();
		
		
		
		hp.getLogoutBtn().click();
		
		
		
	}
}
