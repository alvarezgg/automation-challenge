package scripts;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest{
	
	@Test
	public void agregarProductoTestDesdeInventario_2_3() {
		InventoryPage inventoryPage = this.reachInventoryPage();
		
		String product = inventoryPage.addRandomProductToCart();
		
		ShoppingCartPage shoppingCartPage = inventoryPage.reachShoppingCart();
		
		List<String> addedProducts = shoppingCartPage.getAddedProductTitles();
		
		assertTrue(addedProducts.contains(product), "El producto " +product+ " no se encontro en la lista del carrito");
	}

	private InventoryPage reachInventoryPage() {
		LoginPage loginPage = (LoginPage) new LoginPage(this.driver,this).reach();
		loginPage.login();
		return new InventoryPage(this.driver, this);
	}

}