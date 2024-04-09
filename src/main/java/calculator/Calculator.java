package calculator;

import calculator.domain.Figure;
import calculator.domain.FigureFactory;
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

    private List<Point> createPointsFrom(List<List<Integer>> rawPoints) {
        return rawPoints.stream()
                .map(Point::from)
                .collect(Collectors.toList());
    }

    private double getResult(List<Point> points) {
        Figure figure = FigureFactory.getFigure(points);
        return figure.calculate();
    }

    public void run() {
        while (true) {
            try {
                List<List<Integer>> rawPoints = inputView.inputPoints();
                List<Point> points = createPointsFrom(rawPoints);
                double result = getResult(points);
                outputView.printCoordinates(rawPoints);
                outputView.printResult(points.size(), result);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
