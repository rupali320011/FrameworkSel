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
	
	
	//String fullname=elib.getDataFromExcelFile("adminS",19,2);
	String emaill=elib.getDataFromExcelFile("adminS",19,3);
	//String mobno=elib.getDataFromExcelFile("adminS",19,4);
	String psw=elib.getDataFromExcelFile("adminS",19,5);
	//String conpsw=elib.getDataFromExcelFile("adminS",19,6);
	//String msgg=elib.getDataFromExcelFile("adminS",22,1);
	//String conmsgg=elib.getDataFromExcelFile("adminS",22,2);
	
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
//    String actConfirmation = ale.getText();
//   boolean status = ale.equals(conmsgg); 
//	
//	//assertTrue(status);
//	ale.accept();
////	
	
	
	
	
	
	
	
	
	
}
}