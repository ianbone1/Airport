import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private String departingAirport;
    private String destinationAirport;
    private LocalDateTime departureTime;
    private ArrayList<Person> passengers;
    private int averageBagWeight;

    public Flight(Plane plane, String flightNumber, String departingAirport, String destinationAirport, LocalDateTime departureTime){
        this.averageBagWeight=25;
        this.plane = plane;
        this.flightNumber=flightNumber;
        this.departingAirport=departingAirport;
        this.destinationAirport=destinationAirport;
        this.departureTime=departureTime;
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

    public LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public boolean hasEmptySeats() {
        if (this.passengers.size() < this.plane.capacity()) {
            return true;
        }
        return false;
    }

    public ArrayList<Person> getPassengers() {
        return this.passengers;
    }

    private boolean seatAlreadyAllocated(int seat){
        for (Person person : this.passengers){
            if (person.getSeatNumber() == seat) {
                return true;
            }
        }
        return false;
    }

    private int getNextFreeSeat() {
        Random rand = new Random();
        int randomSeat = (rand.nextInt(this.plane.capacity())+1);
        while (seatAlreadyAllocated(randomSeat)){
            randomSeat = (rand.nextInt(this.plane.capacity())+1);
        }
        return randomSeat;
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

    public int getAvailableBagWeight() {
        return (this.plane.maxBagageWeight()-this.checkedBagWeight());
    }

    public boolean canCheckBags(Person person) {
        if (this.getAvailableBagWeight() >=
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

    public int passengerBagWeight(Person person) {
        return person.getBags()*this.averageBagWeight;
    }

    public void board(Person person) {
        if (this.canBoard(person)) {
            this.passengers.add(person);
            person.setFlight(this);
            person.setSeatNumber(this.getNextFreeSeat());
        }
    }

    public void sortSeats() {
        //Bubble Sort Algorithm
        Boolean swapped;
        Person temp;
        for (int i =0; i <this.passengers.size(); i++){
            swapped=false;
            for (int j=1; j<this.passengers.size(); j++){
                if (this.passengers.get(j).getSeatNumber() < this.passengers.get(j-1).getSeatNumber()){
                    temp=this.passengers.get(j);
                    this.passengers.remove(j);
                    this.passengers.add(j,this.passengers.get(j-1));
                    this.passengers.remove(j-1);
                    this.passengers.add(j-1, temp);
                    swapped=true;
                }
            }
            if (!swapped){
//                System.out.println(i); //show how many itterations
                break;
            }
        }
    }

    public Person findSeat(int searchSeatNumber, ArrayList<Person> passengerList) {
        //return null if list is empty
        if (passengerList.size() == 0){
            return null;
        }

        int middleIndex = 0;
        if (passengerList.size() >1) {
            middleIndex = (int) Math.ceil((double) passengerList.size() / 2);
        }

        Person currentPerson = passengerList.get(middleIndex);

        if (searchSeatNumber == currentPerson.getSeatNumber()){
            return currentPerson;
        }

        ArrayList<Person> newSearchArea = new ArrayList<Person>();
        if (searchSeatNumber < currentPerson.getSeatNumber()){
            if (middleIndex  > 0) {
                newSearchArea = new ArrayList<Person>(passengerList.subList(0, middleIndex));
            }
        } else {
            newSearchArea = new ArrayList<Person>(passengerList.subList(middleIndex+1, passengerList.size()));
        }
        return findSeat(searchSeatNumber, newSearchArea);
    }
}
