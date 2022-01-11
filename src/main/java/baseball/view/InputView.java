package baseball.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int getInput() {
        return scanner.nextInt();
    }
}
