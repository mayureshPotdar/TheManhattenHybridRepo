package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	/* There is a possibility of stale element reference exception 
	 * when moving from one class to another class 
	 * at that time WebElement element = driver.findElement connection
	 * gets broken so for that we are using pageFactory design pattern
	 * we are auto initialize elements 
	 */
	
	WebDriver driver;
	//Objects
	@FindBy(xpath="//div[@id='top-links']/ul/li[2]/a/span[1]")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		/*we are instructing Page factory to 
		automatically initialize all the elements present in 
		this class*/
		PageFactory.initElements(driver,this);  
	}
	
	//Actions
	public void clickOnMyAccount()
	{
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLoginPage()
	{
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterProducIntoSearchBoxField(String productText)
	{
		searchBoxField.sendKeys(productText);
	}
	
	public SearchPage clickOnSearchButton()
	{
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage searchForProduct(String productText)
	{
		searchBoxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
	
	
	
}
