package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.SpringStore.repositories.UsersRepository;
import pl.SpringStore.services.EmailSender;

/**
 * Created by arabk on 27.10.2017.
 */
@Controller
public class EmailController {

    @Autowired
    UsersRepository usersRepository;

    private final EmailSender emailSender;

    @Autowired
    public EmailController(EmailSender emailSender){
        this.emailSender = emailSender;
    }

    @GetMapping("/forgotpassword")
    public String forgotGet(Model model) {
        return "forgotpassword";
    }

    @RequestMapping("/email")
    public String send(@RequestParam("email") String email, Model model) {
        // todo: when password hashing introduced this implementation need to be changed to password reseting
        model.addAttribute("info","twoje hasło zostało wysłane");
        String content = "Twoje hasło to: "+ usersRepository.findByLogin(email).get().getPassword();
         emailSender.sendEmail(email, "Przypomnienie hasła", content);
         return "forgotpassword";
    }
}
