package com.ecomm.UserTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import com.ecom.basetest.BaseClass;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.Bookpagee;
//import com.oneclick.ecom.generic.objectrepositoryutility.Bookpagee;
import com.oneclick.ecom.generic.objectrepositoryutility.Eletronpage;
import com.oneclick.ecom.generic.objectrepositoryutility.HomePage;
import com.oneclick.ecom.generic.objectrepositoryutility.UserLoginPage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class NavigatingtomycartTestt extends BaseClass {

	@Test
	public void subcatatoryTest() throws EncryptedDocumentException, IOException {
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String emaill=elib.getDataFromExcelFile("adminS",19,3);
	
	String psw=elib.getDataFromExcelFile("adminS",19,5);
	
	
	HomePage hp=new HomePage(driver);
	hp.getLoginlink().click();
	
	UserLoginPage ulp=new UserLoginPage(driver);
	ulp.loginToApp1(emaill,psw);
	
	hp.getBookbtn().click();
	wlib.scrollBottom(driver);
	
	Bookpagee bpp=new Bookpagee(driver);
	bpp.getWishlsticon().click();
	
	hp.getElectronicbtn().click();
	wlib.scrollBottom(driver);
	
	Eletronpage elp=new Eletronpage(driver);
    elp.getAddtocartbtn().click();
    wlib.switchToAlertandAccept(driver);
    
    
    
    hp.getLogoutBtn().click();

	
	
	
	
	
	
	
	
	
}
}