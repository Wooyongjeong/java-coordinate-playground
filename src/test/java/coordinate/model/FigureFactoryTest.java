package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FigureFactoryTest {
    List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void ifPointsAreNull() {
        List<Point> nullPoints = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> FigureFactory.getInstance(nullPoints))
                .withMessage("올바른 Point 값이 아닙니다.");
    }

    @Test
    void onePoint() {
        points.add(new Point(0, 0));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> FigureFactory.getInstance(points))
                .withMessage("올바른 Point 값이 아닙니다.");
    }

    @Test
    void fivePoints() {
        points.add(new Point(0, 0));
        points.add(new Point(0, 0));
        points.add(new Point(0, 0));
        points.add(new Point(0, 0));
        points.add(new Point(0, 0));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> FigureFactory.getInstance(points))
                .withMessage("올바른 Point 값이 아닙니다.");
    }

    @Test
    void line() {
        // given
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));

        // when
        Figure figure = FigureFactory.getInstance(points);

        // then
        assertThat(figure).isInstanceOf(Line.class);
    }

    @Test
    void triangle() {
        // given
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(4, 7));

        // when
        Figure figure = FigureFactory.getInstance(points);

        // then
        assertThat(figure).isInstanceOf(Triangle.class);
    }

    @Test
    void rectangle() {
        // given
        points.add(new Point(10, 10));
        points.add(new Point(22, 10));
        points.add(new Point(22, 18));
        points.add(new Point(10, 18));

        // when
        Figure figure = FigureFactory.getInstance(points);

        // then
        assertThat(figure).isInstanceOf(Rectangle.class);
    }
}
