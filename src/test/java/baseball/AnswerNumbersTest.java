package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerNumbers;
import baseball.domain.NumberPosition;
import baseball.utils.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class AnswerNumbersTest {

    AnswerNumbers answerNumbers;
    Integer[] answerNumbersArray;

    @BeforeEach
    void setUp() {
        answerNumbers = AnswerNumbers.createAnswerNumbers();
        int firstNumber = answerNumbers.getNumberAt(NumberPosition.FIRST);
        int secondNumber = answerNumbers.getNumberAt(NumberPosition.SECOND);
        int thirdNumber = answerNumbers.getNumberAt(NumberPosition.THIRD);
        answerNumbersArray = new Integer[]{firstNumber, secondNumber, thirdNumber};
    }

    @RepeatedTest(100)
    void createAnswerNumber_AllNumberHaveToBeInRangeFrom1to9() {
        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(
                answerNumbersArray);

        //then
        assertThat(isAllNumberInRightRange).isTrue();
    }

    @RepeatedTest(100)
    void createAnswerNumber_AllNumberHaveToBeDifferentEachOther() {
        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(answerNumbersArray);

        //then
        assertThat(isAllNumberDifferent).isTrue();
    }
}
