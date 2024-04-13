package coordinate.model;

public class Point {
    private static final String ERROR_OUT_OF_RANGE
            = "범위를 벗어났습니다. " + Point.MIN_LIMIT + " ~ " + Point.MAX_LIMIT + " 사이의 값을 입력해 주세요.";
    private static final int MIN_LIMIT = 0;
    private static final int MAX_LIMIT = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkRangeOf(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkRangeOf(int x, int y) {
        if (exceedRange(x) || exceedRange(y)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    private boolean exceedRange(int coordinate) {
        return coordinate < MIN_LIMIT || coordinate > MAX_LIMIT;
    }

    public double calculateDistance(Point other) {
        return Math.sqrt(squareDifference(this.x, other.x) + squareDifference(this.y, other.y));
    }

    private double squareDifference(int firstValue, int secondValue) {
        return Math.pow(firstValue - secondValue, 2);
    }
}
