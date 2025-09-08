package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class CreateNewAccountPage 
{
	WebDriver driver;
	public CreateNewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriverUtility wlib=new WebDriverUtility();
	
	@FindBy(name = "fullname")
	private WebElement fullnameEdt;
	
	@FindBy(name = "emailid")
	private WebElement emailEdt;
	
	@FindBy(name = "contactno")
	private WebElement contactNoEdt;
	
	@FindBy(xpath = "(//input[@name='password'])[2]")
	private WebElement passwordEdt;
	
	@FindBy(name = "confirmpassword")
	private WebElement confirmpasswordEdt;
	
	@FindBy(name = "submit")
	private WebElement signupbtn;

	public WebElement getFullnameEdt() {
		return fullnameEdt;
	}
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	public WebElement getContactNoEdt() {
		return contactNoEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getConfirmpasswordEdt() {
		return confirmpasswordEdt;
	}
	
	
	public WebElement getSignupbtn() {
		return signupbtn;
	}
	public void CreateNewAccount(String fullname, String email, String contactno, String password, String cpassword )
	{
		getFullnameEdt().sendKeys(fullname);
		getEmailEdt().sendKeys(email);
		getContactNoEdt().sendKeys(contactno);
		wlib.scrolldownBypixel(driver,300);
		getPasswordEdt().sendKeys(password);
		getConfirmpasswordEdt().sendKeys(cpassword);
		
		
	}
	

}
