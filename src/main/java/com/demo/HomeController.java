package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private NameRepository nameRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Name> names = nameRepository.findAll();
        model.addAttribute("names", names);
        return "home";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name, 
                        RedirectAttributes redirectAttributes) {
        // Save name to database
        nameRepository.save(new Name(name));

        // Add greeting message
        redirectAttributes.addFlashAttribute("message", 
            "Hello " + name + "! Your name has been saved!");

        // Redirect back to home
        return "redirect:/";
    }
}