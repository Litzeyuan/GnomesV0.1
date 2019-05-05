package gnomes.spring.gnomesv01.services.interfaces;

import java.util.Set;

public interface CRUDService<T,Long> {

    Set<T> findAll();

    T findById(Long id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    Long count();
}
