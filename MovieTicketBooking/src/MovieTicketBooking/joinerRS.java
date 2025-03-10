package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

/*public class joinerRS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DatabaseConnection.getConnection();
	    try {
	         CachedRowSet ct1=RowSetProvider.newFactory().createCachedRowSet();
			 ct1.setUrl("jdbc:mysql://localhost:3306/ moviebookingsystem");
			 ct1.setUsername("root");
			 ct1.setPassword("Genpact@123456789");
		     ct1.setCommand("select * from movies");
			 ct1.execute();
			 CachedRowSet ct2=RowSetProvider.newFactory().createCachedRowSet();
       	     ct2.setCommand("select * from shows");
			 ct2.execute(conn);

			 conn.close();
			 JoinRowSet jrs=RowSetProvider.newFactory().createJoinRowSet();
			 ct1.setMatchColumn("movie_id");
			 ct2.setMatchColumn("movie_id");
			 jrs.addRowSet(ct1);
			 jrs.addRowSet(ct2);
			 while(jrs.next())
			 {
				 System.out.println("ID : "+jrs.getInt("movie_id")+" Title : "+jrs.getString("title"));
			 }
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}*/

public class joinerRS {
	public static void main(String[] args) {
	try {        
    Connection conn = DatabaseConnection.getConnection();
    if (conn == null) {
        System.out.println("Database Connection Failed");
        return;
    }
    CachedRowSet movies = RowSetProvider.newFactory().createCachedRowSet();
    movies.setCommand("SELECT * FROM movies");
    movies.execute(conn);

    CachedRowSet shows = RowSetProvider.newFactory().createCachedRowSet();
    shows.setCommand("SELECT * FROM shows");
    shows.execute(conn);

    conn.close();

    JoinRowSet joinrs = RowSetProvider.newFactory().createJoinRowSet();
    movies.setMatchColumn("movie_id");
    shows.setMatchColumn("movie_id");

    joinrs.addRowSet(movies);
    joinrs.addRowSet(shows);

    System.out.println("Movies and Show Data:");
    while (joinrs.next()) {
        int movieId = joinrs.getInt("movie_id");
        String movieTitle = joinrs.getString("title");
        String genre = joinrs.getString("genre");
        String showTime = joinrs.getString("show_time");
        int seatsAvailable = joinrs.getInt("available_seats");
        System.out.println("Movie ID: " + movieId);
        System.out.println("Title: " + movieTitle);
        System.out.println("Genre: " + genre);
        System.out.println("Show Time: " + showTime);
        System.out.println("Seats Available: " + seatsAvailable);
        System.out.println();
    }

    movies.close();
    shows.close();
    joinrs.close();

	} 
    catch (SQLException e) {
    e.printStackTrace();
}
}
}
