import java.util.ArrayList;
import java.util.Scanner;

public class BookingMenu {
    private Scanner scanner;
    private ArrayList<Flight> allFlights;
    private ArrayList<Flight> availableFlights;
    private ArrayList<Passenger> passengers;
    private ArrayList<Flight> cancelledFlights;

    public BookingMenu(){
        this.scanner = new Scanner(System.in);
        this.allFlights = new ArrayList<>();
        this.availableFlights = new ArrayList <>();
        this.passengers = new ArrayList<>();
        this.cancelledFlights = new ArrayList<>();
    }

    public ArrayList<Flight> getAvailableFlights() {
        return availableFlights;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Flight> getCancelledFlights() {
        return cancelledFlights;
    }

    public void printAvailableFlights(){
        System.out.println(availableFlights.toString());
    }

    public void start(){
        System.out.println("Welcome!");
        System.out.println(" ");
        System.out.println("What would you like to do?");
        System.out.println("1. Add a new flight");
        System.out.println("2. Display available flights");
        System.out.println("3. Add a new passenger");
        System.out.println("4. Book a passenger on to a flight");
        System.out.println("5. Cancel a flight");
        System.out.println("6. Admin access");
        System.out.println("7. Close app");
        System.out.println("Please enter a number between 1 and 7 to pick an option:");
        String option = scanner.nextLine();

        switch(option) {
            case "1":
                addFlight();
                break;
            case "2":
                displayAvailableFlights();
                break;
            case "3":
                addPassenger();
                break;
            case "4":
                bookOnToAFlight();
                break;
            case "5":
                cancelFlight();
                break;
            case "6":
                adminAccess();
                break;
            case "7":
                System.out.println("Thanks for using our app!");
        }

    }
    public void addFlight(){
        System.out.println(" ");
        System.out.println("Flight Menu");
        System.out.println("Please enter a destination:");

        String dest = scanner.nextLine();
        int flightId = this.allFlights.size() + 1;
        Flight flight = new Flight(dest, flightId);
        this.availableFlights.add(flight);
        this.allFlights.add(flight);

        System.out.println("Flight added!");
        System.out.println(" ");
        start();
    }
    public void addPassenger(){
        System.out.println(" ");
        System.out.println("Passenger Menu");
        System.out.println("Please enter the passenger's name:");
        String name = scanner.nextLine();
        System.out.println("Please enter the passenger's email:");
        String email = scanner.nextLine();
        int passengerId = this.passengers.size() + 1;
        Passenger passenger = new Passenger(name,email,passengerId);
        this.passengers.add(passenger);

        System.out.println("Passenger added!");
        System.out.println(" ");
        start();
    }

    public void displayAvailableFlights(){
        printAvailableFlights();
        start();
    }

    public void bookOnToAFlight(){
        System.out.println(" ");
        System.out.println("Booking Menu");
        System.out.println("Please enter the passenger's ID:");
        String passId = scanner.nextLine();
        int passengerIndex = Integer.parseInt(passId) - 1;
        Passenger selectedPassenger = passengers.get(passengerIndex);

        System.out.println("Please enter the flight's ID:");
        String flightId = scanner.nextLine();
        int flightIndex = Integer.parseInt(flightId) - 1;
        Flight selectedFlight = allFlights.get(flightIndex);

        selectedFlight.addBookedPassenger(selectedPassenger);
        start();
    }
    public void cancelFlight(){
        System.out.println(" ");
        System.out.println("Cancellation Menu");
        System.out.println("Please enter the flight's ID:");
        String flightId = scanner.nextLine();
        int flightIndex = Integer.parseInt(flightId) - 1;
        Flight selectedFlight = allFlights.get(flightIndex);

        this.availableFlights.remove(selectedFlight);
        this.cancelledFlights.add(selectedFlight);

        start();
    }

    public void adminAccess(){
        System.out.println("1. Display all flights");
        System.out.println("2. Display cancelled flights");
        System.out.println("3. Display a flight's booked passenger list");
        System.out.println("4. Display list of all passengers");
        System.out.println("5. Return to main menu");
        System.out.println("Please enter a number between 1 and 5 to pick an option:");
        String tests = scanner.nextLine();

        switch (tests){
            case "1":
                System.out.println(allFlights.toString());
                adminAccess();
                break;
            case "2":
                System.out.println(cancelledFlights.toString());
                adminAccess();
                break;
            case "3":
                System.out.println("Please enter the flight's ID:");
                String flightId = scanner.nextLine();
                int flightIndex = Integer.parseInt(flightId) - 1;
                Flight selectedFlight = allFlights.get(flightIndex);
                selectedFlight.printBookedPassengers();
                adminAccess();
                break;
            case "4":
                System.out.println(passengers.toString());
                adminAccess();
                break;
            case "5":
                start();
                break;
        }
    }
}
