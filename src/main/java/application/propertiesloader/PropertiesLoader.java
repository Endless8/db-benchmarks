package application.propertiesloader;

import com.github.javafaker.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final String configurationPropertiesFilename = "configuration.properties";

    public static Properties getConfigurationProperties() {
        Properties properties = new Properties();
        ClassLoader loader = App.class.getClassLoader();
        try (InputStream stream = loader.getResourceAsStream(configurationPropertiesFilename)) {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
