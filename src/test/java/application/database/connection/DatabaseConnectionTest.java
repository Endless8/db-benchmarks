package application.database.connection;

import application.propertiesloader.PropertiesLoader;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void testDatabaseConnection() {
        Properties properties = new Properties();
        properties.setProperty("database.url", "jdbc:postgresql://lucky.db.elephantsql.com/");
        properties.setProperty("database.user", "zlasbqxn");
        properties.setProperty("database.password", "ubfYnMT5BFI3V0MnjdPhlB4dBsyrILIv");
        Connection connection = DatabaseConnection.getDatabaseConnection(properties);
        boolean isConnectedToDatabase = false;
        try {
            isConnectedToDatabase = connection.isValid(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertTrue(isConnectedToDatabase);
    }

}