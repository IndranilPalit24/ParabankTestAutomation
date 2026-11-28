package ConfigManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    //File Name - Config.properties File and Properties file
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationManager.class
                .getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException(CONFIG_FILE + " not found on the classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read " + CONFIG_FILE, e);
        }
    }

    public static String getProperty(String key){
        String systemProperties = System.getProperty(key);
        return (systemProperties != null && !systemProperties.isEmpty()) ? systemProperties : properties.getProperty(key);
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static String getURL(){
        return getProperty("QAURL");
    }

    public static boolean getHeadless(){
        return Boolean.parseBoolean(getProperty("headless"));
    }



}
