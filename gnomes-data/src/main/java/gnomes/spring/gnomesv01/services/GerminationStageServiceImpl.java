package gnomes.spring.gnomesv01.services;


import gnomes.spring.gnomesv01.models.GerminationStage;
import gnomes.spring.gnomesv01.repositories.interfaces.StageRepository;
import gnomes.spring.gnomesv01.services.interfaces.GerminationStageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GerminationStageServiceImpl implements GerminationStageService {

    private StageRepository stageRepository;

    //constructor dependency injection
    public GerminationStageServiceImpl(@Qualifier("germinationStageRepository") StageRepository stageRepository){
        this.stageRepository = stageRepository;
    }

    @Override
    public GerminationStage findById(Long id) {
        return null;
    }

    @Override
    public void save(GerminationStage object) {

    }

    @Override
    public void delete(GerminationStage object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public GerminationStage findByName(String name) {
        return null;
    }

    @Override
    public Set<GerminationStage> findAll() {
        return null;
    }
}
