package NumberBaseballGame;

public class NumberHandler {

    private static int getNumAtUnitDigit(int number) {
        return number % 10;
    }

    private static int getNumAtTensDigit(int number) {
        return (number % 100) / 10;
    }

    private static int getNumAtHundredsDigit(int number) {
        return number / 100;
    }

    public static Integer[] seperateNumberByNumberPlace(int number) {
        int numAtHundredsDigit = getNumAtHundredsDigit(number);
        int numAtTensDigit = getNumAtTensDigit(number);
        int numAtUnitDigit = getNumAtUnitDigit(number);

        return new Integer[]{numAtHundredsDigit, numAtTensDigit, numAtUnitDigit};
    }

    public static boolean isValidate(int number) {
        Integer[] numbers = seperateNumberByNumberPlace(number);

        return isAllNumberInRightRange(numbers) && isAllNumberDifferent(numbers);
    }

    private static boolean isAllNumberDifferent(Integer[] numbers) {
        return (numbers[0] != numbers[1]) && (numbers[1] != numbers[2])
                && (numbers[0] != numbers[2]);
    }

    private static boolean isAllNumberInRightRange(Integer[] numbers) {
        return isInRightRange(numbers[0]) && isInRightRange(numbers[1])
                && isInRightRange(numbers[2]);
    }

    private static boolean isInRightRange(int number) {
        return number >= 1 && number <= 9;
    }
}
