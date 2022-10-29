package application.database.finalization;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FinalizeBenchmarks {
    private static final String dropTableQuery = "DROP TABLE Persons";

    public static void dropBenchmarkTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(dropTableQuery);
            connection.commit();
            System.out.println("Database benchmark table successfully dropped.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
