public enum PlaneType {
    EMBRAER170(76, 3800),
    AIRBUS318_100(32, 1600),
    AIRBUS319_100(144, 7200),
    EMBRAER190(98, 4900),
    AIRBUS320_200(180, 9000),
    AIRBUS321_200(220, 11000),
    BOEING787_8(214, 10700),
    BOEING777_200(336,16800),
    BOEING787_9(216,10800),
    BOEING747_400(345,17250),
    AIRBUS380_800(469,23450),
    BOEING777_300(299,14950);

    private final int capacity;
    private final int maxBaggageWeight;

    PlaneType(int capacity, int maxBaggageWeight) {
        this.capacity = capacity;
        this.maxBaggageWeight = maxBaggageWeight;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getMaxBaggageWeight() {
        return this.maxBaggageWeight;
    }
}
