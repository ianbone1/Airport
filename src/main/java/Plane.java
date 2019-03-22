import java.util.ArrayList;

public class Plane{

    private PlaneType planeType;
    private ArrayList<Person> passengers;
    private int averageBagWeight;

    public Plane(PlaneType planeType){
        this.planeType=planeType;
        this.passengers=new ArrayList<Person>();
        this.averageBagWeight=25;
    }

    public PlaneType getType() {
        return this.planeType;
    }

    public int capacity() {
        return this.planeType.getCapacity();
    }

    public int maxBagageWeight() {
        return this.planeType.getMaxBaggageWeight();
    }
}