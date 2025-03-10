package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
 
public class TicketBooking {
 
    public static void bookTicket() throws SQLException {
    	Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
        Scanner scanner = new Scanner(System.in);
 
        // Step 1: Take user input
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
 
        // Step 2: Show available movies
        ShowAvailableMovies.displayMovies();
 
        // Step 3: Ask user to choose show_id
        System.out.print("Enter the show_id you want to book: ");
        int showId = scanner.nextInt();
 
        // Step 4: Check available seats
        String checkSeatsQuery = "SELECT available_seats FROM shows WHERE show_id = ?;";
        int availableSeats = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(checkSeatsQuery)) {
            pstmt.setInt(1, showId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                availableSeats = rs.getInt("available_seats");
            } else {
                System.out.println("Show not found.");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
 
        // Step 5: Ask user for number of seats
        System.out.print("Enter the number of seats you want to book: ");
        int numberOfSeats = scanner.nextInt();
 
        // Check if enough seats are available
        if (availableSeats >= numberOfSeats) {
            // Update the booking table
            String bookTicketQuery = "INSERT INTO bookings (user_name, show_id, seats_booked) VALUES (?, ?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(bookTicketQuery)) {
                pstmt.setString(1, username);
                pstmt.setInt(2, showId);
                pstmt.setInt(3, numberOfSeats);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
 
            // Update the available seats in shows table
            String updateSeatsQuery = "UPDATE shows SET available_seats = available_seats - ? WHERE show_id = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(updateSeatsQuery)) {
                pstmt.setInt(1, numberOfSeats);
                pstmt.setInt(2, showId);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Ticket booked successfully!");
                } else {
                    System.out.println("Failed to update available seats.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } 
        else {
            // If seats not available
            System.out.println("Not enough seats available.");
        }
    }

}