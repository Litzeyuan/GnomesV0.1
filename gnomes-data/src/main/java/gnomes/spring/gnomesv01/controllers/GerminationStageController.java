package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GerminationStageController {

    private StageService stageService;

    //constructor dependency injection to wire germination StageService explicitly
    public GerminationStageController(@Qualifier("germinationStageServiceImpl") StageService stageService){
        this.stageService = stageService;
    }


}
