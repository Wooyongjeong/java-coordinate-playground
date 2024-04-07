package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0,0", "10,10", "0,10", "10,0",
            "0,24", "24,0", "15,24", "24,15", "24,24"})
    void create(int x, int y) {
        assertDoesNotThrow(() -> Point.of(x, y));
    }

    @ParameterizedTest
    @MethodSource(value = "rawPointsProvider")
    void create(List<Integer> rawPoints) {
        assertDoesNotThrow(() -> Point.from(rawPoints));
    }

    static Stream<Arguments> rawPointsProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 0)),
                Arguments.of(Arrays.asList(10, 10)),
                Arguments.of(Arrays.asList(0, 10)),
                Arguments.of(Arrays.asList(10, 0)),
                Arguments.of(Arrays.asList(0, 24)),
                Arguments.of(Arrays.asList(24, 0)),
                Arguments.of(Arrays.asList(15, 24)),
                Arguments.of(Arrays.asList(24, 15)),
                Arguments.of(Arrays.asList(24, 24))
        );
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

    @ParameterizedTest
    @MethodSource(value = "outOfRangeRawPointsProvider")
    void outOfRange(List<Integer> rawPoints) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.from(rawPoints))
                .withMessage("0 이상 24 이하의 숫자가 아닙니다.");
    }

    static Stream<Arguments> outOfRangeRawPointsProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(-1, 0)),
                Arguments.of(Arrays.asList(0, -1)),
                Arguments.of(Arrays.asList(-1, -1)),
                Arguments.of(Arrays.asList(-1, 10)),
                Arguments.of(Arrays.asList(10, -1)),
                Arguments.of(Arrays.asList(10, 25)),
                Arguments.of(Arrays.asList(25, 10)),
                Arguments.of(Arrays.asList(0, 25)),
                Arguments.of(Arrays.asList(25, 0)),
                Arguments.of(Arrays.asList(0, 25)),
                Arguments.of(Arrays.asList(25, 25))
        );
    }

    @Test
    void wrongSize() {
        List<Integer> rawPoints = Arrays.asList(1, 2, 3);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.from(rawPoints))
                .withMessage("선은 두 개의 점으로 구성되어야 합니다.");
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

    @Test
    void onSameLine() {
        // given
        Point point1 = Point.of(10, 20);
        Point point2 = Point.of(10, 15);

        Point point3 = Point.of(5, 10);
        Point point4 = Point.of(20, 10);

        // when
        boolean actual1 = point1.onSameLine(point2);
        boolean actual2 = point3.onSameLine(point4);
        boolean actual3 = point1.onSameLine(point3);

        // then
        assertThat(actual1).isTrue();
        assertThat(actual2).isTrue();
        assertThat(actual3).isFalse();
    }
}
