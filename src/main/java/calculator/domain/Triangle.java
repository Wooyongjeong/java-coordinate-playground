package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle implements Figure {
    public static final int SIZE = 3;
    private final List<Point> points;

    private Triangle(List<Point> points) {
        if (null == points || points.size() != SIZE) {
            throw new IllegalArgumentException("3개의 점을 입력해 주세요.");
        }
        this.points = points;
    }

    public static Triangle from(List<Point> points) {
        return new Triangle(points);
    }

    private double calculate(List<Double> lengths) {
        double a = lengths.get(0);
        double b = lengths.get(1);
        double c = lengths.get(2);
        return Math.sqrt(
                4 * Math.pow(a, 2) * Math.pow(b, 2) -
                        Math.pow(
                                Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2),
                                2
                        )
        ) / 4;
    }

    private List<Double> getTriangleLengths() {
        List<Line> lines = Arrays.asList(
                Line.from(Arrays.asList(points.get(0), points.get(1))),
                Line.from(Arrays.asList(points.get(0), points.get(2))),
                Line.from(Arrays.asList(points.get(1), points.get(2)))
        );
        return lines.stream()
                .map(Line::calculate)
                .collect(Collectors.toList());
    }

    @Override
    public double calculate() {
        List<Double> lengths = getTriangleLengths();
        return calculate(lengths);
    }
}
