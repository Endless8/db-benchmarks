package application.database.initialization;

import com.github.javafaker.App;
import com.ibatis.common.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class InitializeBenchmarks {

    private static final String CREATE_BENCHMARK_TABLE_SCRIPT_FILENAME = "create-benchmark-table.sql";

    public static void createBenchmarkTable(Connection connection) {
        ScriptRunner runner = new ScriptRunner(connection, false, false);
        ClassLoader loader = App.class.getClassLoader();
        try {
            runner.runScript(new BufferedReader(new InputStreamReader(Objects.requireNonNull(loader.getResourceAsStream(CREATE_BENCHMARK_TABLE_SCRIPT_FILENAME)))));
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
