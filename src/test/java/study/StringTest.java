package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @Test
    void split1(){
        //given
        String given = "1,2";
        //when
        String[] actual = given.split(",");

        //then
        String[] expected = {"1","2"};
//        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(actual).contains("2","1");
//        Assertions.assertThat(actual).containsExactly("2","1");
    }

    @Test
    void substring(){
        //given
        String given = "(1,2)";
        //when
        String actual = given.substring(1,4);

        //then
        String expected = "1,2";
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("Extract character on specific index using 'charAt'")
    void charAt(){
        //given
        String given = "abc";
        //when
        char actual = given.charAt(1);

        //then
        char expected = 'b';
        Assertions.assertThat(actual).isEqualTo(expected);
        StringIndexOutOfBoundsException siobe = assertThrows(StringIndexOutOfBoundsException.class, () -> given.charAt(4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    @DisplayName("아무것도 없는 문자로 자르면 캐릭터마다 잘리는지")
    void split4(String value){
        //given
        String given = "abc";
        //when

        String[] actual = given.split("");

        //then
        Assertions.assertThat(actual).contains(value);
        System.out.println(Arrays.toString(actual));
    }
}
