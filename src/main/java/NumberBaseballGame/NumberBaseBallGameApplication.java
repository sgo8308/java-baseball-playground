package NumberBaseballGame;

public class NumberBaseBallGameApplication {

    static ResultView resultView = new ResultView();
    static InputView inputView = new InputView(resultView);
    static AnswerNumbers answerNumbers;
    static Referee referee;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        answerNumbers = AnswerNumbers.createAnswerNumber();

        boolean isPlayerWin = false;
        while (!isPlayerWin) {
            resultView.print(OutputType.NEW_INPUT);

            PlayerNumbers playerNumbers = new PlayerNumbers(inputView.inputPlayerNumber());

            referee = new Referee(answerNumbers, playerNumbers);
            referee.writeResults();

            resultView.println(referee.resultsToString());

            handleResult(referee.is3strike());
        }
    }

    private static void handleResult(boolean is3strike) {
        if (is3strike) {
            resultView.print(OutputType.USER_WIN);

            restartOrQuit();
        }
    }

    private static void restartOrQuit() {
        int select = inputView.inputPlayerSelection();
        if (select == 2) {
            System.exit(0);
        }

        restart();
    }

    private static void restart() {
        answerNumbers = AnswerNumbers.createAnswerNumber();
    }
}
