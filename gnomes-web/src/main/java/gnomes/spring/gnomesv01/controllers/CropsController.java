package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CropsController {

    private final CropService cropService;

    public CropsController(CropService cropService) {
        this.cropService = cropService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

//    @RequestMapping({"/listCrops", "crops.html"})
    @RequestMapping("/listCrops")
    public String listCrops(Model model){
        //thyme leaf will lookup a template called crops
        model.addAttribute("crops", cropService.findAll());
        return "crops";
    }


    @GetMapping("/listCrops/{cropId}")
    public ModelAndView showCrop(@PathVariable("cropId") Long cropId){

        ModelAndView mv = new ModelAndView("crops/cropDetails");
        mv.addObject(cropService.findById(cropId).get());

        // 2nd way to show a crop, pass in Model and id, then return template name
        //model.addAttribute("crop", cropService.findById(new Long(id)).get());
        //return "crops/cropDetails";

        return mv;
    }

    @RequestMapping("/crops/find")
    public String findCrops(Model model){
        model.addAttribute("crop", Crop.builder().build());
        return "crops/findCrops";
    }

    @GetMapping("/crops")
    public String processFindForm(Crop crop, BindingResult result, Model model){
        //empty string signifies broadest possible search
        if(crop.getName() == null)
            crop.setName("");

        //find by name
        List<Crop> results = cropService.findAllByNameLike("%" + crop.getName() + "%");
        if(results.isEmpty()){
            result.rejectValue("name", "notFound", "not found");
            return "crops/findCrops";
        }
        //else if(results.size() == 1)
        //    return  "redirect:/listCrops/" + results.get(0).getId();
        else {
            model.addAttribute("results", results);
            return "crops/findCrops";
        }
    }

    @RequestMapping("/newCrop")
    public String addNewCrop(Model model){
//        model.addAttribute("crop",);
        return "cropForm";
    }

    @PostMapping
    @RequestMapping("crop")
    public String saveOrUpdate(){
        return  "redirect:/listCrops/find/" + "";
    }
}
