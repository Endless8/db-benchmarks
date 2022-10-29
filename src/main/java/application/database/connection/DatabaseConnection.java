package application.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String DATABASE_URL_PROPERTY_NAME = "database.url";
    private static final String DATABASE_USER_PROPERTY_NAME = "database.user";
    private static final String DATABASE_PASSWORD_PROPERTY_NAME = "database.password";

    public static Connection getDatabaseConnection(Properties properties) {
        String url = properties.getProperty(DATABASE_URL_PROPERTY_NAME);
        String user = properties.getProperty(DATABASE_USER_PROPERTY_NAME);
        String password = properties.getProperty(DATABASE_PASSWORD_PROPERTY_NAME);
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
