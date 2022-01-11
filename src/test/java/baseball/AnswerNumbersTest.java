package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerNumbers;
import baseball.domain.NumberPosition;
import baseball.utils.ValidationUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AnswerNumbersTest {

    AnswerNumbers answerNumbers;
    List<Integer> answerNumbersList;

    @BeforeEach
    void setUp() throws Exception {
        answerNumbers = AnswerNumbers.createAnswerNumbers();
        setAnswerNumbersList();
    }


    @RepeatedTest(100)
    void createAnswerNumber_AllNumberHaveToBeInRangeFrom1to9() {
        //when
        boolean isAllNumberInRightRange = ValidationUtils.isAllNumberInRightRange(
                answerNumbersList);

        //then
        assertThat(isAllNumberInRightRange).isTrue();
    }

    @RepeatedTest(100)
    void createAnswerNumber_AllNumberHaveToBeDifferentEachOther() {
        //when
        boolean isAllNumberDifferent = ValidationUtils.isAllNumberDifferent(answerNumbersList);

        //then
        assertThat(isAllNumberDifferent).isTrue();
    }

    @Test
    void isStrike_WhenStrike_True() {
        //given
        int playerNumber = answerNumbersList.get(0);

        //when
        boolean isStrike = answerNumbers.isStrike(NumberPosition.FIRST, playerNumber);

        //then
        assertThat(isStrike).isTrue();
    }

    @Test
    void isStrike_WhenNotStrike_False() {
        //given
        int playerNumber = answerNumbersList.get(0) + 1;

        //when
        boolean isStrike = answerNumbers.isStrike(NumberPosition.FIRST, playerNumber);

        //then
        assertThat(isStrike).isFalse();
    }

    @Test
    void isBall_WhenBall_True() {
        //given
        clearAnswerNumbersListAndAddNewNumber(1, 2, 3);

        NumberPosition playerPosition = NumberPosition.FIRST;
        int playerNumber = 2;

        //when
        boolean isBall = answerNumbers.isBall(playerPosition, playerNumber);

        //then
        assertThat(isBall).isTrue();
    }

    @Test
    void isBall_WhenStrike_False() {
        //given
        clearAnswerNumbersListAndAddNewNumber(1, 2, 3);

        NumberPosition playerPosition = NumberPosition.FIRST;
        int playerNumber = 1;

        //when
        boolean isBall = answerNumbers.isBall(playerPosition, playerNumber);

        //then
        assertThat(isBall).isFalse();
    }

    @Test
    void isBall_WhenNothing_False() {
        //given
        clearAnswerNumbersListAndAddNewNumber(1, 2, 3);

        NumberPosition playerPosition = NumberPosition.FIRST;
        int playerNumber = 4;

        //when
        boolean isBall = answerNumbers.isBall(playerPosition, playerNumber);

        //then
        assertThat(isBall).isFalse();
    }

    void clearAnswerNumbersListAndAddNewNumber(int firstNumber, int secondNumber,
            int thirdNumber) {
        answerNumbersList.clear();
        answerNumbersList.add(firstNumber);
        answerNumbersList.add(secondNumber);
        answerNumbersList.add(thirdNumber);
    }

    void setAnswerNumbersList() throws Exception {
        Field field = answerNumbers.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        answerNumbersList = (List<Integer>) field.get(answerNumbers);
    }
}
