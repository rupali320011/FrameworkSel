package com.oneclick.ecom.generic.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class AdminLoginPage 
{
	WebDriver driver;
	public AdminLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement adminUsn;
	
	@FindBy(name = "password")
	private WebElement adminPwd;
	
	@FindBy(name = "submit")
	private WebElement loginBtn;
	
	
	public WebElement getAdminUsn() {
		return adminUsn;
	}
	public WebElement getAdminPwd() {
		return adminPwd;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	WebDriverUtility wd = new WebDriverUtility();
	public void logintoApp(String url, String username, String password)
	{
		driver.get(url);
		wd.maximizeWindow(driver);
		wd.waitForPagetoLoad(driver);
		HomePage h = new HomePage(driver);
		h.getAdminloginlink().click();
		adminUsn.sendKeys(username);
		adminPwd.sendKeys(password);
		loginBtn.click();
		
	}
	public void logintoApp1(String username1, String password1)
	{
		adminUsn.sendKeys(username1);
		adminPwd.sendKeys(password1);
		loginBtn.click();
		
	}

}
