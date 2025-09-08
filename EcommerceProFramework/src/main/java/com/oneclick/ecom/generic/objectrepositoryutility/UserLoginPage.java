package com.oneclick.ecom.generic.objectrepositoryutility;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class UserLoginPage 
{
	WebDriver driver;
	public UserLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement emailEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement loginBtn;
	
	public WebElement getUsername() {
		return emailEdt;
	}
	public WebElement getPassword() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	WebDriverUtility wdlib = new WebDriverUtility();
	public void logintoApp(String url, String email, String password)
	{
		driver.get(url);
		wdlib.waitForPagetoLoad(driver);
		wdlib.maximizeWindow(driver);
		HomePage h = new HomePage(driver);
		h.getLoginlink().click();
		emailEdt.sendKeys(email);
		passwordEdt.sendKeys(password,Keys.ENTER);
		
	}
	public void logintooApp(String url) {
		driver.get(url);
		wdlib.waitForPagetoLoad(driver);
		wdlib.maximizeWindow(driver);
	}
	public void loginToApp1(String emaill,String psw)
	{
		
		emailEdt.sendKeys(emaill);
		passwordEdt.sendKeys(psw);
		loginBtn.click();
	}


}
