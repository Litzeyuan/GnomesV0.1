package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.interfaces.StageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GerminationStageController {

    private StageService stageService;

    //constructor dependency injection
    public GerminationStageController(@Qualifier("germinationStageServiceService") StageService stageService){
        this.stageService = stageService;
    }


}
