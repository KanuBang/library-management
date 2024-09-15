package com.group.library.controller.calculator;

import com.group.library.dto.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int add(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2) {
        return number1 + number2;
    }

    @GetMapping("/addDto")
    public int addDto(CalculatorAddRequest calculatorAddRequest) {
        return calculatorAddRequest.getNumber1() + calculatorAddRequest.getNumber2();
    }
}
