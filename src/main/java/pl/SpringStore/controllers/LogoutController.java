package pl.SpringStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by arabk on 27.10.2017.
 */
@Controller
//@SessionAttributes({"sessionName","sessionIsLogged"})
public class LogoutController {

    @GetMapping("/signout")
//    public String singnOutGet(Model model) {;
//        model.addAttribute("sessionIsLogged", false);
//        return "redirect:/";
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
