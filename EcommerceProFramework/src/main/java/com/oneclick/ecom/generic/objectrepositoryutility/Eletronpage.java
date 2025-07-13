package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Eletronpage {

	WebDriver driver;
	public Eletronpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//button[.='Add to cart'])[3]")
	private WebElement addtocartbtn;
	
	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	
	
	
	
	
	
}
