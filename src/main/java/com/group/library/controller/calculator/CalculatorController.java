package com.group.library.controller.calculator;

import com.group.library.dto.request.CalculatorRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int add(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2) {
        return number1 + number2;
    }

    @GetMapping("/addDto")
    public int addDto(CalculatorRequest calculatorAddRequest) {
        return calculatorAddRequest.getNumber1() + calculatorAddRequest.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiply(@RequestBody CalculatorRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
