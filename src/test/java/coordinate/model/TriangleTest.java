package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    static List<Point> points;

    @BeforeAll
    static void beforeAll() {
        points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> new Triangle(points));
    }

    @Test
    void notTriangle() {
        List<Point> notTrianglePoints = Arrays.asList(
                new Point(10, 10),
                new Point(10, 15),
                new Point(10, 8)
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Triangle(notTrianglePoints))
                .withMessage("삼각형 모양이 아닙니다.");
    }

    @Test
    void area() {
        // given
        Triangle triangle = new Triangle(points);

        // when
        double actualArea = triangle.area();

        //then
        double expectedArea = 29.0;
        assertThat(actualArea).isEqualTo(expectedArea, offset(0.00099));
    }
}
