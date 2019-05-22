package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.models.Stage;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.util.StringUtils.hasLength;

@Controller
@RequestMapping("/crops/{cropId}")
public class StageController {

    private static final String VIEW_STAGE_FROM = "stages/stageForm";

    private final StageService stageService;
    private final CropService cropService;

    public StageController(StageService stageService, CropService cropService) {
        this.stageService = stageService;
        this.cropService = cropService;
    }

    @InitBinder("crop")
    public void initCropBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("crop")
    public Crop findCrop(@PathVariable("cropId") Long cropId){
        return cropService.findById(cropId).get();
    }

    @GetMapping("/stages/new")
    public String initCreationForm(Crop crop, Model model){
        Stage stage = Stage.builder().build();
        crop.getStages().add(stage);
        model.addAttribute("stage", stage);

        return VIEW_STAGE_FROM;
    }

    @PostMapping("/stages/new")
    public String processCreationForm(Crop crop, @Valid Stage stage, BindingResult result, ModelMap modelMap){
        if(hasLength(stage.getName()) && stage.isNew()
            && crop.getStage(stage.getName(), true) != null)
            result.rejectValue("name", "duplicate", "already exists");

        if(result.hasErrors()) {
            modelMap.put("stage", stage);
            return result.getAllErrors().get(0).toString();
        }
        else {
            stage.setCrop(crop);  //has to be there
            stageService.save(stage);
//            cropService.save(crop);
            return "redirect:/crops/" + crop.getId();
        }
    }

    @GetMapping("/stages/{stageId}/edit")
    public String initEditForm(@PathVariable("stageId") Long stageId, Model model){
        model.addAttribute("stage", stageService.findById(stageId).get());
        return VIEW_STAGE_FROM;

    }

    @PostMapping("/stages/{stageId}/edit")
    public String processEditForm(@PathVariable Long stageId, Crop crop, @Valid Stage stage, BindingResult result, Model model){
        if(result.hasErrors()) {
            stage.setCrop(crop);
            model.addAttribute("stage",stage);
            return result.getAllErrors().get(0).toString();
        }
        else {
            stage.setId(stageId);
            stage.setCrop(crop);
//            cropService.save(crop);
            stageService.save(stage);  // has to be there to save the change
            return "redirect:/crops/" + crop.getId();
        }
    }

}
