package calculator.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputPoints {
    private final List<List<Integer>> points;

    private InputPoints(String input) {
        validate(input);
        points = makePoints(input);
    }

    private void validate(String input) {
        if (!input.matches("^\\(\\d+,\\d+\\)(-?\\(\\d+,\\d+\\))+$")) {
            throw new IllegalArgumentException("각 좌표는 '(숫자,숫자)' 형식으로, 좌표 사이는 '-'로 구분하여 입력해 주세요.");
        }
    }

    private List<List<Integer>> makePoints(String input) {
        String[] rawPoints = input.split("-");
        List<List<Integer>> points = new ArrayList<>();
        for (String rawPoint : rawPoints) {
            String removeBracket = rawPoint.substring(1, rawPoint.length() - 1);
            List<Integer> numbers = Arrays.stream(removeBracket.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            points.add(numbers);
        }
        return points;
    }

    public static InputPoints from(String input) {
        return new InputPoints(input);
    }

    public List<List<Integer>> getPoints() {
        return points;
    }
}
