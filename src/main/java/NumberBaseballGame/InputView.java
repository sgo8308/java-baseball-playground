package NumberBaseballGame;

import java.util.Scanner;

public class InputView {

    private ResultView resultView;

    public InputView(ResultView resultView) {
        this.resultView = resultView;
    }

    private Scanner sc = new Scanner(System.in);

    public int getInput() {
        int number = sc.nextInt();
        number = getInputUntilValidateNumber(number);
        return number;
    }

    private int getInputUntilValidateNumber(int number) {
        while (!NumberHandler.isValidate(number)) {
            resultView.printRuleAndRequestNewInput();
            number = sc.nextInt();
        }
        return number;
    }
}
