package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.interfaces.StageRepository;
import gnomes.spring.gnomesv01.interfaces.StageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SowingStageServiceService implements StageService {
    private StageRepository stageRepository;

    public SowingStageServiceService(@Qualifier("sowingStageRepository") StageRepository stageRepository){
        this.stageRepository = stageRepository;
    }

}
