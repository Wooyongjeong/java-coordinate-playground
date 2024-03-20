package rental;

public class K5 extends Car {
    private static final int FUEL_EFFICIENCY = 13;

    public K5(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return getClass().getSimpleName();
    }
}
