package scripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Config;
import utils.EvidenceHelper;

public abstract class BaseTest {

	Properties config;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		this.config = Config.getBaseConfig();
		this.driver = this.getDriver(config.getProperty("browser"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		new EvidenceHelper(result,driver).processResults();
		
		if(this.driver != null) {
			this.driver.quit();			
		}
	}
	

	private WebDriver getDriver(String browser) {
		switch (browser) {
			case "chrome":
				return this.getChromeDriver();
			case "firefox":
				return this.getGeckoDriver();
			//	TODO agregar metodos safari, edge
			default:
				break;
		}
		return null;
	}

	private WebDriver getGeckoDriver() {
		FirefoxOptions options = new FirefoxOptions();
//		TODO agregar opciones / levantar de config
		
		return new FirefoxDriver(options);
	}

	private WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
//		TODO agregar opciones / levantar de config
		
		String chromedriverPath="chromedriver";
		if(System.getProperty("os.name").toLowerCase().contains("win")) {
			chromedriverPath ="chromedriver.exe";			
		}
		System.setProperty("webdriver.chrome.driver",chromedriverPath);
		
		return new ChromeDriver(options);
	}
}
