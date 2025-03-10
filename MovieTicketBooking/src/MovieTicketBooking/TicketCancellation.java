package MovieTicketBooking;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;
 
public class TicketCancellation{
	
    public static void ticketCancel() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
        Scanner scanner = new Scanner(System.in);
 
        // Taking input from user
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your booking Id: ");
        int bookingId = scanner.nextInt();
        String cancellationQuery = "SELECT booking_id, show_id, seats_booked FROM bookings WHERE user_name = ? AND booking_id = ?;";
        //String cancellationQuery = "SELECT booking_id, show_id, seats_booked FROM bookings WHERE user_name = ?;";
        int showId = 0;
        int seatsBooked = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(cancellationQuery)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, bookingId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                showId = rs.getInt("show_id");
                seatsBooked = rs.getInt("seats_booked");
            } 
            else {
                System.out.println("Booking not found.");
                return;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }

 
        // update seats in shows table
        String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats + ? WHERE show_id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSeatsQuery)) {
            pstmt.setInt(1, seatsBooked);
            pstmt.setInt(2, showId);
            int rowsUpdated = pstmt.executeUpdate();
 
            if (rowsUpdated > 0) {
                System.out.println("Available seats updated successfully!");
            } else {
                System.out.println("Failed to update available seats.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
 
        //  delete movie booking from bookings table
        String deleteBookingQuery = "DELETE FROM bookings WHERE booking_id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteBookingQuery)) {
            pstmt.setInt(1, bookingId);
            int rowsDeleted = pstmt.executeUpdate();
 
            if (rowsDeleted > 0) {
                System.out.println("Booking cancelled successfully!");
            } else {
                System.out.println("Failed to cancel the booking.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
