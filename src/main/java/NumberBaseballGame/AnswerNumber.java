package NumberBaseballGame;

import java.util.Random;

public class AnswerNumber {

    private final int answerNum;

    private AnswerNumber(int answerNum) {
        this.answerNum = answerNum;
    }

    public static AnswerNumber createAnswerNumber() {
        Random random = new Random();
        int answerNumber =
                random.ints(100, 1000)
                        .filter(x -> is3differentNumber(x))
                        .findAny()
                        .getAsInt();
        return new AnswerNumber(answerNumber);
    }

    private static boolean is3differentNumber(int number) {
        int numAtHundredsDigit = number / 100;
        int numAtTensDigit = (number % 100) / 10;
        int numAtUnitDigit = number % 10;
        return numAtHundredsDigit != numAtUnitDigit && numAtHundredsDigit != numAtTensDigit
                && numAtTensDigit != numAtUnitDigit;
    }

    public Score calculateScore(int number) {
        return null;
    }

    public boolean is3strike(int number) {
        return false;
    }
}
