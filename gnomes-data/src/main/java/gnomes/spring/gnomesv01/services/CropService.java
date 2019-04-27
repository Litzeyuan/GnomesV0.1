package gnomes.spring.gnomesv01.services;


import gnomes.spring.gnomesv01.models.CropImpl;

import java.util.Set;

public interface CropService {

    CropImpl findById(long id);

    CropImpl findByFamily(String family);

    CropImpl findByVariety(String variety);

    CropImpl save(long id);

    Set<CropImpl> findByAll(long id);


}
