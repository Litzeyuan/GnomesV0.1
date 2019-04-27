package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "/", "home", "home.html"})
    public String index(){
        //thyme leaf will lookup a template called index
        return "home";
    }
}
