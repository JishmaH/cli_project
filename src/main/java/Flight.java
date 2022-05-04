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

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int bookedPassengerCount(){
        return this.bookedPassengers.size();
    }

    public void addBookedPassengers(Passenger passenger) {
        this.bookedPassengers.add(passenger);
        }

}
