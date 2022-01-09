package NumberBaseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AnswerNumbers {

    private Integer[] numbers;

    private AnswerNumbers(int number) {
        numbers = NumberHandler.seperateNumberByNumberPlace(number);
    }

    public static AnswerNumbers createAnswerNumber() {
        ArrayList<Integer> nums = new ArrayList<>();
        String answerNumber = "";

        for (int i = 0; i < 3; i++) {
            int num = getNumberNotIn(nums);
            answerNumber += num;
            nums.add(num);
        }

        return new AnswerNumbers(Integer.parseInt(answerNumber));
    }

    private static int getNumberNotIn(ArrayList<Integer> nums) {
        Random random = new Random();
        int num = random.nextInt(9) + 1;

        while (nums.contains(num)) {
            num = random.nextInt(9) + 1;
        }
        return num;
    }

    public boolean isStrike(int number, int order) {
        if (numbers[order] == number) {
            return true;
        }
        return false;
    }

    public boolean isBall(int number) {
        if (Arrays.asList(numbers).contains(number)) {
            return true;
        }
        return false;
    }
}
