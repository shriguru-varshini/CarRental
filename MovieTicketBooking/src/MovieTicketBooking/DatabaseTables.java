package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {
	
	public static void CreateTables() {
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			//used for general purpose accesss to database
			//excute sql staement at runtime
			
			String createMoviesTable = "Create Table if not EXISTS Movies("
					                     +"movie_id INT Auto_increment Primary Key,"
					                     +"title varchar(60) not null,"
					                     +"genre varchar(20),"
					                     +"duration int not null)";
			smt.executeUpdate(createMoviesTable);
			
			System.out.println("Movies Table Created Successfully!");
			//
			String createShowTable = "CREATE TABLE IF NOT EXISTS Shows("
			           + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
			           + "movie_id INT, "
			           + "show_time DATETIME NOT NULL, "
			           + "available_seats INT NOT NULL, "
			           + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id))";

			smt.executeUpdate(createShowTable);
			System.out.println("Shows Table Created Successfully!");
			String createBookingTable = "CREATE TABLE IF NOT EXISTS Bookings ("
                    + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "user_name VARCHAR(50) NOT NULL, "
                    + "show_id INT NOT NULL, "
                    + "seats_booked INT NOT NULL, "
                    + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (show_id) REFERENCES Shows(show_id))";
			smt.executeUpdate(createBookingTable);
			System.out.println("Booking Table Created Successfully!");
			
			String createUsersTable = "CREATE TABLE IF NOT EXISTS Users ("
	                 + "userid INT AUTO_INCREMENT PRIMARY KEY, "
	                 + "username VARCHAR(255) NOT NULL, "
	                 + "pwd VARCHAR(255) NOT NULL, "
	                 + "admin BOOLEAN NOT NULL)";
	         smt.executeUpdate(createUsersTable);
	         System.out.println("Users Table Created Successfully!");
			
			smt.close();
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CreateTables();
	}

}
