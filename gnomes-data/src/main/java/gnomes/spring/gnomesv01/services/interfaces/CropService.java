package gnomes.spring.gnomesv01.services.interfaces;


import gnomes.spring.gnomesv01.models.Crop;

import java.util.List;
import java.util.Optional;

public interface CropService extends CRUDService<Crop, Long>{
    Optional<Crop> findByVariety(String variety);
    List<Crop> findAllByNameLike(String name);
    List<Crop> findAllByVarietyLike(String variety);
}
