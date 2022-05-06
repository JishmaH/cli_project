import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookingMenuTest {

    // We decided to use the CLI to test methods that involved user input.

    BookingMenu bookingMenu;
    Flight flight;

    @BeforeEach
    public void setup(){
        bookingMenu = new BookingMenu();
        flight = new Flight("Barbados", 4444);
    }

    @Test
    public void canAddFlight(){
        bookingMenu.addFlight();
        assertThat(bookingMenu.getAvailableFlights().size()).isEqualTo(1);
        assertThat(bookingMenu.getAllFlights().size()).isEqualTo(1);
    }

//    @Test
//    public void canPrintFlights(){
//        bookingMenu.addFlight();
//        assertThat(bookingMenu.printAvailableFlights()).isEqualTo("[Flight{destination='Barbados', id=4444}]");
//    }

    @Test
    public void canAddPassenger(){
        bookingMenu.addPassenger();
        assertThat(bookingMenu.getPassengers().size()).isEqualTo(1);
    }

    @Test
    public void canCancelFlight(){
        bookingMenu.addFlight();
        bookingMenu.cancelFlight();
        assertThat(bookingMenu.getCancelledFlights().size()).isEqualTo(1);
        assertThat(bookingMenu.getAvailableFlights().size()).isEqualTo(0);
    }

}
