package utils;

import org.testng.Reporter;

public class Logger {
	
	public static void log(String text) {
		Reporter.log("[LOG]: " + text);
		System.out.println("[LOG]: " + text);
	}
	public static void errorLog(String text) {
		Reporter.log("[ERROR]: " + text);
		System.err.println("[ERROR]: " + text);
	}
}
