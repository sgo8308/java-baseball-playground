package NumberBaseballGame;

public class NumberBaseBallGameApplication {

    public static void main(String[] args) {
        while (true) {
            AnswerNumber answerNumber = AnswerNumber.createAnswerNumber();

            System.out.print("숫자를 입력해주세요 : ");

            InputView inputView = new InputView();
            int number = inputView.getInput();

            Score score = answerNumber.calculateScore(number);

            ResultView resultView = new ResultView();
            resultView.printResult(score);

            if (answerNumber.is3strike(number)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int select = inputView.getInput();
                if (select == 2) {
                    break;
                }
            }
        }
    }

}
