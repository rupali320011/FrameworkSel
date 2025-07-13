package com.ecomm.UserTest;




import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ecom.basetest.BaseClass;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.CreateNewAccountPage;
import com.oneclick.ecom.generic.objectrepositoryutility.HomePage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class NavigatingtomycartTest extends BaseClass {

	@Test
	public void subcatatoryTest() throws EncryptedDocumentException, IOException {
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String fullname=elib.getDataFromExcelFile("adminS",19,2);
	String emaill=elib.getDataFromExcelFile("adminS",19,3);
	String mobno=elib.getDataFromExcelFile("adminS",19,4);
	String psw=elib.getDataFromExcelFile("adminS",19,5);
	String conpsw=elib.getDataFromExcelFile("adminS",19,6);
	//String msgg=elib.getDataFromExcelFile("adminS",22,1);
	
	HomePage hp=new HomePage(driver);
	hp.getLoginlink().click();
	
	CreateNewAccountPage cnap=new CreateNewAccountPage(driver);
	cnap.CreateNewAccount(fullname, emaill, mobno, psw, conpsw);
	cnap.getSignupbtn().click();
	
	wlib.switchToAlertandAccept(driver);
	
	hp.getLogoutBtn().click();

	
	
	
	
	
	
	
	
	
	
}
}