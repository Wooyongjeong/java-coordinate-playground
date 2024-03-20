package rental2;

public class K5 implements Car {
    private static final int FUEL_EFFICIENCY = 13;
    private final double tripDistance;

    public K5(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    public double getTripDistance() {
        return this.tripDistance;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
