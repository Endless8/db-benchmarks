package application;

import application.database.connection.DatabaseConnection;
import application.database.finalization.FinalizeBenchmarks;
import application.database.initialization.InitializeBenchmarks;
import application.database.operations.PerformBenchmarks;
import application.printer.PrintResults;
import application.propertiesloader.PropertiesLoader;

import java.sql.*;
import java.util.*;

public class DBBenchmarks {

    private static final String INSERT_TYPE = "INSERT";
    private static final String SELECT_TYPE = "SELECT";

    public static void startDatabaseBenchmarkApp() {
        Properties properties = PropertiesLoader.getConfigurationProperties();
        Connection connection = DatabaseConnection.getDatabaseConnection(properties);
        InitializeBenchmarks.createBenchmarkTable(connection);
        List<Long> insertionTimes = PerformBenchmarks.collectInsertionTimes(connection, properties);
        PrintResults.printTimes(insertionTimes, INSERT_TYPE);
        List<Long> selectionTimes = PerformBenchmarks.collectSelectionTimes(properties, connection);
        PrintResults.printTimes(selectionTimes, SELECT_TYPE);
        FinalizeBenchmarks.dropBenchmarkTable(connection);
        DatabaseConnection.closeDatabaseConnection(connection);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER to exit.");
        scanner.nextLine();
    }
}
