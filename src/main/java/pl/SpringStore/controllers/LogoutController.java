package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.SpringStore.models.repositories.Cart;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by arabk on 27.10.2017.
 */
@Controller
//@SessionAttributes({"sessionName","sessionIsLogged"})
public class LogoutController {

    @Autowired
    Cart cart;

    @GetMapping("/signout")
//    public String singnOutGet(Model model) {;
//        model.addAttribute("sessionIsLogged", false);
//        return "redirect:/";
    public String logout(HttpSession session) {
        //cart.orderProd = Arrays.asList("dsdcdascac");
        cart.orderProd.clear();
        // System.out.println(cart.orderProd);
        session.invalidate();
        return "redirect:/";
    }
}
