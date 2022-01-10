package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.ValidationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void isInRightRange_숫자가_1부터_9사이에_있는_숫자_True(int number) {
        //when
        boolean isInRightRange = ValidationUtils.isInRightRange(number);

        //then
        assertThat(isInRightRange).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void isInRightRange_숫자가_1부터_9사이에_없는_숫자_False(int number) {
        //when
        boolean isInRightRange = ValidationUtils.isInRightRange(number);

        //then
        assertThat(isInRightRange).isFalse();
    }

    @Test
    void isAllNumberInRightRange_모든_숫자가_1부터_9사이에_있으면_True() throws Exception {
        Integer[] numbers = {3, 5, 6};

        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(numbers);

        //then
        assertThat(isAllNumberInRightRange).isTrue();
    }

    @Test
    void isAllNumberInRightRange_숫자가_1개라도_1부터_9사이에_없으면_False() throws Exception {
        Integer[] numbers = {3, 0, 6};

        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(numbers);

        //then
        assertThat(isAllNumberInRightRange).isFalse();
    }

    @Test
    void isAllNumberDifferent_모든_숫자가_다르면_True() throws Exception {
        //given
        Integer[] numbers = {3, 1, 5};

        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(numbers);

        //then
        assertThat(isAllNumberDifferent).isTrue();
    }

    @Test
    void isAllNumberDifferent_숫자가_하나라도_같으면_False() throws Exception {
        //given
        Integer[] numbers = {3, 1, 1};

        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(numbers);

        //then
        assertThat(isAllNumberDifferent).isFalse();
    }
}

