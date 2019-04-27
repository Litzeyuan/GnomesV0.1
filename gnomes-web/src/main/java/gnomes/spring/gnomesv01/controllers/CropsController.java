package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CropsController {

    @RequestMapping({"/crops", "crops.html"})
    public String crops(){
        //thyme leaf will lookup a template called crops
        return "crops";
    }
}
