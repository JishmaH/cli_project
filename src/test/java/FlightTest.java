import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {

    // We decided to use the CLI to test methods that involved user input.


    Flight flight;
//    Passenger passenger;

    @BeforeEach
    public void setup(){
        flight = new Flight("Barbados", 4444);

    }

//    @Test
//    public void canBookAPassenger(){
//        flight.addBookedPassenger(passenger);
//        assertThat(flight.bookedPassengerCount()).isEqualTo(1);
//    }
}
