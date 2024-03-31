package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class LineTest {
    @Test
    void create() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(14, 15);
        List<Point> points = Arrays.asList(point1, point2);

        assertDoesNotThrow(() -> Line.of(points));
    }

    @Test
    void length() {
        // given
        int x1 = 10, y1 = 10;
        int x2 = 14, y2 = 15;
        Point point1 = Point.of(x1, y1);
        Point point2 = Point.of(x2, y2);
        List<Point> points = Arrays.asList(point1, point2);

        // when
        Line line = Line.of(points);
        double result = line.length();

        // then
        double expected = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        assertThat(result).isEqualTo(expected, offset(0.00999));
    }
}
