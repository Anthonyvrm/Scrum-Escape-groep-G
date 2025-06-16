package database;

import classes.Player;
import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class saveQuery {
    // Method to retrieve all chats from the database
    public static ArrayList<Player> getAllPlayers() {
        // SQL query to select all records from the chat
        String sql = "SELECT * FROM Save";
        ArrayList<Player> players = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            // Go through every record.
            while (rs.next()) {
                Player player = new Player();
                player.setName(rs.getString("name"));
                player.setStatus(rs.getInt("status"));
                player.setVoortgang(rs.getInt("voortgang"));
                players.add(player);

            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return players;
    }
    public static Player getPlayerSave(String playerName) {
        String sql = "SELECT * FROM Save WHERE name = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, playerName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Player player = new Player();
                    player.setName(rs.getString("name"));
                    player.setStatus(rs.getInt("status"));
                    player.setVoortgang(rs.getInt("voortgang"));
                    return player;
                }
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }
}


