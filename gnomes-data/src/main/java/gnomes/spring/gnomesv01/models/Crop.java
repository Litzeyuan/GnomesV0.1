package gnomes.spring.gnomesv01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "crops")
public class Crop extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private	String  variety;
    private	String sowingType; //Nursery or Direct
    private	String seedVender;
    private	LocalDate seedBoughtDate;
    private	String compostUsed;
    private String currentStage;
    @Lob
    private String notes;

    public Crop(){};

    public Crop(String name, String variety) {
        this.name = name;
        this.variety = variety;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="crop")
    private Set<Stage> stages;

    //eager, load all at once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "crop_bed",
            joinColumns = @JoinColumn(name = "crop_id"),
            inverseJoinColumns = @JoinColumn(name = "bed_id"))
    private Set<Bed> beds;

    // helper method
    public void addBed(Bed bed){
        this.beds.add(bed);
    }

    // helper method
    public void addStage(Stage stage){
        stage.setCrop(this);
        this.stages.add(stage);
    }
}
