package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsetMetaDataApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection conn = DatabaseConnection.getConnection();
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("Select * from shows")){
		
			
				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();
				System.out.println(colCount);
				
				for(int i=1;i<=colCount;i++) {
					System.out.println("Coloum :"+i);
					System.out.println("Coloum Name :"+rsmd.getColumnName(i));
					System.out.println("Coloum Lable :"+rsmd.getColumnLabel(i));
					System.out.println("Coloum Type :"+rsmd.getColumnTypeName(i));
					System.out.println("Coloum Type Class :"+rsmd.getColumnTypeName(i));
					System.out.println("Is Nullable :"+rsmd.isNullable(i));
					System.out.println("Is Auto Increament :"+rsmd.isAutoIncrement(i));
					System.out.println("Get Prescision :"+rsmd.getPrecision(i));
					System.out.println("Colum Display Size :"+rsmd.getColumnDisplaySize(i));
					System.out.println("Table Name :"+rsmd.getTableName(i));
					System.out.println("Schema Name :"+rsmd.getSchemaName(i));
					System.out.println("______________________________________");
					
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
}
}	
