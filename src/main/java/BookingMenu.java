import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingMenu{
    private Scanner scanner;
    private ArrayList<Flight> allFlights;
    private ArrayList<Flight> availableFlights;
    private ArrayList<Flight> cancelledFlights;
    private ArrayList<Passenger> passengers;

    public BookingMenu(){
        this.scanner = new Scanner(System.in);
        this.allFlights = new ArrayList<>();
        this.availableFlights = new ArrayList <>();
        this.cancelledFlights = new ArrayList<>();
        this.passengers = new ArrayList<>();

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

    public ArrayList<Flight> getAllFlights() {
        return allFlights;
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
        System.out.println("6. Search for available flights by destination");
        System.out.println("7. Admin access");
        System.out.println("8. Close app");
        System.out.println("Please enter a number between 1 and 8 to pick an option:");
        try {
        String option = scanner.nextLine();
            if(option.equals("1")||option.equals("2")||option.equals("3")||option.equals("4")||option.equals("5")
            ||option.equals("6")||option.equals("7")||option.equals("8")) {
                System.out.println("Thank you for picking an option");
            } else
            {
                    throw new Exception("Please input a number between 1 and 8");
                }

            switch(option) {
                case "1":
                    addFlight();
                    start();
                    break;
                case "2":
                    displayAvailableFlights();
                    start();
                    break;
                case "3":
                    addPassenger();
                    start();
                    break;
                case "4":
                    bookOnToAFlight();
                    start();
                    break;
                case "5":
                    cancelFlight();
                    start();
                    break;
                case "6":
                    searchFlightsByDestination();
                    start();
                    break;
                case "7":
                    adminAccess();
                    start();
                    break;
                case "8":
                    System.out.println("Thanks for using our app!");
                    System.exit(1);
                    break;
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
            System.out.println("Exception thrown");
            System.out.println(exception.getMessage());
        }
start();
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
        Passenger passenger = new Passenger(name, email, passengerId);
        this.passengers.add(passenger);

        System.out.println("Passenger added!");
        System.out.println(" ");
        start();
    }

    public void displayAvailableFlights(){
        for(Flight flight : availableFlights){
            System.out.println(flight.toString());
        }
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

        try {
            if(availableFlights.contains(selectedFlight)) {
                selectedFlight.addBookedPassenger(selectedPassenger);
            } else {
                throw new Exception("*FLIGHT HAS BEEN CANCELLED*");
            }
        } catch (Exception exception){
            exception.printStackTrace();
            System.out.println("Exception thrown");
            System.out.println(" ");
            System.out.println(exception.getMessage());
            System.out.println(" ");

        }
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

        System.out.println(selectedFlight + " cancelled!");

        start();
    }
    public void searchFlightsByDestination(){
        System.out.println("Enter your desired destination:");
        String dest = scanner.nextLine();

        List<Flight> flightsByDestination = availableFlights.stream().filter(el -> (el.getDestination().equals(dest))).collect(Collectors.toList());
        if(flightsByDestination.isEmpty()){
            System.out.println(" ");
            System.out.println("*NO FLIGHTS TO THIS DESTINATION*");
            System.out.println(" ");
        } else {
            for (Flight flight : flightsByDestination) {
                System.out.println(flight);
            }
        }
        start();
    }

    public void adminAccess(){
        System.out.println("1. Display all flights");
        System.out.println("2. Display cancelled flights");
        System.out.println("3. Display a flight's booked passenger list");
        System.out.println("4. Display list of all passengers");
        System.out.println("5. Return to main menu");
        System.out.println("Please enter a number between 1 and 5 to pick an option:");

        try {
            String tests = scanner.nextLine();
            if(tests.equals("1")||tests.equals("2")||tests.equals("3")||tests.equals("4")||tests.equals("5")) {
                System.out.println("Thank you for picking an option");
            } else {
                throw new Exception("Please input a number between 1 and 5");
            }

            switch (tests) {

                case "1":

                    if(allFlights.size() > 0) {
                        for (Flight flight : allFlights) {
                            System.out.println(flight.toString());
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("*NO FLIGHTS FOUND*");
                        System.out.println(" ");
                    }
                    adminAccess();
                    break;

                case "2":
                    if(cancelledFlights.size() > 0) {
                        for (Flight cancelledFlight : cancelledFlights) {
                            System.out.println(cancelledFlight.toString());
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("*NO FLIGHTS CANCELLED*");
                        System.out.println(" ");
                    }
                    adminAccess();
                    break;

                case "3":
                    System.out.println("Please enter the flight's ID:");
                    String flightId = scanner.nextLine();
                    int flightIndex = Integer.parseInt(flightId) - 1;
                    Flight selectedFlight = allFlights.get(flightIndex);
                    System.out.println(selectedFlight);
                    selectedFlight.printBookedPassengers();
                    adminAccess();
                    break;

                case "4":
                    if(passengers.size() > 0) {
                        for (Passenger passenger : passengers) {
                            System.out.println(passenger.toString());
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("*NO PASSENGERS FOUND*");
                        System.out.println(" ");
                    }
                    adminAccess();
                    break;

                case "5":
                    start();
                    break;

            }
        }

        catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Exception thrown");
            System.out.println(exception.getMessage());
        }
        adminAccess();
    }
}
