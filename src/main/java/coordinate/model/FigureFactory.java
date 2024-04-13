package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {
    private static final int NUM_OF_POINTS_OF_LINE = 2;
    private static final int NUM_OF_POINTS_OF_TRIANGLE = 3;
    private static final int NUM_OF_POINTS_OF_RECTANGLE = 4;
    private static final Map<Integer, FigureCreator> classifier = new HashMap<>();

    static {
        classifier.put(NUM_OF_POINTS_OF_LINE, Line::new);
        classifier.put(NUM_OF_POINTS_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_POINTS_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure getInstance(List<Point> points) {
        if (null == points || isInvalidNumberOf(points.size())) {
            throw new IllegalArgumentException(AbstractFigure.ERROR_INVALID_NUM_OF_POINTS);
        }
        return classifyFigure(points);
    }

    private static boolean isInvalidNumberOf(int size) {
        return size < NUM_OF_POINTS_OF_LINE || size > NUM_OF_POINTS_OF_RECTANGLE;
    }

    private static Figure classifyFigure(List<Point> points) {
        return classifier.get(points.size()).create(points);
    }

}
