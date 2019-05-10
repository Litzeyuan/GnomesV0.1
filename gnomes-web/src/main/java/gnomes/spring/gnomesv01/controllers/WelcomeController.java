package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    //the path can be either empty or / or /home
    @RequestMapping({"", "/", "/welcome", "welcome.html"})
    public String getWelcomePage(){
        //thyme leaf will lookup a template called home
        return "welcome";
    }
}
