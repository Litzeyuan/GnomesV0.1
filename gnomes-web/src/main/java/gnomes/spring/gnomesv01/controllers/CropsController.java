package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CropsController {

    private final CropService cropService;

    public CropsController(CropService cropService) {
        this.cropService = cropService;
    }


//    @RequestMapping({"/crops", "crops.html"})
    @RequestMapping("/listCrops")
    public String listCrops(Model model){
        //thyme leaf will lookup a template called crops
        model.addAttribute("crops", cropService.findAll());
        return "crops";
    }

    @RequestMapping("/listCrops/find/{id}")
    public String findCropsById(@PathVariable String id, Model model){
        model.addAttribute("crop", cropService.findById(new Long(id)));
        return "crops/find";
    }
}
