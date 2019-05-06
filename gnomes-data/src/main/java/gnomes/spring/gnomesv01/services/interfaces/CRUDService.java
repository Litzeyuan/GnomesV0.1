package gnomes.spring.gnomesv01.services.interfaces;

import java.util.Optional;
import java.util.Set;

public interface CRUDService<T,Long> {

    Set<T> findAll();

    T findById(Long id);

    Optional<T> findByName(String name);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    Long count();
}
