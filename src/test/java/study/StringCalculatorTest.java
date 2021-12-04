package study;

import StringCalculator.StringCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    StringCalculator sc;

    @BeforeEach
    void init(){
        sc = new StringCalculator();
    }

    @Test
    @DisplayName("���Ⱑ ����� �۵��ϴ���")
    void calculate(){
        //given
        String expression = "2 + 3 * 4 / 2";

        //when
        String actual = sc.calculate(expression);

        //then
        Assertions.assertThat(actual).isEqualTo("10");
    }
}
