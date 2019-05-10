package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Crop;
import org.springframework.data.repository.CrudRepository;

public interface CropRepository extends CrudRepository<Crop,Long> {
    Crop findByName(String name);
    Crop findByVariety(String variety);
}
