package pl.SpringStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class WelcomeController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Witaj w naszym sklepie!");
        model.addAttribute("tagline","Drugiego takiego nie znajdziesz!");

        return "welcome";
    }
}
