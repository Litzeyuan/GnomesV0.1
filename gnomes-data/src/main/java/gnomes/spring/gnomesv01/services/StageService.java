package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.models.Stage;

public interface StageService extends CRUDService<Stage,Long> {

    Stage findByName(String name);
}