package NumberBaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AnswerNumbersTest {

    @RepeatedTest(100)
    public void createAnswerNumber_IsEachNumberIsMoreThan1AndLessThan10() throws Exception {
        //given
        AnswerNumbers answerNumber = AnswerNumbers.createAnswerNumber();

        Field field = answerNumber.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        Integer[] answerNumbers = (Integer[]) field.get(answerNumber);

        //then
        Arrays.stream(answerNumbers).forEach(an -> assertThat(an >= 1 && an < 10).isTrue());
    }

    @RepeatedTest(100)
    public void createAnswerNumber_has3differentNumber() throws Exception {
        //given
        AnswerNumbers answerNumber = AnswerNumbers.createAnswerNumber();

        Field field = answerNumber.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        Integer[] answerNumbers = (Integer[]) field.get(answerNumber);

        //when
        boolean has3differentNumber =
                (answerNumbers[0] != answerNumbers[1]) && (answerNumbers[1] != answerNumbers[2])
                        && (answerNumbers[0] != answerNumbers[2]);

        //then
        assertThat(has3differentNumber).isTrue();
    }

    @Test
    public void isStrike_WhenStrike_True() throws Exception {
        //given
        AnswerNumbers answerNumber = getAnswerNumbers(1, 2, 3);

        PlayerNumbers playerNumbers = new PlayerNumbers(123);

        //when
        boolean isStrike = answerNumber.isStrike(playerNumbers.getNumberAt(0), 0);

        //then
        assertThat(isStrike).isTrue();
    }

    @Test
    public void isStrike_WhenNotStrike_False() throws Exception {
        //given
        AnswerNumbers answerNumber = getAnswerNumbers(2, 3, 4);

        PlayerNumbers playerNumbers = new PlayerNumbers(123);

        //when
        boolean isStrike = answerNumber.isStrike(playerNumbers.getNumberAt(0), 0);

        //then
        assertThat(isStrike).isFalse();
    }

    @Test
    public void isBall_WhenBall_True() throws Exception {
        //given
        AnswerNumbers answerNumber = getAnswerNumbers(1, 2, 3);

        PlayerNumbers playerNumbers = new PlayerNumbers(324);

        //when
        boolean isBall = answerNumber.isBall(playerNumbers.getNumberAt(0));

        //then
        assertThat(isBall).isTrue();
    }

    @Test
    public void isBall_WhenNotBall_False() throws Exception {
        //given
        AnswerNumbers answerNumber = getAnswerNumbers(1, 2, 3);

        PlayerNumbers playerNumbers = new PlayerNumbers(724);

        //when
        boolean isBall = answerNumber.isBall(playerNumbers.getNumberAt(0));

        //then
        assertThat(isBall).isFalse();
    }

    private AnswerNumbers getAnswerNumbers(int num1, int num2, int num3)
            throws NoSuchFieldException, IllegalAccessException {
        AnswerNumbers answerNumber = AnswerNumbers.createAnswerNumber();
        Field field = answerNumber.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        Integer[] answerNumbers = (Integer[]) field.get(answerNumber);
        answerNumbers[0] = num1;
        answerNumbers[1] = num2;
        answerNumbers[2] = num3;
        return answerNumber;
    }
}