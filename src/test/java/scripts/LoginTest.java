package scripts;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.BasePage;
import pages.LoginPage;
import utils.Logger;

public class LoginTest extends BaseTest{

	@Test
	public void loginCorrectoTest_1_1() {
		LoginPage loginPage = this.reachLoginPage();
		
		BasePage homePage = loginPage.login();
		
		String expectedURL = homePage.getPageURL();
		Logger.log("URL esperada: " + expectedURL);
		
		String actualURL = this.driver.getCurrentUrl();
		Logger.log("URL obtenida: " + actualURL);
		
		assertEquals(actualURL, expectedURL,"La URL de llegada no es la esperada luego del login");
	}

	@Test
	@Parameters({"wrongUsername","wrongPassword"})
	public void loginIncorrectoTest_1_2(@Optional("admin") String wrongUsername, @Optional("1234") String wrongPassword) {
		LoginPage loginPage = this.reachLoginPage();
		
		BasePage homePage = loginPage.login(wrongUsername,wrongPassword);
		
		String expectedURL = homePage.getPageURL();
		Logger.log("URL esperada: " + expectedURL);
		
		String actualURL = this.driver.getCurrentUrl();
		Logger.log("URL obtenida: " + actualURL);
		
		assertEquals(actualURL, loginPage.getPageURL(),"La URL de llegada no es la esperada luego del login");
				
		assertTrue(loginPage.hasLoginError(), "No se muestra el mensaje de login incorrecto en la UI");
		Logger.log(loginPage.getLoginMessage());
	}

	private LoginPage reachLoginPage() {
		LoginPage loginPage = new LoginPage(this.driver,this);
		loginPage.reach();
		
		return loginPage;
	}
	
}
