package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //the path can be either empty or / or /home
    @RequestMapping({"", "/", "/home", "home.html"})
    public String home(){
        //thyme leaf will lookup a template called home
        return "home";
    }
}
