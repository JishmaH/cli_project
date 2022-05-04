import org.junit.jupiter.api.BeforeEach;

public class FlightTest {

    Flight flight;

    @BeforeEach
    public void setup(){
        flight = new Flight("Barbados", 4444);

    }
}
