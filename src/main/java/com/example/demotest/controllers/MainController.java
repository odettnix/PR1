package com.example.demotest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

        @GetMapping("/calculator")
    public String GetMethod(@RequestParam(name="first", defaultValue = "0") double firstNumber,
                            @RequestParam(name="operation", defaultValue = "+") String operation,
                            @RequestParam(name="second", defaultValue = "0") double secondNumber, Model model) {
        double resultGet = 0;
        switch (operation){
            case "+" -> resultGet = firstNumber + secondNumber;
            case "-" -> resultGet = firstNumber - secondNumber;
            case "*" -> resultGet = firstNumber * secondNumber;
            case "/" -> resultGet = firstNumber / secondNumber;
        }

        model.addAttribute("result", resultGet);
        model.addAttribute("first", firstNumber);
        model.addAttribute("operation", operation);
        model.addAttribute("second", secondNumber);
        return "result";
    }

    @PostMapping("/calculator")
    public String PostMethod(@RequestParam(name="first", defaultValue = "0") double firstNumber,
                            @RequestParam(name="operation", defaultValue = "+") String operation,
                            @RequestParam(name="second", defaultValue = "0") double secondNumber, Model model) {
        double resultPost = 0;
        switch (operation){
            case "+" -> resultPost = firstNumber + secondNumber;
            case "-" -> resultPost = firstNumber - secondNumber;
            case "*" -> resultPost = firstNumber * secondNumber;
            case "/" -> resultPost = firstNumber / secondNumber;
        }


        model.addAttribute("first", firstNumber);
        model.addAttribute("operation", operation);
        model.addAttribute("second", secondNumber);
        model.addAttribute("result", resultPost);
        return "result";
    }


}
