package gnomes.spring.gnomesv01.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(exclude={"stages","beds"})
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "crops")
public class Crop extends BaseEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long    id;
    private String  name;
    private	String  variety;
    private	String sowingType; //Nursery or Direct
    private	String seedVender;
    private	LocalDate seedBoughtDate;
    private	String compostUsed;
    private String currentStage;
    @Lob
    private String notes;

    @Builder
    public Crop(Long id, String name, String variety, String sowingType, String seedVender, LocalDate seedBoughtDate, String compostUsed, String currentStage, String notes, List<Stage> stages, List<Bed> beds) {
//        this.id = id;
        super(id);
        this.name = name;
        this.variety = variety;
        this.sowingType = sowingType;
        this.seedVender = seedVender;
        this.seedBoughtDate = seedBoughtDate;
        this.compostUsed = compostUsed;
        this.currentStage = currentStage;
        this.notes = notes;
        if(stages != null) this.stages = stages;
        if(beds != null) this.beds = beds;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="crop")
    private List<Stage> stages = new ArrayList<>();

    //eager, load all at once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "crop_bed",
            joinColumns = @JoinColumn(name = "crop_id"),
            inverseJoinColumns = @JoinColumn(name = "bed_id"))
    private List<Bed> beds;

    // helper method
    public void addBed(Bed bed){
        this.beds.add(bed);
    }

    // helper method
    public void addStage(Stage stage){
        stage.setCrop(this);
        this.stages.add(stage);
    }

    public Stage getStage(String name){
        return getStage(name, false);
    }

    //overloading helper method
    public Stage getStage(String name, Boolean ignoreNew){
        name = name.toLowerCase();
        for(Stage stage: stages){
            if(!ignoreNew || !stage.isNew()){
                String compName = stage.getName();
                compName = compName.toLowerCase();
                if(compName.equals(name))
                    return stage;
            }
        }
        return null;
    }
}
