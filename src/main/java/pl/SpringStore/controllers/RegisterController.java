package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
//import pl.SpringStore.models.UserModel;
import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.models.Users;
//import pl.SpringStore.repositories.UserCRUDRepository;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.RegisterService;

import javax.validation.Valid;

/**
 * Created by arabk on 27.10.2017.
 */

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registerForm") @Valid RegisterForm registerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if(registerService.findByLogin(registerForm).isPresent()) {
            model.addAttribute("info","Taki login istnieje");
            return "register";
        } else {
            registerService.register(registerForm);
            System.out.println("zarejestrowano");
            return "redirect:/";
        }
    }
}
