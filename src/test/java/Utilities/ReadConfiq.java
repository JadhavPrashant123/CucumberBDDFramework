package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiq {

	Properties properties;
	String path = "confiq.properties";

	// Constructor
	public ReadConfiq() throws IOException {

		properties = new Properties();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
	}

	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null)
			return value;
		else
			throw new RuntimeException("Browser not specified in confiq file");
	}

}
