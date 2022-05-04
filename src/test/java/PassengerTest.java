import org.junit.jupiter.api.BeforeEach;

public class PassengerTest {

    Passenger passenger;

    @BeforeEach

    public void setup(){
        passenger = new Passenger("Jasmine", "Jasmine@outlook.com", 1234);
    }


}
