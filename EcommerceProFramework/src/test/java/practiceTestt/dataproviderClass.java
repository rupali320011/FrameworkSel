package practiceTestt;

import org.testng.annotations.DataProvider;

public class dataproviderClass {

	@DataProvider(name="getdata")
	public Object[][] getdata(){
		Object[][] objarr=new Object[2][2];
		objarr[0][0]="deepak";
		objarr[0][1]="1234";
		objarr[1][0]="neha";
		objarr[1][1]="4321";
		return objarr;
	}
}
