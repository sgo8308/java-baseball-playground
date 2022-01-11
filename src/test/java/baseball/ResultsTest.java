package baseball;

import baseball.domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultsTest {

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
}
