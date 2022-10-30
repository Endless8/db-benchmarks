package application.propertiesloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final String CONFIGURATION_PROPERTIES_FILENAME = "configuration.properties";

    public static Properties getConfigurationProperties() {
        Properties properties = new Properties();
        ClassLoader loader = PropertiesLoader.class.getClassLoader();
        try (InputStream stream = loader.getResourceAsStream(CONFIGURATION_PROPERTIES_FILENAME)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
