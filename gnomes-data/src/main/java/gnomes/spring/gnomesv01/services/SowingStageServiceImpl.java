package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.models.SowingStage;
import gnomes.spring.gnomesv01.repositories.interfaces.StageRepository;
import gnomes.spring.gnomesv01.services.interfaces.SowingStageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SowingStageServiceImpl implements SowingStageService {

    private StageRepository stageRepository;

    // constructor dependency injection
    // Qualifier determines which bean to wire
    public SowingStageServiceImpl(@Qualifier("sowingStageRepository") StageRepository stageRepository){
        this.stageRepository = stageRepository;
    }

    @Override
    public SowingStage findById(Long id) {
        return null;
    }

    @Override
    public void save(SowingStage object) {

    }

    @Override
    public void delete(SowingStage object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public SowingStage findByName(String name) {
        return null;
    }

    @Override
    public Set<SowingStage> findAll() {
        return null;
    }
}
