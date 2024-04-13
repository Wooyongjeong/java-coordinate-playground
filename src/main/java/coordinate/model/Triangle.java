package coordinate.model;

import java.util.List;

public class Triangle extends AbstractFigure {
    private static final String ERROR_INVALID_TRIANGLE = "삼각형 모양이 아닙니다.";
    private static final String OUTPUT_AREA_OF_TRIANGLE = "삼각형 넓이는 ";

    public Triangle(List<Point> points) {
        super(points);
        if (isParallel(points)) {
            throw new IllegalArgumentException(ERROR_INVALID_TRIANGLE);
        }
    }

    private boolean isParallel(List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);
        return point1.calculateSlope(point2) == point1.calculateSlope(point3);
    }

    @Override
    public double area() {
        Point point1 = getPoints().get(0);
        Point point2 = getPoints().get(1);
        Point point3 = getPoints().get(2);

        double a = point1.calculateDistance(point2);
        double b = point1.calculateDistance(point3);
        double c = point2.calculateDistance(point3);

        return calculateFormulaOfHeron(a, b, c);
    }

    private double calculateFormulaOfHeron(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_TRIANGLE + area();
    }
}
