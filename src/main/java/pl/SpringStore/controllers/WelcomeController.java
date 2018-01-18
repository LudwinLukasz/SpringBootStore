package pl.SpringStore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Witaj w naszym sklepie!");
        model.addAttribute("tagline","Drugiego takiego nie znajdziesz!");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            logger.info("Main page entered by user: "+principal.getUsername()
                    +" principal authorities "+principal.getAuthorities() );
            model.addAttribute("login",principal.getUsername());
        }
        return "welcome";
    }
}
