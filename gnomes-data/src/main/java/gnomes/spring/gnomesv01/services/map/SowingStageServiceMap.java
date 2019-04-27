package gnomes.spring.gnomesv01.services.map;

import gnomes.spring.gnomesv01.models.SowingStage;
import gnomes.spring.gnomesv01.services.interfaces.CRUDService;

import java.util.Set;

public class SowingStageServiceMap extends AbstractMapService<SowingStage, Long>  implements CRUDService<SowingStage, Long> {
    @Override
    public Set<SowingStage> findAll() {
        return super.findAll();
    }

    @Override
    public SowingStage findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public void delete(SowingStage sowingStage) {
        super.delete(sowingStage);
    }

    @Override
    public void save(SowingStage sowingStage) {
        super.save(sowingStage.getId(), sowingStage);
    }
}
