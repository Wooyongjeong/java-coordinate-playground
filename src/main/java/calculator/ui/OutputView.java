package calculator.ui;

import calculator.domain.Line;
import calculator.domain.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OutputView {
    private static final String POINT = "●";
    private static final String TWO_BLANKS = "  ";
    private static final String VERTICAL = "│";
    private static final String ORIGIN = "┼";
    private static final String HORIZONTAL = "──";
    private static final int SIZE = 24;

    public void printCoordinates(List<List<Integer>> points) {
        for (int y = SIZE; y > 0; y--) {
            printYCoordinate(y);
            printPoints(y, points);
        }

        System.out.print(TWO_BLANKS);
        printXCoordinate(points);

        printXNumbers();
    }

    private void printYCoordinate(int y) {
        if (y % 2 == 0) {
            System.out.printf("%2d", y);
            return;
        }
        System.out.print(TWO_BLANKS);
    }

    private void printPoints(int nowY, List<List<Integer>> points) {
        Set<Integer> set = getYPoints(nowY, points);
        String yCoordinate = getYCoordinate(set);
        System.out.print(yCoordinate);
        for (int x = 1; x <= SIZE; x++) {
            if (set.contains(x)) {
                System.out.print(POINT);
                continue;
            }
            System.out.print(TWO_BLANKS);
        }
        System.out.println();
    }

    private static Set<Integer> getYPoints(int nowY, List<List<Integer>> points) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> point : points) {
            int x = point.get(0);
            int y = point.get(1);
            if (nowY == y) {
                set.add(x);
            }
        }
        return set;
    }

    private String getYCoordinate(Set<Integer> set) {
        if (set.contains(0)) {
            return POINT;
        }
        return VERTICAL;
    }

    private void printXCoordinate(List<List<Integer>> points) {
        Set<Integer> set = getXPoints(points);
        System.out.print(getVertex(set));
        for (int x = 1; x <= SIZE; x++) {
            if (set.contains(x)) {
                System.out.print(POINT);
                continue;
            }
            System.out.print(HORIZONTAL);
        }
        System.out.println();
    }

    private static void printXNumbers() {
        for (int x = 0; x <= SIZE; x += 2) {
            System.out.printf("%2d" + TWO_BLANKS, x);
        }
        System.out.println();
    }

    private Set<Integer> getXPoints(List<List<Integer>> points) {
        Set<Integer> xPoints = new HashSet<>();
        points.forEach(point -> {
            int x = point.get(0);
            int y = point.get(1);
            if (y == 0) {
                xPoints.add(x);
            }
        });
        return xPoints;
    }

    private String getVertex(Set<Integer> set) {
        if (set.contains(0)) {
            return POINT;
        }
        return ORIGIN;
    }

    public void printErrorMessage(String message) {
        System.err.println(message);
    }

    public void printResult(int size, double result) {
        if (size == Line.SIZE) {
            System.out.printf("두 점 사이의 거리는 %.6f\n", result);
        }
        if (size == Rectangle.SIZE) {
            System.out.println("사각형 넓이는 " + (int) result);
        }
    }
}
