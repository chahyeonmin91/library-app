package com.example.libraryapp.controller.calculator;

import com.example.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.example.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 주어진 class를 controller로 등록
public class CalculatorController {

    @GetMapping("/add")    //GET/add
    //@RequestParam int number2 주어지는 쿼리를 함수 파라미터에 넣음
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") //POST/multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

}
