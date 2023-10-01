package com.lab.spring.calculator.junit;

import com.lab.spring.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Integration {
    @Autowired
    private Calculator calculator;

    @Test
    @DisplayName("필터 예외 테스트")
    public void filterException(){
        // given
        String a = "1";
        String b = "a";

        // when, then
        assertThrows(IllegalArgumentException.class, ()-> calculator.add(a, b));
    }

    @Test
    @DisplayName("덧셈 테스트")
    public void addTest(){
        // given
        String a = "1";
        String b = "2";

        // when
        int add = calculator.add(a, b);

        // then
        assertEquals(add, 3);
    }
    @Test
    @DisplayName("뺄셈 테스트")
    public void subTest(){
        // given
        String a = "1";
        String b = "2";

        // when
        int sub = calculator.sub(a, b);

        // then
        assertEquals(sub, -1);
    }

    @Test
    @DisplayName("나누기 테스트")
    public void divideTest(){
        // given
        String a = "5";
        String b = "2";

        // when
        int divide = calculator.divide(a, b);

        // then
        assertEquals(divide, 2);
    }
    @Test
    @DisplayName("나누기 예외 테스트. 0 나누기")
    public void divideTestException(){
        // given
        String a = "5";
        String b = "0";

        // when & then
        assertThrows(ArithmeticException.class, ()-> calculator.divide(a, b));
    }
    @Test
    @DisplayName("곱셈 테스트")
    public void multipleTest(){
        // given
        String a = "5";
        String b = "2";

        // when
        int multiple = calculator.multiple(a, b);

        // then
        assertEquals(multiple, 10);
    }
}
