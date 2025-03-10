package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			/*Connection conn = DatabaseConnection.getConnection();
			
			//crt a jdbc row set
			
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			//CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/ moviebookingsystem");
			rowSet.setUsername("root");
			rowSet.setPassword("Genpact@123456789");
			//set sql query - setcommand
			rowSet.setCommand("select * from movies");
			
			//execute the query
			rowSet.execute();
			
			//iterate over the result
			while(rowSet.next()) {
				System.out.println("ID :"+rowSet.getInt("movie_id"));
			}
			while(rowSet.previous()) {
				System.out.println("ID :"+rowSet.getInt("movie_id"));
			}
			//close
			rowSet.close();*/
			
			//_______________________________________________
			
			Connection conn = DatabaseConnection.getConnection();
			CachedRowSet ct = RowSetProvider.newFactory().createCachedRowSet();
			ct.setCommand("select * from movies");
			ct.execute(conn);
			
			while(ct.next()) {
				if (ct.getInt("movie_id")==1) {
					ct.updateString("title","InterSeller");
					ct.updateRow();
				}
			}
			
			//establish conn
			conn.setAutoCommit(false);
			ct.acceptChanges(conn);
		
			conn.close();
			
			while(ct.next()){
				System.out.println("ID :"+ct.getInt("movie_id"));
				System.out.println("ID :"+ct.getString("title"));
			}
			ct.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
