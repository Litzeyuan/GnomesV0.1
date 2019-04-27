package gnomes.spring.gnomesv01.services.interfaces;


public interface StageService<T, ID> extends CRUDService<T, ID> {
    T findByName(String name);
}