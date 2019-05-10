package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.repositories.CropRepository;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Profile({"default","jpaServices"})
public class CropJPAService implements CropService {

    private CropRepository cropRepository;
    private BedRepository bedRepository;

    public CropJPAService(CropRepository cropRepository, BedRepository bedRepository) {
        this.cropRepository = cropRepository;
        this.bedRepository = bedRepository;
    }

    @Override
    public Crop findByName(String name) {
        return cropRepository.findByName(name);
    }

    @Override
    public Crop findByVariety(String variety) {
        return cropRepository.findByVariety(variety);
    }

    @Override
    public List<Crop> findAll() {
        List<Crop> crops = new ArrayList<>();
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
