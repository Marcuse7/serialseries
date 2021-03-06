/**
 * Created by AEr on 13.02.20.
 */


package com.wildcodeschool.serialseries.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TemplateController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";

    }

    @GetMapping("customer")
    public String getCustomer() {
        return "customer";

    }

}
