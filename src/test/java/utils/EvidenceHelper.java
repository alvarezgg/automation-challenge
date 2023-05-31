package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class EvidenceHelper {
	
	ITestResult result;
	WebDriver driver;
	
	public EvidenceHelper(ITestResult result, WebDriver driver) {
		this.result = result;
		this.driver = driver;
	}

	public void getScreenshot() {
//		TODO en base al resultado, sacar captura de pantalla
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				String destFile = Config.getBaseConfig("screenshot_path")+"FAILED_"+result.getName()+"_"+DateHelper.getFechaActualDateTime();
				FileUtils.copyFile(screenshotFile, new File(destFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void processResults() {
		if(result.getStatus() == ITestResult.FAILURE){
			this.getScreenshot();
		}		
	}
}
