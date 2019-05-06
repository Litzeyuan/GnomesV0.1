package gnomes.spring.gnomesv01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "areas")
public class Area extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(nullable = true)
    private int totalBeds;

    //CascadeType.ALL if deletes an area, will casecade down to delete all beds
    @OneToMany(cascade=CascadeType.ALL, mappedBy="area")
    private Set<Bed> beds;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Area(){};
    public Area(String name) {
        this.name = name;
    }


    // helper method
    public int getTotalBeds() {
        return beds.size();
    }

    // helper method
    public void addBed(Bed bed){
        bed.setArea(this);
        this.beds.add(bed);
    }
}
