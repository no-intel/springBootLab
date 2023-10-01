package com.lab.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class InputFilter {
    private final String REGEXP_PATTERN_NUMBER = "^[0-9]$";

    public int inputCheck(String input){
        if(input.matches(REGEXP_PATTERN_NUMBER)){
            return Integer.parseInt(input);
        }else {
            throw new IllegalArgumentException("숫자만 입력가능. InputParam : " + input);
        }
    }
}
