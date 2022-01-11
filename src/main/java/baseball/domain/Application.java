package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;

public class Application {

    private static AnswerNumbers answerNumbers;

    public static void main(String[] args) {
        answerNumbers = AnswerNumbers.createAnswerNumbers();

        boolean isEnd = false;
        while (!isEnd) {
            OutputView.print("���ڸ� �Է����ּ��� : ");
            int number = InputView.getInput();
            Integer[] numbers = numberToArray(number);
            PlayerNumbers playerNumbers = new PlayerNumbers(Arrays.asList(numbers));

            Results result = Referee.score(answerNumbers, playerNumbers);

            OutputView.println(result.toString());

            isEnd = processResults(result);
        }
    }

    private static Integer[] numberToArray(int number) {
        return new Integer[]{Integer.parseInt(("" + number).substring(0, 1)),
                Integer.parseInt(("" + number).substring(1, 2)),
                Integer.parseInt(("" + number).substring(2, 3))};
    }

    private static boolean processResults(Results result) {
        if (result.is3strike()) {
            OutputView.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
            OutputView.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
            return playerSelect();
        }
        return false;
    }

    private static boolean playerSelect() {
        int select = InputView.getInput();
        if (select == 2) {
            return true;
        }
        answerNumbers = AnswerNumbers.createAnswerNumbers();
        return false;
    }
}
