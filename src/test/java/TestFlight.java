import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
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
        flight.board(person1);
        assertEquals(1, flight.passengerCount());
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




    @Test
    public void testPlaneCanAddPerson() {
        flight.board(person1);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void testCheckedBags() {
        flight.board(person1);
        assertEquals(2, flight.checkedBags());
    }

    @Test
    public void testPlaneHasFreeSeats() {
        assertTrue(flight.hasEmptySeats());
    }

    @Test
    public void testCanNotOverFillPlaneWithPeople() {
        int counter=0;
        while (flight.hasEmptySeats()){
            flight.board(person1);
            counter++;
        }
        assertEquals(76, counter);
    }

    @Test
    public void testNumberOfBagsCouldBeLoaded() {
        assertTrue(flight.canCheckBags(person1));
    }

    @Test
    public void testCanBoardPassenger() {
        assertTrue(flight.canBoard(person1));
    }

    @Test
    public void testCanNotOverLoadBaggage() {
        //plane should be fully loaded with bags, but only half full with passengers.
        Person person2=new Person("Baggage Bob", 4);
        int counter =0;
        while (flight.canBoard(person2)){
            flight.board(person2);
            counter++;
        }
        assertEquals(38, counter);
        assertEquals(38, flight.passengerCount());
        assertTrue(flight.hasEmptySeats());
        assertEquals(152,flight.checkedBags());
    }
}
