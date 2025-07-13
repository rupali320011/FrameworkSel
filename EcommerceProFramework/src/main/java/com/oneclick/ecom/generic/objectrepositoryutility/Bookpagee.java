package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bookpagee {

	WebDriver driver;
	public Bookpagee(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@title='Wishlist'])[2]")
	private WebElement wishlsticon;
	
	
	public WebElement getWishlsticon() {
		return wishlsticon;
	}
	
	
	
	
	
	
	
}
