package baseball;

import baseball.domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultsTest {

    @ParameterizedTest
    @CsvSource({"0,3,3��Ʈ����ũ", "1,2,1�� 2��Ʈ����ũ", "3,0,3��", "0,0,����"})
    void toString_��_������_��Ʈ����ũ_������_����_String����_��Ȯ��_��ȯ�Ǿ�_�Ѵ�(int ballCount, int strikeCount,
            String expected) {
        //given
        Results results = new Results(ballCount, strikeCount);

        //when
        String resultString = results.toString();

        //then
        Assertions.assertThat(resultString).isEqualTo(expected);
    }
}
