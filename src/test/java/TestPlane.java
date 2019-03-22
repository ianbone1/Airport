import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestPlane {

    Plane plane;
    Person person1;

    @Before
    public void setup(){
        plane=new Plane(PlaneType.EMBRAER170);
        person1=new Person("Ian", 2);
    }

    @Test
    public void testPlaneSeatCapacity() {
        assertEquals(76, plane.capacity());
    }

    @Test
    public void testGetPlaneType() {
        assertEquals(PlaneType.EMBRAER170, plane.getType());
    }

    @Test
    public void testMaxBagageWeight() {
        assertEquals(3800, plane.maxBagageCapacity());
    }



    @Test
    public void testPlaneCanAddPerson() {
        plane.board(person1);
        assertEquals(1, plane.passengerCount());
    }

    @Test
    public void testCheckedBags() {
        plane.board(person1);
        assertEquals(2, plane.checkedBags());
    }

    @Test
    public void testPlaneHasFreeSeats() {
        assertTrue(plane.hasEmptySeats());
    }

    @Test
    public void testCanNotOverFillPlaneWithPeople() {
        int counter=0;
        while (plane.hasEmptySeats()){
            plane.board(person1);
            counter++;
        }
        assertEquals(76, counter);
    }

    @Test
    public void testNumberOfBagsCouldBeLoaded() {
        assertTrue(plane.canCheckBags(person1));
    }

    @Test
    public void testCanBoardPassenger() {
        assertTrue(plane.canBoard(person1));
    }

    @Test
    public void testCanNotOverLoadBaggage() {
        //plane should be fully loaded with bags, but only half full with passengers.
        Person person2=new Person("Baggage Bob", 4);
        int counter =0;
        while (plane.canBoard(person2)){
            plane.board(person2);
            counter++;
        }
        assertEquals(38, counter);
        assertEquals(38, plane.passengerCount());
        assertTrue(plane.hasEmptySeats());
        assertEquals(152,plane.checkedBags());
    }
}
