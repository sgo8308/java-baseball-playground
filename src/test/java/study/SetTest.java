package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size(){
        //given
        //when
        //then
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains(){
        //given
        //when
        //then
        for (int i = 1; i < 4; i++) {
            Assertions.assertThat(numbers.contains(i)).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsDevelop(int number){
        //given
        //when
        //then
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsExact(int number, boolean expected){
        //given
        //when
        //then
        Assertions.assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
