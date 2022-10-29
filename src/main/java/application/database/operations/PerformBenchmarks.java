package application.database.operations;

import application.generator.RandomPersonGenerator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PerformBenchmarks {

    private static final String COMMIT_FREQUENCY_PROPERTY_NAME = "commit.frequency";
    private static final String INSERT_QUANTITY_PROPERTY_NAME = "insert.quantity";
    private static final String SELECT_QUANTITY_PROPERTY_NAME = "select.quantity";
    private static final String INSERT_QUERY = "INSERT INTO Persons VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM Persons WHERE ID = ?";

    public static List<Long> collectInsertionTimes(Connection connection, Properties properties) {
        List<Long> insertionTimes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            int insertQuantity = Integer.parseInt(properties.getProperty(INSERT_QUANTITY_PROPERTY_NAME));
            for (int i = 1; i <= insertQuantity; i++) {
                preparedStatement.setInt(1, i);
                setPreparedStatementsParameters(preparedStatement);
                Instant insertionTimeBegin = Instant.now();
                preparedStatement.executeUpdate();
                Instant insertionTimeEnd = Instant.now();
                insertionTimes.add(Duration.between(insertionTimeBegin, insertionTimeEnd).toMillis());
                int commitFrequency = Integer.parseInt(properties.getProperty(COMMIT_FREQUENCY_PROPERTY_NAME));
                if (i % commitFrequency == 0 || i == insertQuantity)
                    connection.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return insertionTimes;
    }

    public static List<Long> collectSelectionTimes(Properties properties, Connection connection) {
        List<Long> selectionTimes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            int selectQuantity = Integer.parseInt(properties.getProperty(SELECT_QUANTITY_PROPERTY_NAME));
            for (int i = 1; i <= selectQuantity; i++) {
                preparedStatement.setInt(1, i);
                Instant selectionTimeBegin = Instant.now();
                preparedStatement.executeQuery();
                Instant selectionTimeEnd = Instant.now();
                selectionTimes.add(Duration.between(selectionTimeBegin, selectionTimeEnd).toMillis());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selectionTimes;
    }

    private static void setPreparedStatementsParameters(PreparedStatement preparedStatement) {
        RandomPersonGenerator randomPersonGenerator = new RandomPersonGenerator();
        try {
            preparedStatement.setString(2, randomPersonGenerator.getFirstName());
            preparedStatement.setString(3, randomPersonGenerator.getLastName());
            preparedStatement.setInt(4, randomPersonGenerator.getAge());
            preparedStatement.setDate(5, Date.valueOf(randomPersonGenerator.getBirthDate()));
            preparedStatement.setString(6, randomPersonGenerator.getPersonalUUID());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
