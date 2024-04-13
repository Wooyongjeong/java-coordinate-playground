package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    static List<Point> points;

    @BeforeAll
    static void beforeAll() {
        points = Arrays.asList(
                new Point(10, 10),
                new Point(22, 10),
                new Point(22, 18),
                new Point(10, 18)
        );
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    void notRectangle() {
        List<Point> notRectanglePoints = Arrays.asList(
                new Point(10, 10),
                new Point(22, 11),
                new Point(22, 18),
                new Point(10, 18)
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Rectangle(notRectanglePoints))
                .withMessage("직사각형 모양이 아닙니다.");
    }

    @Test
    void area() {
        // given
        Rectangle rectangle = new Rectangle(points);

        // when
        double actualArea = rectangle.area();

        //then
        double expectedArea = 96;
        assertThat(actualArea).isEqualTo(expectedArea, offset(0.00099));
    }
}
