package NumberBaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AnswerNumberTest {

    @Test
    public void is3diffrentNumber_3differenNumber_True() throws Exception {
        //reflection
        Method method = AnswerNumber.class.getDeclaredMethod("is3differentNumber", int.class);
        method.setAccessible(true);

        //given
        int num = 579;

        //when
        boolean value = (boolean) method.invoke(AnswerNumber.class, num);

        //then
        assertThat(value).isEqualTo(true);
    }

    @Test
    public void is3diffrentNumber_sameNumber_False() throws Exception {
        //reflection
        Method method = AnswerNumber.class.getDeclaredMethod("is3differentNumber", int.class);
        method.setAccessible(true);

        //given
        int num = 559;

        //when
        boolean value = (boolean) method.invoke(AnswerNumber.class, num);

        //then
        assertThat(value).isEqualTo(false);
    }

    @RepeatedTest(100)
    public void createAnswerNumber_isMoreThan100AndIsLessThan1000() throws Exception {
        //when
        AnswerNumber answerNumber1 = AnswerNumber.createAnswerNumber();

        Field field = answerNumber1.getClass().getDeclaredField("answerNum");
        field.setAccessible(true);
        int answerNum = (int) field.get(answerNumber1);

        //then
        assertThat(answerNum >= 100 && answerNum < 1000).isTrue();
    }

    @RepeatedTest(100)
    public void createAnswerNumber_has3differentNumber() throws Exception {
        //when
        AnswerNumber answerNumber1 = AnswerNumber.createAnswerNumber();

        Field field = answerNumber1.getClass().getDeclaredField("answerNum");
        field.setAccessible(true);
        int answerNum = (int) field.get(answerNumber1);

        Method method = AnswerNumber.class.getDeclaredMethod("is3differentNumber", int.class);
        method.setAccessible(true);

        boolean value = (boolean) method.invoke(AnswerNumber.class, answerNum);

        //then
        assertThat(value).isTrue();
    }
}