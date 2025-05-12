import classes.Player;

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
            while (rs.next()) {

                Player player = new Player();
                player.setName(rs.getString("name"));
                player.setStatus(rs.getInt("status"));
                player.setVoortgang(rs.getInt("voortgang"));
            }

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return players;
    }