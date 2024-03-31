package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0,0", "10,10", "0,10", "10,0",
            "0,24", "24,0", "15,24", "24,15", "24,24"})
    void create(int x, int y) {
        assertDoesNotThrow(() -> Point.of(x, y));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1,0", "0,-1", "-1,-1",
            "-1,10", "10,-1", "10,25", "25, 10",
            "0,25", "25,0", "25,25",
    })
    void outOfRange(int x, int y) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.of(x, y))
                .withMessage("0 이상 24 이하의 숫자가 아닙니다.");
    }

    @Test
    void calculateDifferent() {
        // given
        int x1 = 10, y1 = 10;
        int x2 = 14, y2 = 15;

        // when
        Point point1 = Point.of(x1, y1);
        Point point2 = Point.of(x2, y2);

        // then
        double result = point1.calculateDifferent(point2);
        double expected = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        assertThat(result).isEqualTo(expected, offset(0.00099));
    }
}
