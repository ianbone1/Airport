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


    public int capacity() {
        return this.planeType.getCapacity();
    }

    public int maxBagageCapacity() {
        return this.planeType.getMaxBaggageWeight();
    }

    public boolean hasEmptySeats() {
        if (this.passengers.size() < this.planeType.getCapacity()){
            return true;
        }
        return false;
    }

    public void board(Person person) {
        if (this.canBoard(person)) {
            this.passengers.add(person);
        }
    }

    public int passengerCount() {
        return this.passengers.size();
    }

    public int checkedBags() {
        int totalBags=0;
        for (Person person : this.passengers){
            totalBags += person.getBags();
        }
        return totalBags;
    }

    public int checkedBagWeight() {
        int totalBags=0;
        for (Person person : this.passengers){
            totalBags += person.getBags();
        }
        return totalBags*this.averageBagWeight;
    }

    public boolean canCheckBags(Person person) {
        if ((this.planeType.getMaxBaggageWeight()-this.checkedBagWeight()) >=
                (person.getBags()*this.averageBagWeight)){
            return true;
        }
        return false;
    }

    public boolean canBoard(Person person) {
        if (this.hasEmptySeats() && this.canCheckBags(person)) {
            return true;
        }
        return false;
    }

    public PlaneType getType() {
        return this.planeType;
    }
}