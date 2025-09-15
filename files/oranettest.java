import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OraclePerformanceTester {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("Usage: java OraclePerformanceTester <username> <password> <tnsname> <delay> <tests>");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];
        String tnsname = args[2];
        int delay = Integer.parseInt(args[3]);
        int tests = Integer.parseInt(args[4]);

        String url = "jdbc:oracle:thin:@" + tnsname;

        List<Long> executionTimes = new ArrayList<>();
        long totalExecutionTime = 0;

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection to Oracle successful! 🚀");

            for (int i = 0; i < tests; i++) {
                long startTime = System.currentTimeMillis();
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery("SELECT 1 FROM DUAL")) {
                    if (resultSet.next()) {
                        // Query executed successfully
                    }
                }
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                executionTimes.add(elapsedTime);
                totalExecutionTime += elapsedTime;

                System.out.printf("Test %d: Query executed in %d ms.\n", (i + 1), elapsedTime);

                if (i < tests - 1) {
                    System.out.printf("Sleeping for %d seconds... 😴\n", delay);
                    try {
                        Thread.sleep(delay * 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            // Calculate and report statistics
            long minTime = Long.MAX_VALUE;
            long maxTime = Long.MIN_VALUE;

            for (long time : executionTimes) {
                if (time < minTime) {
                    minTime = time;
                }
                if (time > maxTime) {
                    maxTime = time;
                }
            }

            double avgTime = (double) totalExecutionTime / tests;

            System.out.println("\n--- Performance Report ---");
            System.out.printf("Total tests run: %d\n", tests);
            System.out.printf("Average test time: %.2f ms\n", avgTime);
            System.out.printf("Minimum test time: %d ms\n", minTime);
            System.out.printf("Maximum test time: %d ms\n", maxTime);

        } catch (SQLException e) {
            System.err.println("Database connection failed! ❌");
            e.printStackTrace();
        }
    }
}
