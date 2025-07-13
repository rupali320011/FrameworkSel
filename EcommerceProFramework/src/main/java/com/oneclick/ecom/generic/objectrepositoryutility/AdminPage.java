package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage 
{
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(.,'Order Management')]")
	private WebElement orderManagementlink;
	
	@FindBy(xpath = "(//i[@class='icon-tasks'])[1]")
	private WebElement todaysorderlnk;
	
	@FindBy(xpath = "(//i[@class='icon-tasks'])[2]")
	private WebElement pendinglnk;
	
	
	@FindBy(xpath = "//a[contains(.,'Manage users')]")
	private WebElement manageuserslink;
	
	@FindBy(xpath = "//a[contains(.,'Create Category')]")
	private WebElement createCategorylink;
	
	@FindBy(xpath = "//a[contains(.,'Sub Category')]")
	private WebElement subCategorylink;
	
	@FindBy(xpath = "//a[contains(.,'Insert Product')]")
	private WebElement insertProductlink;
	
	@FindBy(xpath = "//a[contains(.,'Manage Products')]")
	private WebElement manageProductlink;
	
	@FindBy(xpath = "//a[contains(.,'User Login Log')]")
	private WebElement userLoginLoglink;
	
	@FindBy(xpath = "(//a[contains(.,'Logout')])[2]")
	private WebElement logoutlink;
	
	public WebElement getOrderManagementlink() {
		return orderManagementlink;
	}
	
	public WebElement getTodaysorderlnk() {
		return todaysorderlnk;
	}
	

	public WebElement getPendinglnk() {
		return pendinglnk;
	}

	public WebElement getManageuserslink() {
		return manageuserslink;
	}
	public WebElement getCreateCategorylink() {
		return createCategorylink;
	}
	public WebElement getSubCategorylink() {
		return subCategorylink;
	}
	public WebElement getInsertProductlink() {
		return insertProductlink;
	}
	public WebElement getManageProductlink() {
		return manageProductlink;
	}
	public WebElement getUserLoginLoglink() {
		return userLoginLoglink;
	}
	public WebElement getLogoutlink() {
		return logoutlink;
	}
	

}
