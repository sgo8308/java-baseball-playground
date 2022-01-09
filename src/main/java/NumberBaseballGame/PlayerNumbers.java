package NumberBaseballGame;

public class PlayerNumbers {

    private Integer[] numbers;

    public PlayerNumbers(int number) {
        numbers = NumberHandler.seperateNumberByNumberPlace(number);
    }

    public Integer getNumberAt(int order) {
        return numbers[order];
    }
}

