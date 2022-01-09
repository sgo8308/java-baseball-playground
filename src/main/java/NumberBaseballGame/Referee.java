package NumberBaseballGame;

import java.util.Arrays;

public class Referee {

    private final ResultType[] results = new ResultType[3];
    private AnswerNumbers answerNumbers;
    private PlayerNumbers playerNumbers;

    public Referee(AnswerNumbers answerNumbers, PlayerNumbers playerNumbers) {
        this.answerNumbers = answerNumbers;
        this.playerNumbers = playerNumbers;

        for (int order = 0; order < 3; order++) {
            results[order] = ResultType.NONE;
        }
    }

    public ResultType[] writeResults() {
        for (int order = 0; order < 3; order++) {
            checkStrike(order);
            checkBallIfNotStrike(order);
        }

        return results;
    }

    private void checkStrike(int order) {
        if (answerNumbers.isStrike(playerNumbers.getNumberAt(order), order)) {
            results[order] = ResultType.STRIKE;
        }
    }

    private void checkBallIfNotStrike(int order) {
        if (results[order] == ResultType.STRIKE) {
            return;
        }

        if (answerNumbers.isBall(playerNumbers.getNumberAt(order))) {
            results[order] = ResultType.BALL;
        }
    }

    public boolean is3strike() {
        return Arrays.stream(results)
                .allMatch(result -> result == ResultType.STRIKE);
    }

    public String resultsToString() {
        String message = "";
        int ballCount = countOf(ResultType.BALL);

        if (ballCount > 0) {
            message += ballCount + "볼 ";
        }

        int strikeCount = countOf(ResultType.STRIKE);

        if (strikeCount > 0) {
            message += strikeCount + "스트라이크";
        }

        if (message.equals("")) {
            message = "4볼";
        }

        return message;
    }

    private int countOf(ResultType resultType) {
        return (int) Arrays.stream(results)
                .filter(result -> result == resultType)
                .count();
    }
}
