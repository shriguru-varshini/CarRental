package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StoredProcedure2 {
	public static void main(String[] args) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database Connection Failed");
            return;
        }

        String procedure = "CREATE PROCEDURE GetAllBookings(IN username VARCHAR(52))"
                + "BEGIN"
                + " SELECT user_name, show_id, seats_booked FROM Bookings WHERE user_name = username;"
                + "END;";
        Statement stmt = conn.createStatement();
        stmt.execute(procedure);
        System.out.println("Stored procedure created successfully.");

        try {
            CallableStatement csmt = conn.prepareCall("{call GetAllBookings(?)}");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your username: ");
            String username = scanner.next();
            csmt.setString(1, username);

            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                int show_id = rs.getInt("show_id");
                int seats_booked = rs.getInt("seats_booked");

                System.out.println("Username: " + user_name);
                System.out.println("Show ID: " + show_id);
                System.out.println("Seats Booked: " + seats_booked);
                System.out.println("----------");
            }

            rs.close();
            csmt.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
 

