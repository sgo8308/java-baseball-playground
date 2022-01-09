package NumberBaseballGame;

public class NumberParser {

    public static int getNumAtUnitDigit(int number) {
        return number % 10;
    }

    public static int getNumAtTensDigit(int number) {
        return (number % 100) / 10;
    }

    public static int getNumAtHundredsDigit(int number) {
        return number / 100;
    }
}
