package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Config instance;
	private static final String CONFIG_FILE_PATH = "config/config.properties";
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

	public static Properties getBaseConfig() {
		return getInstance().config;
	}
	public static String getBaseConfig(String property) {
		getInstance();
		return Config.getBaseConfig().getProperty(property);
	}

}
