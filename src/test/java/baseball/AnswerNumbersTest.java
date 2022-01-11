package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.AnswerNumbers;
import baseball.utils.ValidationUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

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

    void setAnswerNumbersList() throws Exception {
        Field field = answerNumbers.getClass().getDeclaredField("numbers");
        field.setAccessible(true);
        answerNumbersList = (List<Integer>) field.get(answerNumbers);
    }
}
