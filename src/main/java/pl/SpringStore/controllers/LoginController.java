package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.SpringStore.forms.LoginForm;
//import pl.SpringStore.repositories.UserCRUDRepository;

import javax.validation.Valid;

/**
 * Created by arabk on 26.10.2017.
 */
@Controller
public class LoginController {

    @GetMapping("/signin")
    public String singnInGet(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "signin";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "login";
    }
}
