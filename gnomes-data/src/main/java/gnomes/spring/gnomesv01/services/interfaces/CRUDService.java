package gnomes.spring.gnomesv01.services.interfaces;

import java.util.Set;

public interface CRUDService<T,ID> {

    Set<T> findAll();

    T findById(Long id);

    void save(T object);

    void delete(T object);

    void deleteById(Long id);

    int count();
}
