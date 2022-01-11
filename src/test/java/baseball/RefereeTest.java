package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerNumbers;
import baseball.domain.PlayerNumbers;
import baseball.domain.Referee;
import baseball.domain.Results;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

    Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3스트라이크", "3,1,2,3볼", "1,3,5,1볼 1스트라이크", "4,5,6,낫싱"})
    void score_WhenAnswerNumberIs123(int playerFirstNumber, int playerSecondNumber,
            int playerthirdNumber, String expected) throws Exception {

        //given
        AnswerNumbers answerNumbers = createAnswerNumbers(1, 2, 3);

        PlayerNumbers playerNumbers = new PlayerNumbers(
                Arrays.asList(playerFirstNumber, playerSecondNumber, playerthirdNumber));

        //when
        Results results = referee.score(answerNumbers, playerNumbers);

        //then
        assertThat(results).hasToString(expected);
    }

    AnswerNumbers createAnswerNumbers(int firstNumber, int secondNumber, int thirdNumber)
            throws Exception {
        AnswerNumbers answerNumbers = AnswerNumbers.createAnswerNumbers();

        Field field = answerNumbers.getClass().getDeclaredField("numbers");
        field.setAccessible(true);

        List<Integer> answerNumbersList = (List<Integer>) field.get(answerNumbers);
        answerNumbersList.clear();
        answerNumbersList.add(firstNumber);
        answerNumbersList.add(secondNumber);
        answerNumbersList.add(thirdNumber);

        return answerNumbers;
    }
}
