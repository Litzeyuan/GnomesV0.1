package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SowingStageController {

    private StageService stageService;

    //constructor dependency injection to wire sowing StageService explicitly
    public SowingStageController(@Qualifier("sowingStageServiceMap") StageService stageService){
        this.stageService = stageService;
    }


}
