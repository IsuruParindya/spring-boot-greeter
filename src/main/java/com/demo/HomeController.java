package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // renders home.html
    }

    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "Hello " + name + "!");
        return "home"; // shows the same home.html with the greeting
    }
}