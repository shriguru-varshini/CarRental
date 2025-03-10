package MovieTicketBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookingConfirmation {

	     // ask username - preparedStatement
	
		// relating all three tables
		
		// Booking > USername, Booking Id
		// Movies -> Movie Name
		// Shows -> SHowtime, Seats booked ->
	
	public static void bookConfirmation() throws SQLException {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
	    }
		Scanner scanner = new Scanner(System.in);
		 
        // Step 1: Take user input
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        String fetchQuery = 
                "SELECT b.user_name, b.booking_id, m.title, s.show_time, b.seats_booked " +
                "FROM bookings b " +
                "JOIN shows s ON b.show_id = s.show_id " +
                "JOIN movies m ON s.movie_id = m.movie_id " +
                "WHERE b.user_name = ?;";
        
        try ( PreparedStatement pstmt = conn.prepareStatement(fetchQuery)) {

               pstmt.setString(1, username);
               ResultSet rs = pstmt.executeQuery();

               if (rs.next()) {
                   int bookingId = rs.getInt("booking_id");
                   String movieName = rs.getString("title");
                   String showtime = rs.getString("show_time");
                   int seatsBooked = rs.getInt("seats_booked");
                   
                   System.out.println("Booking Details :");
                   System.out.println("Username: " + username);
	                System.out.println("Booking ID: " + bookingId);
	                System.out.println("Movie Name: " + movieName);
	                System.out.println("Show Time: " + showtime);
	                System.out.println("Seats Booked: " + seatsBooked);
	                System.out.println("_______________________________");
	            }
               else {
	                System.out.println("Booking details not found.");
	            }
                   
           } 
        catch (SQLException e) {
               e.printStackTrace();
           }
	}
}
