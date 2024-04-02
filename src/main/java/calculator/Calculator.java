package calculator;

import calculator.domain.Line;
import calculator.domain.Point;
import calculator.ui.InputView;
import calculator.ui.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<List<Integer>> rawPoints;
        List<Point> points;

        while (true) {
            try {
                rawPoints = inputView.inputPoints();
                points = getPoints(rawPoints);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }

        Line line = Line.of(points);
        double result = line.length();

        outputView.printCoordinates(rawPoints);
        outputView.printLineResult(result);
    }

    private List<Point> getPoints(List<List<Integer>> rawPoints) {
        return rawPoints.stream()
                .map(Point::from)
                .collect(Collectors.toList());
    }
}
