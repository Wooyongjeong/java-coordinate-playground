package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class FigureFactoryTest {
    @Test
    void line() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10),
                Point.of(22, 10)
        );

        assertDoesNotThrow(() -> FigureFactory.getFigure(points));
    }

    @Test
    void rectangle() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10),
                Point.of(22, 10),
                Point.of(22, 18),
                Point.of(10, 18)
        );

        assertDoesNotThrow(() -> FigureFactory.getFigure(points));
    }

    @Test
    void wrongSize() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10)
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> FigureFactory.getFigure(points))
                .withMessage("좌표의 개수를 유효한 개수로 입력해 주세요.");
    }

    @Test
    void nullList() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> FigureFactory.getFigure(null))
                .withMessage("Point 리스트는 null일 수 없습니다.");
    }
}