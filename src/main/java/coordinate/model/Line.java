package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String OUTPUT_AREA_OF_LINE = "두 점 사이의 거리는 ";

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        Point point1 = getPoints().get(0);
        Point point2 = getPoints().get(1);
        return point1.calculateDistance(point2);
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_LINE + area();
    }
}
