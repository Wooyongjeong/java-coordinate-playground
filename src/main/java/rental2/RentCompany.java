package rental2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {
    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        List<String> results = cars.stream()
                .map(car -> car.getName() + " : " + (int) car.getChargeQuantity() + "리터")
                .collect(Collectors.toList());
        return String.join(System.getProperty("line.separator"), results) + System.getProperty("line.separator");
    }
}
