import org.junit.jupiter.api.BeforeEach;

public class PassengerTest {

    // We decided to use the CLI to test methods that involved user input.

    Passenger passenger;

    @BeforeEach

    public void setup(){
        passenger = new Passenger("Jasmine", "Jasmine@outlook.com", 1234);
    }


}
