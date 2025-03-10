package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StoredProcCallable {
	
    public static void storedProcedure(){
	        Connection conn = DatabaseConnection.getConnection();
	        if (conn == null) {
	            System.out.println("Database Connection Failed");
	            return;
	        }
	       
	        try {
	        /*String procedure = "CREATE PROCEDURE GetMovieTitle(IN movieId INT, OUT mtitle VARCHAR(25))"
	        		+ "BEGIN"
	        		+ "   SELECT title into mtitle FROM movies"
	        		+ " WHERE movie_id = movieId ; "
	        		+ "END;";*/
	        /*String procedure = "CREATE PROCEDURE GetMovieTitleAndGenre(IN movieId INT, OUT movietitle VARCHAR(255), OUT movieGenre VARCHAR(255)) "
	        		  + "BEGIN "
                      + "SELECT title, genre INTO movietitle, movieGenre FROM movies "
                      + "WHERE movie_id = movieId; "
                      + "END;";*/
	        
	        String procedure = "CREATE PROCEDURE GetMovieDetailsByUsername(IN username VARCHAR(255))"
                    + "BEGIN "
                    + "select * from movies join shows on movies.movie_id = shows.movie_id join bookings on bookings.show_id = shows.show_id where user_name = username;"
                    + "END;"; 
	        Statement smt = conn.createStatement();
	        smt.execute(procedure);
	        //System.out.println("Stored procedure created");
	        System.out.println("View Booking Stored procedure created");
	        }
	        catch(SQLException e) {
	        	e.printStackTrace();
	        }
	      
}
    public static void main(String[] args){
    	storedProcedure();
    	
    }
}    
