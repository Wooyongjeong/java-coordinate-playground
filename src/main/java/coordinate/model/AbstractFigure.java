package coordinate.model;

import java.util.List;

public abstract class AbstractFigure implements Figure {
    static final String ERROR_POINTS_NULL = "올바른 Point 값이 아닙니다.";
    private final List<Point> points;

    public AbstractFigure(List<Point> points) {
        if (null == points || points.isEmpty()) {
            throw new IllegalArgumentException(ERROR_POINTS_NULL);
        }
        this.points = points;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}
