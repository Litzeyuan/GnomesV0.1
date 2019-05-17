package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CropsController {

    private final CropService cropService;

    public CropsController(CropService cropService) {
        this.cropService = cropService;
    }


//    @RequestMapping({"/listCrops", "crops.html"})
    @RequestMapping("/listCrops")
    public String listCrops(Model model){
        //thyme leaf will lookup a template called crops
        model.addAttribute("crops", cropService.findAll());
        return "crops";
    }

    // 1st way to show a crop
    @RequestMapping("/listCrops/find/{id}")
    public String findCropsById(@PathVariable String id, Model model){
        model.addAttribute("crop", cropService.findById(new Long(id)).get());
        return "crops/cropDetails";
    }

    // 2nd way to show a crop
    @GetMapping("/listCrops/{cropId}")
    public ModelAndView showCrop(@PathVariable("cropId") Long cropId){
        ModelAndView mv = new ModelAndView("crops/cropDetails");
        mv.addObject(cropService.findById(cropId).get());
        return mv;
    }

    @RequestMapping("/newCrop")
    public String addNewCrop(Model model){
//        model.addAttribute("crop",);
        return "crops/cropform";
    }

    @PostMapping
    @RequestMapping("crop")
    public String saveOrUpdate(){
        return  "redirect:/listCrops/find/" + "";
    }
}
