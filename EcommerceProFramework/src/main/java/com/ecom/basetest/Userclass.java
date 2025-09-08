package com.ecom.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Userclass {

	
	public static void test() {
		ChromeOptions opt=new ChromeOptions();
		String userDatadir="c:\\seleniumProfiles\\profile_"+System.currentTimeMillis();
		opt.addArguments("userdatadirec"+userDatadir);
		WebDriver driver=new ChromeDriver(opt);
	}
}