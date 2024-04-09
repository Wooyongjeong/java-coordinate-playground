package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle implements Figure {
    public static final int SIZE = 4;
    private static final int VALIDATE_RECTANGLE_COUNT = 2;
    private final List<Point> points;

    private Rectangle(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        if (null == points || points.size() != SIZE) {
            throw new IllegalArgumentException("4개의 점을 입력해 주세요.");
        }
        validateRectangle(points);
    }

    private void validateRectangle(List<Point> points) {
        for (Point point1 : points) {
            int count = getOnSameLineCount(point1, points);
            if (count != VALIDATE_RECTANGLE_COUNT) {
                throw new IllegalArgumentException("직사각형이 아닙니다.");
            }
        }
    }

    private int getOnSameLineCount(Point point1, List<Point> points) {
        int count = 0;
        for (Point point2 : points) {
            if (point1.equals(point2)) {
                continue;
            }
            if (point1.onSameLine(point2)) {
                count += 1;
            }
        }
        return count;
    }

    public static Rectangle from(List<Point> points) {
        return new Rectangle(points);
    }

    @Override
    public double calculate() {
        Point point1 = points.get(0);
        List<Point> onSameLinePoints = getOnSameLinePoints(point1);
        Point point2 = onSameLinePoints.get(0);
        Point point3 = onSameLinePoints.get(1);
        Line line1 = Line.of(Arrays.asList(point1, point2));
        Line line2 = Line.of(Arrays.asList(point1, point3));
        return line1.calculate() * line2.calculate();
    }

    private List<Point> getOnSameLinePoints(Point point1) {
        List<Point> onSameLinePoints = new ArrayList<>();
        for (Point point2 : points) {
            if (point1.equals(point2)) {
                continue;
            }
            if (point1.onSameLine(point2)) {
                onSameLinePoints.add(point2);
            }
        }
        return onSameLinePoints;
    }
}
