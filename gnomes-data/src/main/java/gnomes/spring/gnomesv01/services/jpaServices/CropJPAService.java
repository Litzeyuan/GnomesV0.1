package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.repositories.CropRepository;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpaServices")
public class CropJPAService implements CropService {

    private CropRepository cropRepository;
    private BedRepository bedRepository;

    public CropJPAService(CropRepository cropRepository, BedRepository bedRepository) {
        this.cropRepository = cropRepository;
        this.bedRepository = bedRepository;
    }

    @Override
    public Optional<Crop> findByFamily(String family) {
        return cropRepository.findByFamily(family);
    }

    @Override
    public Optional<Crop> findByVariety(String variety) {
        return cropRepository.findByVariety(variety);
    }

    @Override
    public Set<Crop> findAll() {
        Set<Crop> crops = new HashSet<>();
        cropRepository.findAll().forEach(crops::add);
        return crops;
    }

    @Override
    public Crop findById(Long id) {
        return  cropRepository.findById(id).orElse(null);
    }

    @Override
    public Crop save(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public void delete(Crop crop) {
        cropRepository.delete(crop);
    }

    @Override
    public void deleteById(Long id) {
        cropRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return cropRepository.count();
    }
}
