import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private String departingAirport;
    private String destinationAirport;
    private String departureTime;
    private ArrayList<Person> passengers;
    private int averageBagWeight;

    public Flight(Plane plane, String flightNumber, String departingAirport, String destinationAirport, String departuretime){
        this.averageBagWeight=25;
        this.plane = plane;
        this.flightNumber=flightNumber;
        this.departingAirport=departingAirport;
        this.destinationAirport=destinationAirport;
        this.departureTime=departuretime;
        this.passengers = new ArrayList<Person>();
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDepartingAirport() {
        return this.departingAirport;
    }

    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }





    public boolean hasEmptySeats() {
        if (this.passengers.size() < this.plane.capacity()) {
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
        if ((this.plane.maxBagageWeight()-this.checkedBagWeight()) >=
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
}
