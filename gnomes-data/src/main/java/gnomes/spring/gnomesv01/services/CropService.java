package gnomes.spring.gnomesv01.services;


import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.models.CropImpl;

public interface CropService extends CRUDService<Crop, Long>{

    CropImpl findByFamily(String family);

    CropImpl findByVariety(String variety);

}
