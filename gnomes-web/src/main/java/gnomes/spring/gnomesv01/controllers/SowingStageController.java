package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SowingStageController {

    @RequestMapping({"/sowingstage", "sowingstage.html"})
    public String sowingstage(){
        //thyme leaf will lookup a template called index
        return "sowingstage";
    }
}
