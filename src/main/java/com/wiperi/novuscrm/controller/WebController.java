package com.wiperi.novuscrm.controller;

import com.wiperi.novuscrm.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}