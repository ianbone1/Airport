public class Person {

    private String name;
    private int bags;
    private Flight flight;
    private int seatNumber;

    public Person(String name, int numberBags){
        this.name=name;
        this.bags=numberBags;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.bags;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
