package rental;

public class Avante extends Car {
    private static final int FUEL_EFFICIENCY = 15;

    public Avante(int distance) {
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
