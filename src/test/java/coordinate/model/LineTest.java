package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LineTest {
    static List<Point> points;

    @BeforeAll
    static void beforeAll() {
        points = Arrays.asList(
                new Point(1, 2),
                new Point(3, 4)
        );
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> new Line(points));
    }

    @Test
    void area() {
        // given
        Line line = new Line(points);

        // when
        double actualArea = line.area();

        //then
        double expectedArea = 2.828;
        assertThat(actualArea).isEqualTo(expectedArea, offset(0.00099));
    }
}
