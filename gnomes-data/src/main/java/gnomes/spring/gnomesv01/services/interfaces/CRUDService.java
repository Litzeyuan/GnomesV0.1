package gnomes.spring.gnomesv01.services.interfaces;

import java.util.List;

public interface CRUDService<T,Long> {

    List<T> findAll();

    T findById(Long id);

    T findByName(String name);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

    Long count();
}
