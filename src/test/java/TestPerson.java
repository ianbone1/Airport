import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPerson {

    Person person1;

    @Before
    public void setup(){
        person1=new Person("Ian", 2);
    }

    @Test
    public void testPersonHasName() {
        assertEquals("Ian", person1.getName());
    }

    @Test
    public void testPersonHasBags() {
        assertEquals(2, person1.getBags());
    }
}
