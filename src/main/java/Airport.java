import java.util.ArrayList;

public class Airport {

    ArrayList<Flight> flights;
    ArrayList<Passenger> passengers;
    ArrayList<Flight> cancelledFlights;

    public Airport() {
        this.flights = new ArrayList <Flight>();
        this.passengers = new ArrayList<Passenger>();
        this.cancelledFlights = new ArrayList<Flight>();
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);}

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void cancelFlight(Flight flight){
        this.flights.remove(flight);
        this.cancelledFlights.add(flight);
    }
    
}
