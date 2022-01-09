package NumberBaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void writeResults_When3strike() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(123);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        ResultType[] results = referee.writeResults();

        //then
        assertThat(results).isEqualTo(
                new ResultType[]{ResultType.STRIKE, ResultType.STRIKE, ResultType.STRIKE});
    }

    @Test
    void writeResults_WhenStrikeBallBall() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(132);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        ResultType[] results = referee.writeResults();

        //then
        assertThat(results).isEqualTo(
                new ResultType[]{ResultType.STRIKE, ResultType.BALL, ResultType.BALL});
    }

    @Test
    void writeResults_WhenStrikeStrikeNone() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(124);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        ResultType[] results = referee.writeResults();

        //then
        assertThat(results).isEqualTo(
                new ResultType[]{ResultType.STRIKE, ResultType.STRIKE, ResultType.NONE});
    }

    @Test
    void writeResults_WhenBallBallBall() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(312);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        ResultType[] results = referee.writeResults();

        //then
        assertThat(results).isEqualTo(
                new ResultType[]{ResultType.BALL, ResultType.BALL, ResultType.BALL});
    }

    @Test
    void is3strike_When3strike_True() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(123);
        Referee referee = new Referee(answerNumbers, playerNumbers);
        referee.writeResults();

        //when
        boolean is3strike = referee.is3strike();

        //then
        assertThat(is3strike).isTrue();
    }

    @Test
    void is3strike_WhenNot3strike_False() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(124);
        Referee referee = new Referee(answerNumbers, playerNumbers);
        referee.writeResults();

        //when
        boolean is3strike = referee.is3strike();

        //then
        assertThat(is3strike).isFalse();
    }

    @Test
    public void resultsToString_When1ball1strike_1볼_1스트라이크() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(253);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        referee.writeResults();
        String s = referee.resultsToString();

        //then
        assertThat(s).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void resultsToString_When1strike_1스트라이크() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(753);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        referee.writeResults();
        String s = referee.resultsToString();

        //then
        assertThat(s).isEqualTo("1스트라이크");
    }

    @Test
    public void resultsToString_When4ball_4볼() throws Exception {
        //given
        AnswerNumbers answerNumbers = getAnswerNumbers(1, 2, 3);
        PlayerNumbers playerNumbers = new PlayerNumbers(987);
        Referee referee = new Referee(answerNumbers, playerNumbers);

        //when
        referee.writeResults();
        String s = referee.resultsToString();

        //then
        assertThat(s).isEqualTo("4볼");
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