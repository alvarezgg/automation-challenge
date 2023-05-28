package scripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import utils.Config;

public class BaseTest {

	Properties config;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		this.config = Config.getInstance().getBaseConfig();
		this.driver = this.getDriver(config.getProperty("browser"));
	}

	private WebDriver getDriver(String browser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
