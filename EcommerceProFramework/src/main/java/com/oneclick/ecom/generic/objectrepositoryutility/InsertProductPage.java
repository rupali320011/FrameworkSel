package com.oneclick.ecom.generic.objectrepositoryutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.oneclick.ecom.generic.webdriverutility.WebDriverUtility;

public class InsertProductPage extends BasePage
{
	public InsertProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name = "category")
	private WebElement categoryNameDB;
	
	@FindBy(name = "subcategory")
	private WebElement subcategoryDB;

	@FindBy(name = "productName")
	private WebElement productnameEdt;

	@FindBy(name = "productCompany")
	private WebElement productCompanyEdt;

	@FindBy(name = "productpricebd")
	private WebElement productpriceBDEdt;

	@FindBy(name = "productprice")
	private WebElement productpriceADEdt;

	@FindBy(xpath = "//div[@class=' nicEdit-selected']")
	private WebElement productDescriptionEdt;

	@FindBy(name = "productShippingcharge")
	private WebElement productShippingchargeEdt;

	@FindBy(id = "productAvailability")
	private WebElement productAvailabilityDB;

	@FindBy(name = "productimage1")
	private WebElement productimage1Edt;

	@FindBy(name = "productimage2")
	private WebElement productimage2Edt;

	@FindBy(name = "productimage3")
	private WebElement productimage3Edt;

	@FindBy(name = "submit")
	private WebElement insertBtn;

	@FindBy(xpath = "//div[@class='alert alert-success']/strong")
	private WebElement ActConfirmationMsg;

	public WebElement getCategoryNameDB() {
		return categoryNameDB;
	}

	public WebElement getSubcategoryDB() {
		return subcategoryDB;
	}

	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getProductCompanyEdt() {
		return productCompanyEdt;
	}

	public WebElement getProductpriceBDEdt() {
		return productpriceBDEdt;
	}

	public WebElement getProductpriceADEdt() {
		return productpriceADEdt;
	}

	public WebElement getProductDescriptionEdt() {
		return productDescriptionEdt;
	}

	public WebElement getProductShippingchargeEdt() {
		return productShippingchargeEdt;
	}

	public WebElement getProductAvailabilityDB() {
		return productAvailabilityDB;
	}

	public WebElement getProductimage1Edt() {
		return productimage1Edt;
	}

	public WebElement getProductimage2Edt() {
		return productimage2Edt;
	}

	public WebElement getProductimage3Edt() {
		return productimage3Edt;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}

	public WebElement getActConfirmationMsg() {
		return ActConfirmationMsg;
	}


	public void insertProduct(String category, String productName, String productCompany,
			String beforeDiscount, String afterDiscount, String productDescription, String productShippingCharge,
			String availability) throws InterruptedException {

		// Select Category
		Select catSelect = new Select(categoryNameDB);
		catSelect.selectByVisibleText(category);

		// Select Subcategory
//		Select subcatSelect = new Select(subcategoryDB);
//		subcatSelect.selectByVisibleText(subcategory);

		// Fill product details
		productnameEdt.sendKeys(productName);
		productCompanyEdt.sendKeys(productCompany);
		productpriceBDEdt.sendKeys(beforeDiscount); // Before Discount
		productpriceADEdt.sendKeys(afterDiscount); // After Discount
		// productDescriptionEdt.sendKeys(productDescription);
		productShippingchargeEdt.sendKeys(productShippingCharge);
		

		// Select Availability
		Thread.sleep(1000);
		WebDriverUtility wd = new WebDriverUtility();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productAvailabilityDB);
		Thread.sleep(500); // give time for scrolling
		//dropdown.click();

		wd.waitForElementToBeClickable(driver, productAvailabilityDB);
		Select availabilitySelect = new Select(productAvailabilityDB);
		availabilitySelect.selectByVisibleText(availability);

		// Upload Images
		//productimage1Edt.sendKeys(image1Path);
		//productimage2Edt.sendKeys(image2Path);
//		productimage3Edt.sendKeys(image3Path);

		// Submit the form
		insertBtn.click();
	}

}
