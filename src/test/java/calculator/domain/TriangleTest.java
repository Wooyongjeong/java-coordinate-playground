package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void create() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(14, 15);
        Point point3 = Point.of(20, 8);
        List<Point> points = Arrays.asList(point1, point2, point3);

        assertDoesNotThrow(() -> Triangle.from(points));
    }

    @Test
    void wrongSize() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(14, 15);
        List<Point> points = Arrays.asList(point1, point2);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Triangle.from(points))
                .withMessage("3개의 점을 입력해 주세요.");
    }

    @Test
    void calculate() {
        // given
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(14, 15);
        Point point3 = Point.of(20, 8);
        List<Point> points = Arrays.asList(point1, point2, point3);
        Triangle triangle = Triangle.from(points);

        // when
        double actualArea = triangle.calculate();

        // then
        double expectedArea = 29;
        assertThat(actualArea).isEqualTo(expectedArea, offset(0.00999));
    }
}
