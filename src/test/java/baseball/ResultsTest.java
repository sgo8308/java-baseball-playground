package baseball;

import baseball.domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultsTest {

    @ParameterizedTest
    @CsvSource({"0,3,3스트라이크", "1,2,1볼 2스트라이크", "3,0,3볼", "0,0,낫싱"})
    void toString_볼_개수와_스트라이크_개수에_맞춰_String으로_정확히_변환되야_한다(int ballCount, int strikeCount,
            String expected) {
        //given
        Results results = new Results(ballCount, strikeCount);

        //when
        String resultString = results.toString();

        //then
        Assertions.assertThat(resultString).isEqualTo(expected);
    }

    @Test
    void is3strike_When3trike_true() {
        //given
        Results results = new Results(0, 3);

        //when
        boolean is3strike = results.is3strike();

        //then
        Assertions.assertThat(is3strike).isTrue();
    }

    @Test
    void is3strike_WhenNot3trike_False() {
        //given
        Results results = new Results(1, 2);

        //when
        boolean is3strike = results.is3strike();

        //then
        Assertions.assertThat(is3strike).isFalse();
    }
}
