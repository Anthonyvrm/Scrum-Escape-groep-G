package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() {
        String createSaveTable = """
    CREATE TABLE IF NOT EXISTS Save (
        Status INTEGER NOT NULL,
        Name TEXT UNIQUE PRIMARY KEY NOT NULL,
        Voortgang INT NOT NULL
    );
    """;

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createSaveTable);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Trigger creation of the tables
    public static void main(String[] args) {
        createTables();
    }
}