package calculator.domain;

import java.util.List;

public class FigureFactory {
    public static Figure getFigure(List<Point> points) {
        if (null == points) {
            throw new IllegalArgumentException("Point 리스트는 null일 수 없습니다.");
        }
        if (points.size() == Line.SIZE) {
            return Line.from(points);
        }
        if (points.size() == Triangle.SIZE) {
            return Triangle.from(points);
        }
        if (points.size() == Rectangle.SIZE) {
            return Rectangle.from(points);
        }
        throw new IllegalArgumentException("좌표의 개수를 유효한 개수로 입력해 주세요.");
    }
}
