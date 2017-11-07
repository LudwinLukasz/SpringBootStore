package pl.SpringStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.SpringStore.repositories.UserCRUDRepository;
import pl.SpringStore.services.EmailSender;

/**
 * Created by arabk on 27.10.2017.
 */
@Controller
public class EmailController {

    @Autowired
    UserCRUDRepository userCRUDRepository;

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
        model.addAttribute("info","twoje hasło zostało wysłane");
        String content = "Twoje hasło to: "+ userCRUDRepository.findByLogin(email).get(0).getPassword();
         emailSender.sendEmail(email, "Przypomnienie hasła", content);
         return "forgotpassword";
    }

}
