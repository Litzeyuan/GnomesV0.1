package gnomes.spring.gnomesv01.services.interfaces;


import gnomes.spring.gnomesv01.models.Stage;

import java.util.Optional;

public interface StageService extends CRUDService<Stage, Long> {
    Optional<Stage> findByName(String name);
}