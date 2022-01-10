package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.ValidationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void isInRightRange_���ڰ�_1����_9���̿�_�ִ�_����_True(int number) {
        //when
        boolean isInRightRange = ValidationUtils.isInRightRange(number);

        //then
        assertThat(isInRightRange).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void isInRightRange_���ڰ�_1����_9���̿�_����_����_False(int number) {
        //when
        boolean isInRightRange = ValidationUtils.isInRightRange(number);

        //then
        assertThat(isInRightRange).isFalse();
    }

    @Test
    void isAllNumberInRightRange_���_���ڰ�_1����_9���̿�_������_True() throws Exception {
        Integer[] numbers = {3, 5, 6};

        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(numbers);

        //then
        assertThat(isAllNumberInRightRange).isTrue();
    }

    @Test
    void isAllNumberInRightRange_���ڰ�_1����_1����_9���̿�_������_False() throws Exception {
        Integer[] numbers = {3, 0, 6};

        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(numbers);

        //then
        assertThat(isAllNumberInRightRange).isFalse();
    }

    @Test
    void isAllNumberDifferent_���_���ڰ�_�ٸ���_True() throws Exception {
        //given
        Integer[] numbers = {3, 1, 5};

        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(numbers);

        //then
        assertThat(isAllNumberDifferent).isTrue();
    }

    @Test
    void isAllNumberDifferent_���ڰ�_�ϳ���_������_False() throws Exception {
        //given
        Integer[] numbers = {3, 1, 1};

        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(numbers);

        //then
        assertThat(isAllNumberDifferent).isFalse();
    }
}

