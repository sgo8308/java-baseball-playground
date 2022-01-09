package NumberBaseballGame;

public class NumberBaseBallGameApplication {

    public static void main(String[] args) {
        while (true) {
            AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumber();

            System.out.print("숫자를 입력해주세요 : ");

            InputView inputView = new InputView();
            PlayerNumbers playerNumbers = new PlayerNumbers(inputView.getInput());

            Referee referee = new Referee(answerNumbers, playerNumbers);
            ResultType[] results = referee.writeResults();

            ResultView resultView = new ResultView();
            resultView.printResult(results);

            if (referee.is3strike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int select = inputView.getInput();
                if (select == 2) {
                    break;
                }
            }
        }
    }
}
