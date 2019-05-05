package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(Long id){
      return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null)
                object.setId(getNextId());

            map.put(object.getId(), object);
        } else
            throw new RuntimeException("Object cannot be null");

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(
                idtEntry -> idtEntry.getValue().equals(object)
        );
    }

    Long count(){
        return Long.valueOf(map.size());
    }

    private Long getNextId(){
        Long id = null;

        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            id = 1L;
        }

        return id;
    }

}
