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

    private final String insertType = "INSERT";
    private final String selectType = "SELECT";

    public DBBenchmarks() {
        startDatabaseBenchmarkApp();
    }

    public void startDatabaseBenchmarkApp() {
        Properties properties = PropertiesLoader.getConfigurationProperties();
        Connection connection = DatabaseConnection.getDatabaseConnection(properties);
        InitializeBenchmarks.createBenchmarkTable(connection);
        List<Long> insertionTimes = PerformBenchmarks.collectInsertionTimes(connection, properties);
        PrintResults.printTimes(insertionTimes, insertType);
        List<Long> selectionTimes = PerformBenchmarks.collectSelectionTimes(properties, connection);
        PrintResults.printTimes(selectionTimes, selectType);
        FinalizeBenchmarks.dropBenchmarkTable(connection);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER to exit.");
        scanner.nextLine();
    }
}
