package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;

import java.util.Set;

public class CropServiceImpl implements CropService {
    @Override
    public Crop findByFamily(String family) {
        return null;
    }

    @Override
    public Crop findByVariety(String variety) {
        return null;
    }

    @Override
    public Set<Crop> findAll() {
        return null;
    }

    @Override
    public Crop findById(Long id) {
        return null;
    }

    @Override
    public void save(Crop object) {

    }

    @Override
    public void delete(Crop object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }
}
