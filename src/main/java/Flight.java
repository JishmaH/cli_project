import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String destination;
    private int id;
    private List<Passenger> bookedPassengers;

    public Flight(String destination, int id) {
        this.destination = destination;
        this.id = id;
        this.bookedPassengers = new ArrayList<>();
    }

    public String getDestination() {
        return destination;
    }

    public void addBookedPassenger(Passenger passenger) {
        this.bookedPassengers.add(passenger);
    }

    public void printBookedPassengers(){
       if(bookedPassengers.size() > 0) {
           for (Passenger bookedPassenger : bookedPassengers) {
               System.out.println(bookedPassenger.toString());
           }
       } else {
           System.out.println(" ");
           System.out.println("*NO PASSENGERS BOOKED TO THIS FLIGHT*");
           System.out.println(" ");
       }
    }

    @Override
    public String toString() {
        return "Flight{" +
                "destination='" + destination + '\'' +
                ", id=" + id +
                '}';
    }


}
