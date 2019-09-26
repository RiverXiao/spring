package com.stacdc.racgroup.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(Model mode, @RequestHeader("Accept-Language") String acceptLanguage){
        mode.addAttribute("message","hello message");
        mode.addAttribute("acceptLanguage",acceptLanguage);
        return "index";
    }

    //也可以在advicer里面执行

//    @ModelAttribute("jsessionId")
//    public String jesssionId(@CookieValue("JSESSIONID") String jsessionId){
//        return jsessionId;
//    }
//
//    @ModelAttribute("attribute")
//    public String attribute(){
//        return "hello attribute";
//    }


}
