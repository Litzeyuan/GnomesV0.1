package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CropsController {

    private final CropService cropService;

    public CropsController(CropService cropService) {
        this.cropService = cropService;
    }


    @RequestMapping({"/crops", "crops.html"})
    public String crops(Model model){
        //thyme leaf will lookup a template called crops
        model.addAttribute("crops", cropService.findAll());
        return "crops";
    }
}
