package practiceTestt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.oneclick.ecom.generic.fileutility.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyTheAppUsingDtaProviderExcelfile {

	
	@Test(dataProvider = "getdata")
	public void test(String email,String psw) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.josalukkaseasybuy.com/signIn");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder='Email / Phone Number']")).sendKeys(email);
		driver.findElement(By.id("mat-input-1")).sendKeys(psw);
		driver.quit();
		
	}
	@DataProvider(name="getdata")
	public Object[][] createdata() throws EncryptedDocumentException, IOException{
		ExcelUtility elib=new ExcelUtility();
		int totalrow=3;
		int totalcol=2;
		Object[][] objarr=new Object[totalrow][totalcol];
		for(int i=0;i<totalrow;i++) {
			for(int j=0;j<totalcol;j++) {
				 objarr[i][j]=elib.getDataFromExcelFile("sheet1",i+1,j);
			}
			
		}
		return objarr;
		
}
}

