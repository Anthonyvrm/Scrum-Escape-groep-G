package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() {
        // This table stores player save data such as status, player name, and progress.
        String createSaveTable = """
    CREATE TABLE IF NOT EXISTS Save (
        Status INTEGER NOT NULL,
        Name TEXT UNIQUE PRIMARY KEY NOT NULL,
        Voortgang INT NOT NULL
    );
    """;
        // Try to connect to the database and execute the table creation
        try (Connection conn = DatabaseConnection.connect()) {
            assert conn != null;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createSaveTable);
            }
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Trigger creation of the tables
    public static void main(String[] args) {
        createTables();
    }
}