package gnomes.spring.gnomesv01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationsController {

    @RequestMapping({"/locations", "locations.html"})
    public String locations(){
        //thyme leaf will lookup a template called locations
        return "locations";
    }
}
