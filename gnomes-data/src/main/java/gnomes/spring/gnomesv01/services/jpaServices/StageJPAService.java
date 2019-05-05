package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Stage;
import gnomes.spring.gnomesv01.repositories.StageRepository;
import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpaServices")
public class StageJPAService implements StageService {

    private StageRepository stageRepository;

    public StageJPAService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @Override
    public Optional<Stage> findByName(String name) {
        return stageRepository.findByName(name);
    }

    @Override
    public Set<Stage> findAll() {
        Set<Stage> stages = new HashSet<>();
        stageRepository.findAll().forEach(stages::add);
        return stages;
    }

    @Override
    public Stage findById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    @Override
    public Stage save(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public void delete(Stage stage) {
        stageRepository.delete(stage);
    }

    @Override
    public void deleteById(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return stageRepository.count();
    }
}
