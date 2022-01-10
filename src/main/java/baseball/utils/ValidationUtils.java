package baseball.utils;

import java.util.Arrays;
import java.util.Objects;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static boolean isInRightRange(int number) {
        return number >= 1 && number <= 9;
    }

    public static boolean isAllNumberInRightRange(Integer[] numbers) {
        return Arrays.stream(numbers).allMatch(ValidationUtils::isInRightRange);
    }

    public static boolean isAllNumberDifferent(Integer[] numbers) {
        return !Objects.equals(numbers[0], numbers[1]) && !Objects.equals(numbers[0], numbers[2])
                && !Objects.equals(numbers[1], numbers[2]);
    }
}
