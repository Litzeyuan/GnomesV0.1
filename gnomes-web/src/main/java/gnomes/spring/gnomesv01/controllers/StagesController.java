package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StagesController {

    @RequestMapping({"/stages", "stages.html"})
    public String stages(){
        //thyme leaf will lookup a template called beds
        return "stages";
    }
}
