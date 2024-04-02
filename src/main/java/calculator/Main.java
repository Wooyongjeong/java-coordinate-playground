package calculator;

import calculator.ui.InputView;
import calculator.ui.OutputView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        Calculator calculator = new Calculator(inputView, outputView);
        calculator.run();

        scanner.close();
    }
}
