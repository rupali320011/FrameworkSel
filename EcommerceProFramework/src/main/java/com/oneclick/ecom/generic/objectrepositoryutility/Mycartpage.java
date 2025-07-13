package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mycartpage {

	WebDriver driver;
	public Mycartpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "submit")
	private WebElement updateshopcartbtn;
	
	@FindBy(xpath = "//button[.='PROCCED TO CHEKOUT']")
	private WebElement chkoutbtn;
	
	
	public WebElement getUpdateshopcartbtn() {
		return updateshopcartbtn;
	}


	public WebElement getChkoutbtn() {
		return chkoutbtn;
	}
	
	

}
