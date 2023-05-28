package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Config instance;
	private static String CONFIG_FILE_PATH = "config/config.properties";
	public Properties config = new Properties();

	private Config() {		
		try {
			FileInputStream configFile = new FileInputStream(CONFIG_FILE_PATH);
			config.load(configFile);
			configFile.close();
		} catch (Exception e) {
			System.out.println("Error al leer archivo de configuraciones");
		}
	}
	
	 public static Config getInstance() {
	        if (Config.instance == null) {
	        	Config.instance = new Config();
	        }

	        return Config.instance;
	    }

	public Properties getBaseConfig() {
		return this.config;
	}

}
