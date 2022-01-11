package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerNumbers {

    List<Integer> numbers;

    private AnswerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static AnswerNumbers createAnswerNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        addRandomNumberUntil3differentNumber(numbers);

        return new AnswerNumbers(numbers);
    }

    private static void addRandomNumberUntil3differentNumber(ArrayList<Integer> numbers) {
        Random random = new Random();

        while (numbers.size() < 3) {
            int number = random.nextInt(9) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public int getNumberAt(NumberPosition position) {
        return numbers.get(position.getValue());
    }
}
