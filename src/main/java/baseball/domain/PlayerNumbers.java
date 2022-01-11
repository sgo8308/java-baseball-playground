package baseball.domain;

import java.util.List;

public class PlayerNumbers {

    List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNumberAt(NumberPosition position) {
        return numbers.get(position.getValue());
    }
}
