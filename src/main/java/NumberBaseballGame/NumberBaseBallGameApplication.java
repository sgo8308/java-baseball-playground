package NumberBaseballGame;

public class NumberBaseBallGameApplication {

    public static void main(String[] args) {
        while (true) {
            AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumber();

            System.out.print("���ڸ� �Է����ּ��� : ");

            ResultView resultView = new ResultView();
            InputView inputView = new InputView(resultView);
            PlayerNumbers playerNumbers = new PlayerNumbers(inputView.getInput());

            Referee referee = new Referee(answerNumbers, playerNumbers);
            ResultType[] results = referee.writeResults();

            resultView.printResult(results);

            if (referee.is3strike()) {
                System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����\n������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
                int select = inputView.getInput();
                if (select == 2) {
                    break;
                }
            }
        }
    }
}
