package Config;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;


public class ConfigReader {
	
    private static Properties properties;
  

    static {
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("C:\\Users\\anush\\eclipse-workspace\\nopCommerce\\src\\test\\java\\Config\\config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
