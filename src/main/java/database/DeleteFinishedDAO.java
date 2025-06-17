package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFinishedDAO {
    public static void removeFinishedPlayer() {
        String sql = "DELETE FROM Save WHERE voortgang = 6";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Database update mislukt: " + e.getMessage());
        }
    }
}
