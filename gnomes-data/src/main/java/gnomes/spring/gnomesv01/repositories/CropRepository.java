package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Crop;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CropRepository extends CrudRepository<Crop,Long> {
    Optional<Crop> findByName(String name);
    Optional<Crop> findByVariety(String variety);
}
