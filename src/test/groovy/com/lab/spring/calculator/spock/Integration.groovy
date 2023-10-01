package com.lab.spring.calculator.spock

import com.lab.spring.calculator.Calculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class Integration extends Specification{
    @Autowired
    private Calculator calculator

    def "필터 예외 테스트"(){
        given:
        String a = "1"
        String b = "a"

        when:
        calculator.add(a, b)

        then:
        thrown(IllegalArgumentException.class)
    }

    def "덧셈 테스트"(){
        given:
        def a = "1"
        def b = "2"

        when:
        def add = calculator.add(a, b)

        then:
        add == 3
    }

    def "뺄셈 테스트"(){
        given:
        def a = "1"
        def b = "2"

        when:
        int sub = calculator.sub(a, b)

        then:
        sub == -1
    }

    def "나누기 테스트"(){
        given:
        def a = "5"
        def b = "2"

        when:
        def divide = calculator.divide(a, b)

        then:
        divide == 2
    }

    def "나누기 예외 테스트. 0 나누기"(){
        given:
        def a = "5"
        def b = "0"

        when:
        calculator.divide(a, b)

        then:
        thrown(ArithmeticException.class)
    }

    def "곱셈 테스트"(){
        given:
        def a = "5"
        def b = "2"

        when:
        def multiple = calculator.multiple(a, b)

        then:
        multiple == 10
    }
}
