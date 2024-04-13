package coordinate.model;

import java.util.List;

public interface Figure {
    double area();
    String getAreaInfo();
    List<Point> getPoints();
}
