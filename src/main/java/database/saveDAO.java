package database;

import classes.Player;
import database.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class saveDAO {
    public static void insertSave(Player player) {
        // SQL query to insert a new userstory into the Userstory table
        String sql = "INSERT OR REPLACE INTO Save (name, status, voortgang) VALUES(?,?,?)";

        // Set parameters for the INSERT statement using the Userstory object's properties
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getStatus());
            pstmt.setInt(3, player.getVoortgang());

            pstmt.executeUpdate();
            System.out.println("dao succes.");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
}