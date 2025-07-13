package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage extends BasePage{

	public CreateCategoryPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name = "category")
	private WebElement categoryNameEdt;
	
	@FindBy(name = "description")
	private WebElement dedescriptionEdt;
	
	@FindBy(name = "submit")
	private WebElement createBtn;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement searchfieldEdt;
	
	@FindBy(xpath = "//div[@class='alert alert-success']/strong")
	private WebElement ActConfirmationMsg;
	
	public WebElement getCategoryNameEdt() {
		return categoryNameEdt;
	}
	public WebElement getdescriptionEdt() {
		return dedescriptionEdt;
	}
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getSearchfieldEdt() {
		return searchfieldEdt;
	}
	public WebElement getActConfirmationMsg() {
		return ActConfirmationMsg;
	}
	
	
	public void createCategory(String category, String description)
	{
		getCategoryNameEdt().sendKeys(category);
		getdescriptionEdt().sendKeys(description);
		getCreateBtn().click();
	}
}
