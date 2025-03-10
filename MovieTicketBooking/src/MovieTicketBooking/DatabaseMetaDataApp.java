package MovieTicketBooking;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMetaDataApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection conn = DatabaseConnection.getConnection()){
				
			DatabaseMetaData dbmd = conn.getMetaData();
			
		    //fetch db info
		    System.out.println("Database Product Name :"+dbmd.getDatabaseProductName());
		    System.out.println("Database Product Version :"+dbmd.getDatabaseProductVersion());
		    System.out.println("JDBC Driver Name :"+dbmd.getDriverName());
		    System.out.println("JDBC Driver Version :"+dbmd.getDriverVersion());
		    System.out.println("Database URL :"+dbmd.getURL());
		    System.out.println("DB User Name :"+dbmd.getUserName());
		    
		    
		    //retrive tables in db
		    
		    ResultSet rs = dbmd.getTables("moviebookingsystem", null, "%", new String[] {"Table"});
		    while(rs.next()) {
		    	System.out.println(rs.getString("TABLE_NAME"));
		    	
		    }
		    // shows ->col
		    
		    ResultSet rs1 = dbmd.getColumns(null,null,"shows","%");
		    while(rs1.next()) {
		    	System.out.println(rs1.getString("COLUMN_NAME"));
		    	System.out.println(rs1.getString("TYPE_NAME"));
		    	
		    }
		    //dbmd.getPrimaryKeys(null, null, null);
		    ResultSet rs2 = dbmd.getPrimaryKeys("moviebookingsystem", null, "shows");
            while (rs2.next()) {
                System.out.println("Primary Key Column: " + rs2.getString("COLUMN_NAME"));
                System.out.println("______________________________");
            }
				
            System.out.println("Supports Transactions: " + dbmd.supportsTransactions()); 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
