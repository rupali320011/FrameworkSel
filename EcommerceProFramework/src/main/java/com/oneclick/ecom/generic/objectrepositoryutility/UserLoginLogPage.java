package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserLoginLogPage extends BasePage {

	public UserLoginLogPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchfieldEdt;
	
	@FindBy(name = "DataTables_Table_0_length")
	private WebElement showEntries;
	
	public WebElement getSearchfieldEdt() {
		return searchfieldEdt;
	}
	public WebElement getShowEntries() {
		return showEntries;
	}
	
	public void showEntries(WebElement element, String number)
	{
		Select s = new Select(element);
		s.selectByVisibleText(number);
	} 
}
