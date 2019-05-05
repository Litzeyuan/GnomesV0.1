package gnomes.spring.gnomesv01.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "areas")
public class Area extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = true)
    private int totalBeds;

    public Area(){};
    public Area(String name) {
        this.name = name;
    }

    //CascadeType.ALL if deletes an area, will casecade down to delete all beds
    @OneToMany(cascade=CascadeType.ALL, mappedBy="area")
    private Set<Bed> beds;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public void addBed(Bed bed){
        bed.setArea(this);
        this.beds.add(bed);
    }

    public int bedsCount(){
        return beds.size();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTotalBeds() {
        return beds.size();
    }
}
