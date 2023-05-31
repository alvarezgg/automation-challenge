package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scripts.BaseTest;

public abstract class BasePage {
	
	BaseTest test;
	WebDriver driver;
	
	public abstract BasePage reach();
	public abstract String getPageURL();
	
	public WebElement find(By locator) {
		return this.driver.findElement(locator);
	}
	public List<WebElement> findAll(By locator) {
		return this.driver.findElements(locator);
	}
	
	public void findAndClick(By locator) {
		WebElement el = this.driver.findElement(locator);
		el.click();
	}
}
