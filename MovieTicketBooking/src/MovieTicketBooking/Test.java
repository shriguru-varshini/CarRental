package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;//3
        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                System.out.println("Database Connection Failed");
                return;
            }
            // Calling the stored procedure
            //cstmt = conn.prepareCall("{CALL GetMovieTitle(?, ?)}");
            //(2)cstmt = conn.prepareCall("{CALL GetMovieTitleAndGenre(?, ?,?)}");
            
            cstmt = conn.prepareCall("{CALL GetMovieDetailsByUsername(?)}");
            //(2)System.out.print("Enter your movie Id: ");
            //(2)int movieId = scanner.nextInt();
            //(2)cstmt.setInt(1, movieId);
            
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            cstmt.setString(1, username);
            
            //(1)cstmt.registerOutParameter(2, Types.VARCHAR);
            //(2)cstmt.registerOutParameter(2, Types.VARCHAR);
            //(2)cstmt.registerOutParameter(3, Types.VARCHAR);
            //(2)cstmt.execute();
            /*String title = cstmt.getString(2);
            String title = cstmt.getString(2);
            String genre = cstmt.getString(3);
            System.out.println("Movie Title: " + title);
            System.out.println("Movie Genre: " + genre);*/
            
            rs = cstmt.executeQuery();
            
            // Retrieve and print the result set
            while (rs.next()) {
                String name = rs.getString("user_name");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int seatsBooked = rs.getInt("seats_booked");
                Time showTime = rs.getTime("show_time");
                Date bookingDate = rs.getDate("booking_date");
                
                
                
                System.out.println("__________________________________");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {
            try {
                if (cstmt != null) 
                	cstmt.close();
                if (conn != null) 
                	conn.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
