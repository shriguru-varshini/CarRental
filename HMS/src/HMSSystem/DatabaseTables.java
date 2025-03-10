package HMSSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTables {

	public static void CreateTables() {
		Connection conn = DatabaseConnection.getConnection();
		if (conn == null) {
			System.out.println("Database Connection Failed");
			return;
		}
		try {
			Statement smt = conn.createStatement();
			// used for general purpose accesss to database
			// excute sql staement at runtime

			String createPatientTable = "CREATE TABLE IF NOT EXISTS Patient("
					+ "patient_id INT AUTO_INCREMENT PRIMARY KEY, " + "first_name VARCHAR(50), "
					+ "last_name VARCHAR(50), " + "age INT NOT NULL, " + "gender VARCHAR(10), "
					+ "contact_number VARCHAR(15))";

			smt.executeUpdate(createPatientTable);
			System.out.println("Patient Table Created Successfully!");
			String createDoctorTable = "CREATE TABLE IF NOT EXISTS Doctor ("
					+ "doctor_id INT AUTO_INCREMENT PRIMARY KEY, " + "doctor_name VARCHAR(50), "
					+ "specialty VARCHAR(50), " + "contact_number VARCHAR(15))";
			smt.executeUpdate(createDoctorTable);
			System.out.println("Doctor Table Created Successfully!");

			String createAppointmentTable = "CREATE TABLE IF NOT EXISTS Appointment("
					+ "id INT AUTO_INCREMENT PRIMARY KEY, " + "patient_id INT NOT NULL, " + "doctor_id INT NOT NULL, "
					+ "appointment_date DATETIME NOT NULL, " + "reason VARCHAR(255) NOT NULL, "
					+ "FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)),"
					+ "FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id))";
			smt.executeUpdate(createAppointmentTable);
			System.out.println("Appointment Table Created Successfully!");

			String createStaffTable = "CREATE TABLE IF NOT EXISTS Staff (" + "staff_id INT AUTO_INCREMENT PRIMARY KEY, "
					+ "staff_name VARCHAR(50), " + "department VARCHAR(50), " + "contact_number VARCHAR(15))";
			smt.executeUpdate(createDoctorTable);
			System.out.println("Doctor Table Created Successfully!");

			smt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateTables();
	}

}
