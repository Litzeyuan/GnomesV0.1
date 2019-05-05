package gnomes.spring.gnomesv01.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "crops")
public class Crop extends BaseEntity{

    // might not need all those details
    // do we need a crop name ?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  family;//
    private	String  variety;
    @Column(nullable = true)
    @Nullable
    private	int     quantity;
    private	String  sowingType;     // seed or module or direct
    private	String  rowSpacing;     // cm - number or seed or module
    @Column(nullable = true)
    @Nullable
    private	int     plantSpacing;   // cm
    private	String  trayUsed;       // a number or direct
    private	String  sowingPerCell;	// a number or seed or direct
    private	String  composUsed;
    private	String  seedVender;
    private LocalDate seedBoughtDate;
    private LocalDate seedExpiration;
    private String currentStage;
    @Lob
    private String notes;

    public Crop(){};

    public Crop(String family, String variety) {
        this.family = family;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSowingType() {
        return sowingType;
    }

    public void setSowingType(String sowingType) {
        this.sowingType = sowingType;
    }

    public String getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(String rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    public int getPlantSpacing() {
        return plantSpacing;
    }

    public void setPlantSpacing(int plantSpacing) {
        this.plantSpacing = plantSpacing;
    }

    public String getTrayUsed() {
        return trayUsed;
    }

    public void setTrayUsed(String trayUsed) {
        this.trayUsed = trayUsed;
    }

    public String getSowingPerCell() {
        return sowingPerCell;
    }

    public void setSowingPerCell(String sowingPerCell) {
        this.sowingPerCell = sowingPerCell;
    }

    public String getComposUsed() {
        return composUsed;
    }

    public void setComposUsed(String composUsed) {
        this.composUsed = composUsed;
    }

    public String getSeedVender() {
        return seedVender;
    }

    public void setSeedVender(String seedVender) {
        this.seedVender = seedVender;
    }

    public LocalDate getSeedBoughtDate() {
        return seedBoughtDate;
    }

    public void setSeedBoughtDate(LocalDate seedBoughtDate) {
        this.seedBoughtDate = seedBoughtDate;
    }

    public LocalDate getSeedExpiration() {
        return seedExpiration;
    }

    public void setSeedExpiration(LocalDate seedExpiration) {
        this.seedExpiration = seedExpiration;
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public Set<Stage> getStages() {
        return stages;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
    }

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public void addBed(Bed bed){
        this.beds.add(bed);
    }

    public void addStage(Stage stage){
        stage.setCrop(this);
        this.stages.add(stage);
    }
}
