package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StageController {

    @RequestMapping({"/stage", "stage.html"})
    public String getStagePage(){
        //thyme leaf will lookup a template called stage
        return "stage";
    }
}
