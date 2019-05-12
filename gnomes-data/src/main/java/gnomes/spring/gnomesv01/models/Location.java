package gnomes.spring.gnomesv01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(exclude="areas")
@Builder
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  address;

    @Column(nullable = true)
    @Nullable
    private int totalBeds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="location")
    private List<Area> areas;

    public Location(){};

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // helper method
    public int getTotalBeds() {
        int beds = 0;
        if(areas != null) {
            for (Area area : areas)
                beds += area.getTotalBeds();
        }
        return beds;
    }

    // helper method
    public void addArea(Area area){
        area.setLocation(this);
        areas.add(area);
    }


}
