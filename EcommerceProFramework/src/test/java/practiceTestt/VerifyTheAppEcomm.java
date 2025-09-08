package practiceTestt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheAppEcomm extends dataproviderClass{

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
//	@DataProvider(name="getdata")
//	public Object[][] getdata(){
//		Object[][] objarr=new Object[2][2];
//		objarr[0][0]="deepak";
//		objarr[0][1]="12345";
//		objarr[1][0]="neha";
//		objarr[1][1]="1234";
//		return objarr;
//	}

}
