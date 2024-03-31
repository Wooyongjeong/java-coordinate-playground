package calculator.domain;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        if (null == points || points.size() != 2) {
            throw new IllegalArgumentException("2개의 점을 입력해 주세요.");
        }
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public double length() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        return point1.calculateDifferent(point2);
    }
}
