package gnomes.spring.gnomesv01.services.interfaces;

import gnomes.spring.gnomesv01.models.Bed;

import java.util.Optional;

public interface BedService extends CRUDService<Bed, Long> {
    Optional<Bed> findByName(String name);
}
