package com.lab.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final InputFilter inputFilter;

    public Calculator(InputFilter inputFilter) {
        this.inputFilter = inputFilter;
    }

    public int add(String a, String b) {
        int num1 = this.parseInt(a);
        int num2 = this.parseInt(b);
        return num1 + num2;
    }

    public int sub(String a, String b){
        int num1 = this.parseInt(a);
        int num2 = this.parseInt(b);
        return num1 - num2;
    }

    public int divide(String a, String b){
        int num1 = this.parseInt(a);
        int num2 = this.parseInt(b);
        return num1 / num2;
    }

    public int multiple(String a, String b) {
        int num1 = this.parseInt(a);
        int num2 = this.parseInt(b);
        return num1 * num2;
    }

    private int parseInt(String a){
        return inputFilter.inputCheck(a);
    }
}
