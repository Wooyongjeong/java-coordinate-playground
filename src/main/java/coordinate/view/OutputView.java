package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Point;

public class OutputView {
    private static final String FOUR_BLANKS = "    ";
    private static final String VERTICAL_AXIS = "|";
    private static final String ORIGIN = "+";
    private static final String HORIZONTAL_AXIS = "----";
    private static final String MARK_OF_POINT = "●";

    public static void showCoordinatePlane(Figure figure) {
        showVerticalNumbersWith(figure);
        showHorizontalAxis();
        showHorizontalNumbers();
    }

    private static void showVerticalNumbersWith(Figure figure) {
        for (int y = Point.MAX_LIMIT; y >= Point.MIN_LIMIT; y--) {
            showAxisNumber(y);
            System.out.println(VERTICAL_AXIS);
            showPoints(figure, y);
            emptyLine();
        }
    }

    private static void showAxisNumber(int number) {
        if (number % 2 == 0) {
            System.out.printf("%4d", number);
            return;
        }
        System.out.print(FOUR_BLANKS);
    }

    private static void showPoints(Figure figure, int y) {
        for (int x = Point.MIN_LIMIT; x <= Point.MAX_LIMIT; x++) {
            if (figure.hasPoint(x, y)) {
                System.out.printf("%4s", MARK_OF_POINT);
                continue;
            }
            System.out.print(FOUR_BLANKS);
        }
    }

    private static void showHorizontalAxis() {
        System.out.print(FOUR_BLANKS + ORIGIN);
        for (int x = Point.MIN_LIMIT; x <= Point.MAX_LIMIT; x++) {
            System.out.print(HORIZONTAL_AXIS);
        }
        emptyLine();
    }

    private static void showHorizontalNumbers() {
        for (int x = 0; x <= Point.MAX_LIMIT; x++) {
            showAxisNumber(x);
        }
        emptyLine();
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void showAreaInfo(Figure figure) {
        System.out.println(figure.getAreaInfo());
    }
}
