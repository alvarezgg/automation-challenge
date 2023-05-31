package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import scripts.BaseTest;
import utils.Logger;

public class InventoryPage extends BasePage{

	private final String URL = "https://www.saucedemo.com/inventory.html";
	
	public InventoryPage(WebDriver driver, BaseTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	private By products = By.xpath("//*[contains(@class,'list')]/*[contains(@class,'inventory_item')]");
	private By cartButton = By.xpath("//*[contains(@class,'shopping_cart_link')]");

	@Override
	public BasePage reach() {
		this.driver.get(this.getPageURL());
		return new InventoryPage(this.driver, this.test);
	}

	@Override
	public String getPageURL() {
		return this.URL;
	}

	public String addRandomProductToCart() {
		Random rnd = new Random();
		
		List<WebElement> productList = this.findAll(products);
		int randomNumber = rnd.nextInt(productList.size());
		
		WebElement product = productList.get(randomNumber);
		String productTitle = product.findElement(By.xpath(".//*[contains(@class,'item_name')]")).getText();
		product.findElement(By.xpath(".//*[contains(@data-test,'add-to-cart')]")).click();
		return productTitle ;
	}

	public ShoppingCartPage reachShoppingCart() {
		Logger.log("Clickear boton Carrito");
		this.findAndClick(cartButton);
		return new ShoppingCartPage(this.driver, this.test);
	}

}
