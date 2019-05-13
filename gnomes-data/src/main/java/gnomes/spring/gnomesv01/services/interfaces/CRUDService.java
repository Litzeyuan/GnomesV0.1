package gnomes.spring.gnomesv01.services.interfaces;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T,Long> {

    List<T> findAll();

    Optional<T> findById(Long id);

    Optional<T> findByName(String name);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    Long count();
}
