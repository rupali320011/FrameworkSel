package com.ecomm.adminModuleTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ecom.basetest.BaseClassAdmin;
import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import com.oneclick.ecom.generic.listenerutility.ListenerImpClass;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminLoginPage;
import com.oneclick.ecom.generic.objectrepositoryutility.AdminPage;
import com.oneclick.ecom.generic.objectrepositoryutility.CreateCategoryPage;
import com.oneclick.ecom.generic.objectrepositoryutility.InsertProductPage;
import com.oneclick.ecom.generic.objectrepositoryutility.SubCategoryPage;
import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

@Listeners(ListenerImpClass.class)
public class NavigatetouserLoginLogTest extends BaseClassAdmin {

	String usernamee="admin";
	String passwordd="admin";
	@Test(groups = {"smokeTest"})
	public void loginlogTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String catagoryname=elib.getDataFromExcelFile("adminS",1,2);
		String description=elib.getDataFromExcelFile("adminS",1,3);
		String subcatagory=elib.getDataFromExcelFile("adminS",4,2);
		String productname=elib.getDataFromExcelFile("adminS",7,3);
		String productcompany=elib.getDataFromExcelFile("adminS",7,4);
		String productpriceBD=elib.getDataFromExcelFile("adminS",7,5);
		String productpriceAD=elib.getDataFromExcelFile("adminS",7,6);
		String productshippingcharge=elib.getDataFromExcelFile("adminS",7,9);
		String productdescription=elib.getDataFromExcelFile("adminS",7,8);
		String productAvailability=elib.getDataFromExcelFile("adminS",7,10);
		
		
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.logintoApp1(usernamee, passwordd);
		
		AdminPage ap=new AdminPage(driver);
		ap.getCreateCategorylink().click();
		
		CreateCategoryPage ccp=new CreateCategoryPage(driver);
		 ccp.createCategory(catagoryname, description);
		   
		   ap.getSubCategorylink().click();
		   
		   SubCategoryPage scp=new SubCategoryPage(driver);
		   scp.CreateSubCategory(catagoryname, subcatagory);
		   
		   ap.getInsertProductlink().click();
		   InsertProductPage ipp=new InsertProductPage(driver);
		   ipp.insertProduct(catagoryname,productname, productcompany, productpriceBD, productpriceAD, productdescription, productshippingcharge, productAvailability);
		
		   ipp.getProductimage1Edt().sendKeys("C:\\Users\\asima\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-07-04 102627.jpg.png");
		   ipp.getProductimage2Edt().sendKeys("C:\\Users\\asima\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-07-04 102627.jpg.png");
		   ipp.getProductimage3Edt().sendKeys("C:\\Users\\asima\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-07-04 102627.jpg.png");
		
		ap.getManageProductlink().click();
		ap.getUserLoginLoglink().click();
		
		
		
	}
}
