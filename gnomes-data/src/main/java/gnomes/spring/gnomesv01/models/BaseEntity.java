package gnomes.spring.gnomesv01.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    // box type Long in Hinernate cannot be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew(){
        return this.id == null;
    }
}
