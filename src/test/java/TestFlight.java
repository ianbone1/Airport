import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFlight {

    Plane plane;
    Flight flight;
    Person person1;
    String flightNumber;
    String departingAirport;
    String destinationAirport;
    String departureTime;

    @Before
    public void setup(){
        this.plane = new Plane(PlaneType.EMBRAER170);
        this.person1 = new Person("Ian", 2);
        this.flightNumber="BA123";
        this.departingAirport="GLA";
        this.destinationAirport="LAX";
        this.departureTime="09:00";

        this.flight= new Flight(this.plane, this.flightNumber, this.departingAirport, this.destinationAirport, this.departureTime);
    }

    @Test
    public void testFlightHasAPlane() {
        assertEquals(PlaneType.EMBRAER170, flight.getPlane().getType());
    }

    @Test
    public void testCanAddPassenger() {
        flight.getPlane().board(person1);
        assertEquals(1, flight.getPlane().passengerCount());
    }

    @Test
    public void testFlightNumber() {
        assertEquals(this.flightNumber, flight.getFlightNumber());
    }

    @Test
    public void testDestination() {
        assertEquals(this.destinationAirport, flight.getDestinationAirport());
    }

    @Test
    public void testDeparting() {
        assertEquals(this.departingAirport, flight.getDepartingAirport());
    }

    @Test
    public void testHasDepartureTime() {
        assertEquals(this.departureTime, flight.getDepartureTime());
    }
}
