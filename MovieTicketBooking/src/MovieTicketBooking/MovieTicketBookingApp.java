package MovieTicketBooking;

import java.sql.SQLException;
import java.util.Scanner;

public class MovieTicketBookingApp{
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Movie Ticket Booking App");
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
 
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
 
            switch (choice) {
                case 1:
                    UserRegistration.registerUser();
                    break;
                case 2:
                    boolean isAdmin = UserLogin.loginUser();
                    if (isAdmin) {
                        showAdminMenu();
                    } else {
                        showUserMenu();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
	
	private static void showAdminMenu() throws SQLException {
		Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Movies Running");
        System.out.println("2 - TicketBooking ");
        System.out.println("3 - Booking Confirmation ");
        System.out.println("4 - Ticket Cancellation");
        System.out.println("5 - Add New Show");
        System.out.println("6 - Logout");
        System.out.println("Enter your choice");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
            	ShowAvailableMovies.displayMovies();
                break;
            case 2:
            	TicketBooking.bookTicket();
            	break;
            case 3:
            	BookingConfirmation.bookConfirmation();
            	break;
            case 4:
            	TicketCancellation.ticketCancel();
            	break;
            case 5:
                AddShows.addNewShow();
                break;
            case 6:
                System.out.println("Logging out...");
                return; 	
            default:
                System.out.println("Invalid choice");
                break;
        }
}

private static void showUserMenu() throws SQLException {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("User Menu:");
        System.out.println("1 - View Movies");
        System.out.println("2 - Book Ticket");
        System.out.println("3 - Confirm Booking");
        System.out.println("4 - Cancel Ticket");
        System.out.println("5 - Logout");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ShowAvailableMovies.displayMovies();
                break;
            case 2:
                TicketBooking.bookTicket();
                break;
            case 3:
                BookingConfirmation.bookConfirmation();
                break;
            case 4:
            	TicketCancellation.ticketCancel();
                break;
            case 5:
                System.out.println("Logging out...");
                return;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
}

	

