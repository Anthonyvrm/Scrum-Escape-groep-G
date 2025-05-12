import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class saveQuery {
    // Method to retrieve all chats from the database
    public static ArrayList<Chat> getAllChats() {
        // SQL query to select all records from the chat
        String sql = "SELECT * FROM Chat";
        ArrayList<Chat> chats = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String chatName = rs.getString("chatName");
                Chat chat = new Chat(chatName);
                chats.add(chat);
            }

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return chats;
    }