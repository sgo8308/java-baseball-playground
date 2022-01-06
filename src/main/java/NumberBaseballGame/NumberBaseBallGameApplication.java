package NumberBaseballGame;

public class NumberBaseBallGameApplication {

    public static void main(String[] args) {
        while (true) {
            AnswerNumber answerNumber = AnswerNumber.createAnswerNumber();

            System.out.print("���ڸ� �Է����ּ��� : ");

            InputView inputView = new InputView();
            int number = inputView.getInput();

            Score score = answerNumber.calculateScore(number);

            ResultView resultView = new ResultView();
            resultView.printResult(score);

            if (answerNumber.is3strike(number)) {
                System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����\n������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
                int select = inputView.getInput();
                if (select == 2) {
                    break;
                }
            }
        }
    }

}
