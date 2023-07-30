package org.klozevitz.test_menu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class ViewController {
    @GetMapping("/")
    public String home() {
        System.out.println("FK OFF");
        return "pages/home";
    }
}
