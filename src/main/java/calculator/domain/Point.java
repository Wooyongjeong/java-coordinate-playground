package calculator.domain;

import java.util.List;

public class Point {
    private static final int SIZE = 2;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 24;
    private final int x;
    private final int y;

    private Point(int x, int y) {
        validate(x);
        validate(y);
        this.x = x;
        this.y = y;
    }

    private void validate(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("0 이상 24 이하의 숫자가 아닙니다.");
        }
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public static Point from(List<Integer> rawPoint) {
        if (null == rawPoint || rawPoint.size() != SIZE) {
            throw new IllegalArgumentException("선은 두 개의 점으로 구성되어야 합니다.");
        }
        int x = rawPoint.get(0);
        int y = rawPoint.get(1);
        return new Point(x, y);
    }

    public double calculateDifferent(Point other) {
        double distanceX = x - other.x;
        double distanceY = y - other.y;
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

    public boolean onSameLine(Point other) {
        return x == other.x || y == other.y;
    }
}
