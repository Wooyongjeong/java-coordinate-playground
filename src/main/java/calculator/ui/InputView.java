package calculator.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<List<Integer>> inputPoints() {
        System.out.println("좌표를 입력하세요.");
        String input = scanner.nextLine();
        InputPoints inputPoints = InputPoints.from(input);
        return inputPoints.getPoints();
    }
}
