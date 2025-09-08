package practiceTestt;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.oneclick.ecom.generic.databaseutility.DatabaseUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheProjectNameInDatabase {

	DatabaseUtility dlib=new DatabaseUtility();
	
	@Test(priority = 1)
	public void test() throws SQLException {
		String emp_name="admin";
		boolean flag=false;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		dlib.getDBConnection();
		ResultSet result = dlib.executeSelectQuery("select* from employee");
		while(result.next()) {
			String actulEmpname=result.getString(5);
			
			if(emp_name.equals(actulEmpname)) {
				flag=true;
				System.out.println(emp_name+"is available db==pass");
				break;
			}
		}
		if(flag==false) {
			System.out.println(emp_name+"is not available db==fail");
		}
		dlib.closeDBConnection();
		driver.quit();
	}
	@Test(priority = 2)
	public void test2() throws SQLException {
		dlib.getDBConnection();
		 List<String> empNames = dlib.getColoumnData("select emp_name from employee","emp_name");
		 for(String names:empNames) {
			 System.out.println(names);
		 }
		 dlib.closeDBConnection();
	}
	@Test(priority = -1)
	public void printAllDataFromDataBase() throws SQLException {
		dlib.getDBConnection();
		ResultSet result = dlib.executeSelectQuery("select* from employee");
		//dynamically get all column names from the employee table
		ResultSetMetaData rsmd = result.getMetaData();
		int cc = rsmd.getColumnCount();
		for(int i=1;i<=cc;i++) {
			System.out.print(rsmd.getColumnName(i)+"\t");
		}
		while(result.next()) {
			for(int i=1;i<=cc;i++) {
				System.out.print(result.getString(i)+"\t");
			}
			System.out.println();
		}
		dlib.getDBConnection();
	}
	}

