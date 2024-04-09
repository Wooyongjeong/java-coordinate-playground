package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void create() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(22, 10);
        Point point3 = Point.of(22, 18);
        Point point4 = Point.of(10, 18);

        List<Point> points = Arrays.asList(point1, point2, point3, point4);
        assertDoesNotThrow(() -> Rectangle.from(points));
    }

    @Test
    void notRectangle() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(22, 10);
        Point point3 = Point.of(23, 18);
        Point point4 = Point.of(10, 18);

        List<Point> points = Arrays.asList(point1, point2, point3, point4);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rectangle.from(points))
                .withMessage("직사각형이 아닙니다.");
    }

    @Test
    void calculate() {
        // given
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(22, 10);
        Point point3 = Point.of(22, 18);
        Point point4 = Point.of(10, 18);

        List<Point> points = Arrays.asList(point1, point2, point3, point4);
        Rectangle rectangle = Rectangle.from(points);

        // when
        double actualArea = rectangle.calculate();

        // then
        int expectedArea = 96;
        assertThat(actualArea).isEqualTo(expectedArea);
    }
}
