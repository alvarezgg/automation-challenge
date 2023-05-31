package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scripts.BaseTest;


public class ShoppingCartPage extends BasePage {

	private final String URL = "https://www.saucedemo.com/inventory.html";
	
	public ShoppingCartPage(WebDriver driver, BaseTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	private By addedProductTitles = By.xpath("//*[contains(@id,'cart_contents_container')]//*[contains(@id,'item')]");
	
	@Override
	public BasePage reach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageURL() {
		return this.URL;
	}

	public List<String> getAddedProductTitles() {
		List<String> products = new ArrayList<String>();
		
		List<WebElement> productTitleList = this.findAll(addedProductTitles);
		
		for (WebElement productTitle : productTitleList) {
			products.add(productTitle.getText());
		}
		
		return products;
	}

}
