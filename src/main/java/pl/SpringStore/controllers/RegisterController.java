package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.SpringStore.models.UserModel;
import pl.SpringStore.forms.RegisterForm;
import pl.SpringStore.repositories.UserCRUDRepository;

import javax.validation.Valid;

/**
 * Created by arabk on 27.10.2017.
 */

@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class RegisterController {

    @Autowired
    UserCRUDRepository userCRUDRepository;

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
        model.addAttribute("sessionName", registerForm.getName());
        model.addAttribute("sessionIsLogged", true);

        if(userCRUDRepository.findByLogin(registerForm.getLogin()).size() > 0) {
           model.addAttribute("info","Taki login istnieje");
            return "register";
        } else {
            userCRUDRepository.save(new UserModel(registerForm));
            System.out.println("zarejestrowano");
            return "redirect:/";
        }

    }

}
