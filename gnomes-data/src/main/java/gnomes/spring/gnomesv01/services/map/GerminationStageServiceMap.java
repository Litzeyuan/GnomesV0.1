package gnomes.spring.gnomesv01.services.map;

import gnomes.spring.gnomesv01.models.GerminationStage;
import gnomes.spring.gnomesv01.services.interfaces.CRUDService;

import java.util.Set;

public class GerminationStageServiceMap extends AbstractMapService<GerminationStage,Long> implements CRUDService<GerminationStage, Long> {
    @Override
    public Set<GerminationStage> findAll() {
        return super.findAll();
    }

    @Override
    public GerminationStage findById(Long id) {
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
    public void delete(GerminationStage germinationStage) {
        super.delete(germinationStage);
    }

    @Override
    public void save(GerminationStage germinationStage) {
        super.save(germinationStage.getId(), germinationStage);

    }
}
