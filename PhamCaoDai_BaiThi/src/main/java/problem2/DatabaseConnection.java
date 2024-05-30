package problem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost/trainee";
    private static final String user = "root";
    private static final String password = "123456";

    public DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/trainee", "root", "123456");
        } catch (SQLException var1) {
            System.out.println("Connection failed");
            throw new RuntimeException(var1);
        }
    }

    public static void main(String[] args) {
        getConnection();
        System.out.printf("Done");
    }
}
