package com.stacdc.racgroup.springframework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldAdvisor {

    @ModelAttribute("jsessionId")
    public String jesssionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }

    @ModelAttribute("attribute")
    public String attribute(){
        return "hello attribute";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return ResponseEntity.ok(throwable.getMessage());
    }

}
