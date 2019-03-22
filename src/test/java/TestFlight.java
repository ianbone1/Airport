import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestFlight {

    Plane plane;
    Flight flight;
    Person person1;
    String flightNumber;
    String departingAirport;
    String destinationAirport;
    LocalDateTime departureTime;

    @Before
    public void setup(){
        this.plane = new Plane(PlaneType.EMBRAER170);
        this.person1 = new Person("Ian", 2);
        this.flightNumber="BA123";
        this.departingAirport="GLA";
        this.destinationAirport="LAX";
        this.departureTime=LocalDateTime.parse("2019-03-22T15:00");

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
    public void testHowManyEmptySeats() {
        assertEquals(76, plane.freeSeats());
    }

    @Test
    public void testDeparting() {
        assertEquals(this.departingAirport, flight.getDepartingAirport());
    }

//    @Ignore
//    @Test
//    public void testHasDepartureTime() {
//        assertEquals(this.departureTime, flight.getDepartureTime());
//    }

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

    @Test
    public void testPersonBagWeight() {
        assertEquals(50, flight.passengerBagWeight(person1));
    }

    @Test
    public void testAvailableBagWeight() {
        assertEquals(3800, flight.getAvailableBagWeight());
    }

    @Test
    public void testDateTimeOfFlight() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime flightTime = LocalDateTime.parse("2019-03-22T15:00");
        assertEquals(flightTime, flight.getDepartureTime());
        System.out.println(flightTime);
    }

    @Test
    public void testPersonHasFlightAfterBoarding() {
        flight.board(person1);
        Flight flight2 = person1.getFlight();
        assertEquals(flight, flight2);
    }

    @Test
    public void testPassengerGetsRandomFreeSeat() {
        flight.board(person1);
        assertNotNull(person1.getSeatNumber());
//        System.out.println(person1.getSeatNumber());
    }

    @Test
    public void testSortPassengersBySeatNumber() {
        for (int i =0; i<60; i++){
            flight.board(new Person("Passenger"+i, 2));
        }
        for (Person person : flight.getPassengers()){
            System.out.println(person.getName() + " is in seat " + person.getSeatNumber());
        }
        flight.sortSeats();
        for (Person person : flight.getPassengers()){
            System.out.println(person.getName() + " is in seat " + person.getSeatNumber());
        }
    }

    @Test
    public void testBinarySearch() {
        for (int i =0; i<60; i++){
            flight.board(new Person("Passenger"+i, 2));
        }
        flight.sortSeats();
        //look for the 45th persons seat
        int searchSeat = flight.getPassengers().get(45).getSeatNumber();
        System.out.println("Searching for 45th passenger seat: "+searchSeat);
        Person foundPerson=flight.findSeat(searchSeat, flight.getPassengers());
        assertNotNull(foundPerson);
        System.out.println(foundPerson.getSeatNumber());
    }
}
