package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/crops")
@Controller
public class CropsController {

    private static final String VIEW_CROP_FROM = "crops/cropForm";

    private final CropService cropService;


    public CropsController(CropService cropService) {
        this.cropService = cropService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/all")
    public String listCrops(Model model){
        //thyme leaf will lookup a template called crops
        model.addAttribute("crops", cropService.findAll());
        return "crops";
    }


    @GetMapping("/{cropId}")
    public ModelAndView showCrop(@PathVariable Long cropId){

        ModelAndView mv = new ModelAndView("crops/cropDetails");
        mv.addObject(cropService.findById(cropId).get());

        // 2nd way to show a crop, pass in Model and id, then return template name
        //model.addAttribute("crop", cropService.findById(new Long(id)).get());
        //return "crops/cropDetails";

        return mv;
    }

    @RequestMapping("/find")
    public String findCrops(Model model){
        model.addAttribute("crop", Crop.builder().build());
        return "crops/findCrops";
    }

    @GetMapping
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
        else {
            model.addAttribute("results", results);
            return "crops/findCrops";
        }
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("crop",Crop.builder().build());
        return VIEW_CROP_FROM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Crop crop, BindingResult result){
        if(result.hasErrors())
            return result.getAllErrors().get(0).toString();
        else
            return "redirect:/crops/" + cropService.save(crop).getId();

    }

    @GetMapping("/{cropId}/edit")
    public String initEditForm(@PathVariable("cropId") Long cropId, Model model){
        model.addAttribute("crop", cropService.findById(cropId).get());
        return VIEW_CROP_FROM;

    }

    @PostMapping("/{cropId}/edit")
    public String processEditForm(@Valid Crop crop, BindingResult result, @PathVariable("cropId") Long cropId){

        if(result.hasErrors())
            return result.getAllErrors().get(0).toString();
        else {
            crop.setId(cropId);
            Crop savedCrop = cropService.save(crop);
            return "redirect:/crops/" + savedCrop.getId();
        }
    }


}
