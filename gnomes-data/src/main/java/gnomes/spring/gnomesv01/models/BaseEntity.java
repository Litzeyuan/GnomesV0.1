package gnomes.spring.gnomesv01.models;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    // box type Long in Hinernate cannot be null
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
