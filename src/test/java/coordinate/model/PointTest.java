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
    @CsvSource(value = {"-1,0", "0,-1", "25,0", "0,25"})
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
}
