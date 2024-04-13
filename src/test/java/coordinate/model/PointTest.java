package coordinate.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointTest {
    @Test
    void create() {
        assertDoesNotThrow(() -> new Point(10, 10));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,1", "1,-1", "25,1", "1,25"})
    void outOfRange(int x, int y) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(x, y));
    }

    @Test
    void calculateDistance() {
        // given
        Point point1 = new Point(10, 10);
        Point point2 = new Point(14, 15);

        // when
        double actualDistance = point1.calculateDistance(point2);

        // then
        double expectedDistance = 6.403124;
        assertThat(actualDistance).isEqualTo(expectedDistance, offset(0.00099));
    }

    @Test
    void isSameTrue() {
        // given
        Point point = new Point(10, 10);

        // when
        boolean actualResult = point.isSame(10, 10);

        // then
        assertThat(actualResult).isTrue();
    }

    @Test
    void isSameFalse() {
        // given
        Point point = new Point(10, 10);

        // when
        boolean actualResult = point.isSame(11, 11);

        // then
        assertThat(actualResult).isFalse();
    }
}
