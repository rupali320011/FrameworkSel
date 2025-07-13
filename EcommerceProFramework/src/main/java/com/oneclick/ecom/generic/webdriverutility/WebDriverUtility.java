 package com.oneclick.ecom.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WebDriverUtility {
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void waitForURLContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(url));
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	public void switchToParentWindow(WebDriver driver, String parentWindowHandle) {
	    driver.switchTo().window(parentWindowHandle);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertandDismmis(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void moveOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver); 
		act.doubleClick(element).perform(); 
	}
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver); 
		act.contextClick(element).perform(); 
	}
	
	public void scrollactions(WebDriver driver,int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void scrolldowntoaParticularElement(WebDriver driver, WebElement element ,WebElement element1)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element ,element1);
	}

	public void scrollBottom(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public void waitForElementWithFluentWait(WebDriver driver, WebElement element, int timeoutSeconds, int pollingSeconds) {
	    new org.openqa.selenium.support.ui.FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(timeoutSeconds))
	        .pollingEvery(Duration.ofSeconds(pollingSeconds))
	        .ignoring(org.openqa.selenium.NoSuchElementException.class)
	        .until(ExpectedConditions.visibilityOf(element));
	}
	public String getAlertText(WebDriver driver) {
	    return driver.switchTo().alert().getText();
	}
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	    Actions actions = new Actions(driver);
	    actions.dragAndDrop(source, target).perform();
	}
	public void uploadFile(WebElement inputElement, String filePath) {
	    inputElement.sendKeys(filePath);
	}
	public void clearAndType(WebElement element, String text) {
	    element.clear();
	    element.sendKeys(text);
	}
	public void refreshPage(WebDriver driver) {
	    driver.navigate().refresh();
	}
	public void navigateTo(WebDriver driver, String url) {
	    driver.navigate().to(url);
	}
	public String acceptAlertAndGetText(WebDriver driver) {
	    String text = driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	    return text;
	}

	public String dismissAlertAndGetText(WebDriver driver) {
	    String text = driver.switchTo().alert().getText();
	    driver.switchTo().alert().dismiss();
	    return text;
	}
	  public SoftAssert softAssert = new SoftAssert();

	    // -------------------- Hard Assertions --------------------

	    // Assert that two strings are equal
	    public void assertEquals(String actual, String expected) {
	        Assert.assertEquals(actual, expected);
	    }

	    // Assert that WebElement text equals expected value
	    public void assertElementTextEquals(WebElement element, String expectedText) {
	        String actualText = element.getText().trim();
	        Assert.assertEquals(actualText, expectedText.trim());
	    }

	    // Assert page title
	    public void assertTitleEquals(WebDriver driver, String expectedTitle) {
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle);
	    }

	    // Assert current URL
	    public void assertURLEquals(WebDriver driver, String expectedURL) {
	        String actualURL = driver.getCurrentUrl();
	        Assert.assertEquals(actualURL, expectedURL);
	    }

	    // -------------------- Soft Assertions --------------------

	    // Assert two strings are equal
	    public void softAssertEquals(SoftAssert softAssert, String actual, String expected) {
	        softAssert.assertEquals(actual, expected);
	    }

	    // Assert WebElement text equals expected
	    public void softAssertElementTextEquals(SoftAssert softAssert, WebElement element, String expectedText) {
	        String actualText = element.getText().trim();
	        softAssert.assertEquals(actualText, expectedText.trim());
	    }

	    // Assert current page title
	    public void softAssertTitleEquals(SoftAssert softAssert, WebDriver driver, String expectedTitle) {
	        String actualTitle = driver.getTitle();
	        softAssert.assertEquals(actualTitle, expectedTitle);
	    }

	    // Assert current URL
	    public void softAssertURLEquals(SoftAssert softAssert, WebDriver driver, String expectedURL) {
	        String actualURL = driver.getCurrentUrl();
	        softAssert.assertEquals(actualURL, expectedURL);
	    }
	    
	    public void scrolldownBypixel(WebDriver driver,int pixels) {
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("window.scrollBy(0,"+pixels+")");
	    }
	    public static void sleepinmilisecondss(int milliseconds) {
	    	try {
	    		Thread.sleep(milliseconds);
	    	}catch(InterruptedException e) {
	    		e.printStackTrace();
	    	}
	    }
	}

