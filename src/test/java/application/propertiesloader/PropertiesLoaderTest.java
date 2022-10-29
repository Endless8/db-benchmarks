package application.propertiesloader;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesLoaderTest {

    @Test
    void getConfigurationProperties() {
        Properties properties = PropertiesLoader.getConfigurationProperties();
        boolean arePropertiesLoaded = properties.propertyNames().hasMoreElements();
        assertTrue(arePropertiesLoaded);
    }

}