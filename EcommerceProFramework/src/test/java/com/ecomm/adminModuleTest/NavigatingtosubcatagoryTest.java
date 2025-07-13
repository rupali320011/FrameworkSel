package com.ecomm.adminModuleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ecom.basetest.BaseClassAdmin;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminLoginPage;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminPage;
import com.oneclick.ecom.generic.objectrepositoryutility.CreateCategoryPage;
import com.oneclick.ecom.generic.objectrepositoryutility.SubCategoryPage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class NavigatingtosubcatagoryTest extends BaseClassAdmin {

	
   String usernamee="admin";
   String passwordd="Test@123";
	@Test
	public void subcatatoryTest() throws EncryptedDocumentException, IOException {
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	String catagoryname=elib.getDataFromExcelFile("adminS",1,2);
	String description=elib.getDataFromExcelFile("adminS",1,3);
	String subcatagory=elib.getDataFromExcelFile("adminS",4,2);
	
   AdminLoginPage alp=new AdminLoginPage(driver);
   alp.logintoApp1(usernamee,passwordd);
   
   AdminPage ap=new AdminPage(driver);
   wlib.waitForPagetoLoad(driver);
   ap.getOrderManagementlink().click();
   ap.getTodaysorderlnk().click();
   wlib.waitForPagetoLoad(driver);
   ap.getManageuserslink().click();
   wlib.waitForPagetoLoad(driver);
   ap.getCreateCategorylink().click();
   
   CreateCategoryPage ccp=new CreateCategoryPage(driver);
   ccp.createCategory(catagoryname, description);
   
   ap.getSubCategorylink().click();
   
   SubCategoryPage scp=new SubCategoryPage(driver);
   scp.CreateSubCategory(catagoryname, subcatagory);
   
   
   
   
   
   
   
   
   
   
}
}