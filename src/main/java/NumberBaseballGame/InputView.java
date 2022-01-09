package NumberBaseballGame;

import java.util.Scanner;

public class InputView {

    private ResultView resultView;

    public InputView(ResultView resultView) {
        this.resultView = resultView;
    }

    private Scanner sc = new Scanner(System.in);

    public int inputPlayerNumber() {
        int number = sc.nextInt();
        number = getInputUntilValidateNumber(number);
        return number;
    }

    public int inputPlayerSelection() {
        resultView.print(OutputType.RESTART_OR_QUIT);
        int select = sc.nextInt();
        while (select != 1 && select != 2) {
            resultView.print(OutputType.RESTART_OR_QUIT);
            select = sc.nextInt();
        }

        return select;
    }

    private int getInputUntilValidateNumber(int number) {
        while (!NumberHandler.isValidate(number)) {
            resultView.print(OutputType.RULE);
            resultView.print(OutputType.NEW_INPUT);
            number = sc.nextInt();
        }
        return number;
    }
}
