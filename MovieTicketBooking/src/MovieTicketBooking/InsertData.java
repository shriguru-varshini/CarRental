package MovieTicketBooking;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class InsertData {
	
	public static void insertMovies() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
		String insertMovieSQL = "Insert into Movies (title,genre,duration)Values(?,?,?);";
		
		try(PreparedStatement psmt = conn.prepareStatement(insertMovieSQL)) {
			
			//movie1
			psmt.setString(1,"Fighter");
			psmt.setString(2,"Action");
			psmt.setInt(3,150);
			psmt.executeUpdate();
			
			//movie2
			psmt.setString(1,"Lucky Basker");
			psmt.setString(2,"Suspense");
			psmt.setInt(3,120);
			psmt.executeUpdate();
			
			//movie3
			psmt.setString(1,"It ends with us");
			psmt.setString(2,"Romance");
			psmt.setInt(3,180);
			psmt.executeUpdate();
			
			System.out.println("Movies data inserted successfully");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//insert shows
	
	public static void insertShows() {
		
		Connection conn = DatabaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
		String insertShowsSQL ="Insert into Shows (movie_id,show_time,available_seats)Values(?,?,?)";
		

		try(PreparedStatement psmt = conn.prepareStatement(insertShowsSQL)) {
			 //one show
			psmt.setInt(1, 1);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,15, 18,30)));
			psmt.setInt(3,100);
			psmt.executeUpdate();
			
			//second show
			psmt.setInt(1, 2);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,15, 15,30)));
			psmt.setInt(3,120);
			psmt.executeUpdate();
			
			//third show
			psmt.setInt(1, 3);
			psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025,2,14, 11,00)));
			psmt.setInt(3,90);
			psmt.executeUpdate();
			
			System.out.println("Shows data inserted successfully");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
}
	public static void main(String[] args) {
		insertMovies();
		insertShows();
		
	}
}	



