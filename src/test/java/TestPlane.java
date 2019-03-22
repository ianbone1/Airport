import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(3800, plane.maxBagageWeight());
    }


}
