package com.lab.spring.calculator.spock


import spock.lang.Specification
import com.lab.spring.calculator.Calculator

class Unit extends Specification {
    def calculator = new Calculator(new DummyInputFilter())

    def inputFilter = new com.lab.spring.calculator.InputFilter()

    def "필터 테스트"() {
        given:
        def a = "1"

        when:
        def num = inputFilter.inputCheck(a)

        then:
        num == Integer.parseInt(a)
    }

    def "필터 예외 테스트"(){
        given:
        def a = "ㅁ"

        when:
        inputFilter.inputCheck(a)

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

    public static class DummyInputFilter extends com.lab.spring.calculator.InputFilter{
        @Override
        public int inputCheck(String input) {
            return Integer.parseInt(input)
        }
    }
}
