package pl.SpringStore.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes({"sessionName","sessionIsLogged"})
public class WelcomeController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Witaj w naszym sklepie!");
        model.addAttribute("tagline","Drugiego takiego nie znajdziesz!");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            String currentUserName = authentication.getName();
            System.out.println("to jest" + currentUserName);
            System.out.println("principal" + principal.getAuthorities());
            System.out.println("principal" + principal.getPassword());
            System.out.println("principal" + principal.getUsername());
            model.addAttribute("imie",principal.getUsername());
        }


        return "welcome";
    }
}
