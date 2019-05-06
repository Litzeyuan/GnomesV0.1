package gnomes.spring.gnomesv01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Data
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
    private int totalAreas;

    @Column(nullable = true)
    @Nullable
    private int totalBeds;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="location")
    private Set<Area> areas;

    public Location(){};

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // helper method
    public int getTotalBeds() {
        int beds = 0;
        for (Area area :areas)
            beds += area.getTotalBeds();
        return beds;
    }

    // helper method
    public void addArea(Area area){
        area.setLocation(this);
        areas.add(area);
    }


}
