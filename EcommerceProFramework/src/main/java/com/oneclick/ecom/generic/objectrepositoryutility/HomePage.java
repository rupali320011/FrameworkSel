package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountlink;
	
	@FindBy(xpath = "//a[text()=' Books']")
    private WebElement bookbtn;
	
	@FindBy(xpath = "//a[.=' Electronics']")
    private WebElement electronicbtn;
	
	@FindBy(linkText = "Wishlist")
	private WebElement wishlistlink;
	
	@FindBy(linkText = "My Cart")
	private WebElement mycartlink;
	
	@FindBy(linkText = "Login")
	private WebElement loginlink;
	  
	@FindBy(linkText = "Login")
	private WebElement createAccountlink;
	
	@FindBy(linkText = "Admin Login")
	private WebElement adminloginlink;
	
	@FindBy(linkText = "Track Order")
	private WebElement trackOrderlink;
	
	@FindBy(name = "product")
	private WebElement searchfieldEdt;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutbtn;
	
	public WebElement getMyAccountlink() {
		return myAccountlink;
	}
	
	public WebElement getBookbtn() {
		return bookbtn;
	}
	

	public WebElement getElectronicbtn() {
		return electronicbtn;
	}

	public WebElement getSearchfieldEdt() {
		return searchfieldEdt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getWishlistlink() {
		return wishlistlink;
	}
	public WebElement getMycartlink() {
		return mycartlink;
	}
	public WebElement getLoginlink() {
		return loginlink;
	}
	public WebElement getCreateAccountlink() {
		return createAccountlink;
	}
	public WebElement getAdminloginlink() {
		return adminloginlink;
	}
	public WebElement getTrackOrderlink() {
		return trackOrderlink;
	}
	
	public WebElement getLogoutBtn() {
		return logoutbtn;
	}
	
	public void searchProduct(String productname)
	{
		searchfieldEdt.sendKeys(productname, Keys.ENTER);	
	}
	
	

	
}
