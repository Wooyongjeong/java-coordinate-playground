package calculator.domain;

import java.util.List;

public class Line implements Figure {
    public static final int SIZE = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        if (null == points || points.size() != SIZE) {
            throw new IllegalArgumentException("2개의 점을 입력해 주세요.");
        }
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    @Override
    public double calculate() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        return point1.calculateDifferent(point2);
    }
}
