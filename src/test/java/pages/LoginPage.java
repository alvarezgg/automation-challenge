package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import scripts.BaseTest;
import utils.Config;
import utils.Logger;

public class LoginPage extends BasePage{

	private final String URL = "https://www.saucedemo.com/";
	
	public LoginPage(WebDriver driver, BaseTest test) {
		this.driver = driver;
		this.test = test;
	}

	@Override
	public BasePage reach() {
		this.driver.get(this.getPageURL());
		return new LoginPage(this.driver,this.test);
	}

	//	Login locators
	private By usernameInput = By.xpath("//input[@data-test='username']");
	private By passwordInput = By.xpath("//input[@data-test='password']");
	private By loginButton = By.xpath("//input[@data-test='login-button']");
	private By loginErrorContainer = By.xpath("//*[contains(@class,'error') and contains(@class,'container')]");
	private By loginErrorMessage = By.xpath("//*[@data-test='error']");
	
	public String getPageURL() {
		return this.URL;
	}
	
	public InventoryPage login() {
		return this.login(Config.getBaseConfig("userName"), Config.getBaseConfig("password"));
	}
	public InventoryPage login(String userName, String password) {
//		Ingresar en input user
		Logger.log("Ingresar "+userName+" en input UserName");
		find(usernameInput).clear();
		find(usernameInput).sendKeys(userName);
		
//		Ingresar en input pass
		Logger.log("Ingresar "+password+" en input UserName");
		find(passwordInput).clear();
		find(passwordInput).sendKeys(password);
//		Clickear boton login
		Logger.log("Clickear boton Login");
		findAndClick(loginButton);
//		
		return new InventoryPage(this.driver,this.test);
	}

	public String getLoginMessage() {
		return find(loginErrorMessage).getText();
	}

	public Boolean hasLoginError() {
		return find(loginErrorContainer).isDisplayed();
	}


}
