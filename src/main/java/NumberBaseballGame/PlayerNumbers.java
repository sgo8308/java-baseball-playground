package NumberBaseballGame;

public class PlayerNumbers {

    private final Integer[] numbers = new Integer[3];

    public PlayerNumbers(int number) {
        numbers[0] = NumberParser.getNumAtHundredsDigit(number);
        numbers[1] = NumberParser.getNumAtTensDigit(number);
        numbers[2] = NumberParser.getNumAtUnitDigit(number);
    }

    public Integer getNumberAt(int order) {
        return numbers[order];
    }
}

