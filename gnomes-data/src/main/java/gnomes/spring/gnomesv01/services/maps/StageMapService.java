package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Stage;
import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("maps")
public class StageMapService extends AbstractMapService<Stage,Long> implements StageService {
    @Override
    public List<Stage> findAll() {
        return super.findAll();
    }

    @Override
    public Stage findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Long count() {
        return super.count();
    }

    @Override
    public void delete(Stage stage) {
        super.delete(stage);
    }

    @Override
    public Stage save(Stage stage) {
        return super.save(stage);
    }

    @Override
    public Stage findByName(String name) {
        return this.findAll()
                .stream()
                .filter(stage -> stage.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
