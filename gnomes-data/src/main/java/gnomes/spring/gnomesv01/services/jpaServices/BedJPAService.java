package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Bed;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.repositories.CropRepository;
import gnomes.spring.gnomesv01.services.interfaces.BedService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpaServices")
public class BedJPAService implements BedService {
    BedRepository bedRepository;
    CropRepository cropRepository;

    public BedJPAService(BedRepository bedRepository, CropRepository cropRepository) {
        this.bedRepository = bedRepository;
        this.cropRepository = cropRepository;
    }

    @Override
    public Optional<Bed> findByName(String name) {
        return bedRepository.findByName(name);
    }

    @Override
    public Set<Bed> findAll() {
        Set<Bed> beds = new HashSet<>();
        bedRepository.findAll().forEach(beds::add);
        return beds;
    }

    @Override
    public Bed findById(Long id) {
        return bedRepository.findById(id).orElse(null);
    }

    @Override
    public Bed save(Bed bed) {
        return bedRepository.save(bed);
    }

    @Override
    public void delete(Bed bed) {
        bedRepository.delete(bed);
    }

    @Override
    public void deleteById(Long id) {
        bedRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return bedRepository.count();
    }
}
