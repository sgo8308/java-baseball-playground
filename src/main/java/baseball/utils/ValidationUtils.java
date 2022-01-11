package baseball.utils;

import java.util.List;
import java.util.Objects;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static boolean isInRightRange(int number) {
        return number >= 1 && number <= 9;
    }

    public static boolean isAllNumberInRightRange(List<Integer> numbers) {
        return numbers.stream().allMatch(ValidationUtils::isInRightRange);
    }

    public static boolean isAllNumberDifferent(List<Integer> numbers) {
        return !Objects.equals(numbers.get(0), numbers.get(1)) && !Objects.equals(numbers.get(0),
                numbers.get(2))
                && !Objects.equals(numbers.get(1), numbers.get(2));
    }
}
