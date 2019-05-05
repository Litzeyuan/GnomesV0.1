package gnomes.spring.gnomesv01.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Area> getAreas() {
        return areas;
    }

    public void setAreas(Set<Area> areas) {
        this.areas = areas;
    }

    public int getTotalAreas() {
        return areas.size();
    }

    public int getTotalBeds() {
        int beds = 0;
        for (Area area :areas)
            beds += area.bedsCount();

        return beds;
    }

    public void addArea(Area area){
        area.setLocation(this);
        areas.add(area);
    }
}
