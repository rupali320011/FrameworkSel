package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentmtdpage {

	WebDriver driver;
	public paymentmtdpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
}

