package NumberBaseballGame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberHandlerTest {

    @Test
    public void seperateNumberByNumberPlace_WhenInput365_OuntputIsArraysOf3And6And5()
            throws Exception {
        //given
        int num = 365;

        //when
        Integer[] integers = NumberHandler.seperateNumberByNumberPlace(365);

        //then
        assertThat(integers).isEqualTo(new Integer[]{3, 6, 5});
    }

    @Test
    public void isValidate_WhenInRightRange_True() throws Exception {
        //given
        int num = 356;

        //when
        boolean isValidate = NumberHandler.isValidate(num);

        //then
        assertThat(isValidate).isTrue();
    }

    @Test
    public void isValidate_WhenOverRange_False() throws Exception {
        //given
        int num = 1203;

        //when
        boolean isValidate = NumberHandler.isValidate(num);

        //then
        assertThat(isValidate).isFalse();
    }

    @Test
    public void isValidate_WhenHasDuplicateNumber_False() throws Exception {
        //given
        int num = 355;

        //when
        boolean isValidate = NumberHandler.isValidate(num);

        //then
        assertThat(isValidate).isFalse();
    }

    @Test
    public void isValidate_WhenNotHaveDuplicateNumber_True() throws Exception {
        //given
        int num = 365;

        //when
        boolean isValidate = NumberHandler.isValidate(num);

        //then
        assertThat(isValidate).isTrue();
    }
}