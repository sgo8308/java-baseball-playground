package baseball.domain;

public class Referee {

    private Referee() {
    }

    public static Results score(AnswerNumbers answerNumbers, PlayerNumbers playerNumbers) {
        int strikeCount = 0;
        int ballCount = 0;
        for (NumberPosition position : NumberPosition.values()) {
            strikeCount += countStrike(answerNumbers, playerNumbers, position);
            ballCount += countBall(answerNumbers, playerNumbers, position);
        }

        return new Results(ballCount, strikeCount);
    }

    private static int countBall(AnswerNumbers answerNumbers, PlayerNumbers playerNumbers,
            NumberPosition position) {

        if (answerNumbers.isBall(position, playerNumbers.getNumberAt(position))) {
            return 1;
        }
        return 0;
    }

    private static int countStrike(AnswerNumbers answerNumbers, PlayerNumbers playerNumbers,
            NumberPosition position) {

        if (answerNumbers.isStrike(position, playerNumbers.getNumberAt(position))) {
            return 1;
        }

        return 0;
    }
}
