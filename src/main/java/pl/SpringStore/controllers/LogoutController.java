package pl.SpringStore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by arabk on 27.10.2017.
 */
@Controller
public class LogoutController {

    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);

    @GetMapping("/signout")
    public String logout(HttpSession session) {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        logger.info("User "+ principal.getUsername()+
                " is signing out. Details: " + SecurityContextHolder.getContext().getAuthentication());

        session.invalidate();
        return "redirect:/";
    }
}

