package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GerminationStageController {

    @RequestMapping({"/germinationstage", "germinationstage.html"})
    public String germinationstage(){
        //thyme leaf will lookup a template called germinationstage
        return "germinationstage";
    }
}
