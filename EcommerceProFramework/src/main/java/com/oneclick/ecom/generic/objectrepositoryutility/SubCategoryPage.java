package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubCategoryPage extends BasePage
{
	public SubCategoryPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name = "category")
	private WebElement categoryNameDB;
	
	@FindBy(xpath = "//input[@placeholder='Enter SubCategory Name']")
	private WebElement subcategoryEdt;
	
	@FindBy(name = "submit")
	private WebElement createBtn;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement searchfieldEdt;
		
	@FindBy(xpath = "//div[@class='alert alert-success']/strong")
	private WebElement actConfirmationMsg;
	
	public WebElement getActConfirmationMsg() {
		return actConfirmationMsg;
	}
	public WebElement getCategoryNameDB() {
		return categoryNameDB;
	}
	public WebElement getSubcategoryEdt() {
		return subcategoryEdt;
	}
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getSearchfieldEdt() {
		return searchfieldEdt;
	}
	
	public void CreateSubCategory(String category, String subcategory)
	{
		Select s = new Select(categoryNameDB);
		s.selectByVisibleText(category);
		subcategoryEdt.sendKeys(subcategory);
		createBtn.click();
	}
	

}
