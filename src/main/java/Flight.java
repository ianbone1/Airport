public class Flight {

    private Plane plane;
    private String flightNumber;
    private String departingAirport;
    private String destinationAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, String departingAirport, String destinationAirport, String departuretime){
        this.plane = plane;
        this.flightNumber=flightNumber;
        this.departingAirport=departingAirport;
        this.destinationAirport=destinationAirport;
        this.departureTime=departuretime;
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
}
