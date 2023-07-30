package org.klozevitz.test_menu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/v1")
public class ViewController {
    @GetMapping("/home")
    public String home() {
        System.out.println("FK OFF");
        return "pages/home";
    }
}
