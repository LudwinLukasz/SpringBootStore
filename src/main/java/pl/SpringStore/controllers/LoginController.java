package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.SpringStore.forms.LoginForm;
import pl.SpringStore.repositories.UserCRUDRepository;

import javax.validation.Valid;

/**
 * Created by arabk on 26.10.2017.
 */
@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class LoginController {

    @Autowired
    UserCRUDRepository userCRUDRepository;

    @GetMapping("/signin")
    public String singnInGet(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "signin";
    }

    @PostMapping("/signin")
    public String signInPost(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "signin";
        }

        if(userCRUDRepository.findByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword()).size() > 0) {
            System.out.println("dobry login");
            String sessionName = (userCRUDRepository.findByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword()).get(0)).getName();
            model.addAttribute("sessionName",sessionName);
            model.addAttribute("sessionIsLogged", true);
            return "redirect:/";
        } else if (userCRUDRepository.findOneByLogin(loginForm.getLogin()) != null) {
            model.addAttribute("wrong","Wrong Password");
            System.out.println("złe hasło dla "+userCRUDRepository.findOneByLogin(loginForm.getLogin()));
            return "signin";
        } else {
            model.addAttribute("wrong","Taki login nie istnieje");
            System.out.println("nie ma takiego loginu");
            return "signin";
        }

    }


}
