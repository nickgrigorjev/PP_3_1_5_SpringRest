package com.nsgrigorjev.PP_3_1_5_SpringRest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

}
