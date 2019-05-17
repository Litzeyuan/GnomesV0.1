package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Bed;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.repositories.CropRepository;
import gnomes.spring.gnomesv01.services.interfaces.BedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Profile({"default","jpaServices"})
public class BedJPAService implements BedService {

    private BedRepository bedRepository;
    private CropRepository cropRepository;

    public BedJPAService(BedRepository bedRepository, CropRepository cropRepository) {
        this.bedRepository = bedRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Optional<Bed> findByName(String name) {
        log.debug("BedJPAService - findByName", name);

        return bedRepository.findByName(name);
    }

    @Override
    public List<Bed> findAll() {
        log.debug("BedJPAService - findAll");

        List<Bed> beds = new ArrayList<>();
        bedRepository.findAll().forEach(beds::add);
        return beds;
    }

    @Override
    public Optional<Bed> findById(Long id) {
        log.debug("BedJPAService - findById", id);

        return bedRepository.findById(id);
    }

    @Override
    public Bed save(Bed bed) {
        log.debug("BedJPAService - save", bed);

        return bedRepository.save(bed);
    }

    @Override
    public void delete(Bed bed) {
        log.debug("BedJPAService - delete", bed);

        bedRepository.delete(bed);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("BedJPAService - deleteById", id);

        bedRepository.deleteById(id);
    }

    @Override
    public Long count() {
        log.debug("BedJPAService - count");

        return bedRepository.count();
    }
}
