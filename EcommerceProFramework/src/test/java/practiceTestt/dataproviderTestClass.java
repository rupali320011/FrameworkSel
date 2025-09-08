package practiceTestt;

import org.testng.annotations.Test;

public class dataproviderTestClass extends dataproviderClass {

	@Test(dataProvider = "getdata")
	public void test(String un,String psw) {
		System.out.println(un+" "+psw);
	}
}
