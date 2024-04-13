package coordinate.view;

import static org.assertj.core.api.Assertions.assertThat;

import coordinate.model.Figure;
import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.Rectangle;
import coordinate.model.Triangle;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void line() {
        // given & when
        Figure figure = InputView.inputCoordinates("(1, 1) - (2, 2)");

        // then
        assertThat(figure).isInstanceOf(Line.class);
    }

    @Test
    void triangle() {
        // given & when
        Figure figure = InputView.inputCoordinates("(1, 1) - (3, 2) - (2, 5)");

        // then
        assertThat(figure).isInstanceOf(Triangle.class);
    }

    @Test
    void rectangle() {
        // given & when
        Figure figure = InputView.inputCoordinates("(10, 10) - (22, 10) - (22, 18) - (10, 18)");

        // then
        assertThat(figure).isInstanceOf(Rectangle.class);
    }
}
