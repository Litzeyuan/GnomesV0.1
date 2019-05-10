package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BedsController {

    @RequestMapping("/listBeds")
    public String listBeds(){
        //thyme leaf will lookup a template called beds
        return "beds";
    }
}
