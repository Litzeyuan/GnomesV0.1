package gnomes.spring.gnomesv01.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "stages")
public class Stage extends BaseEntity{

    // Common fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isCurrent;
    private LocalDate date;
    private int rowsCount;      // DS and TR
    private int bedLength;      // DS and HV
    private String bedLocation; // TR and HV

    // 1. Sowing stage fields
    private int seedsWeight; //grams
    // Type 1: NS – Nursery
    private String trayType; //e.g. P144, P84
    private int trayUsed;	//related to how many beds to use
    private int seedsPerModule;
    private int modulesCount;
    // Type 2: DS – Direct seed
    //private int rowsCount;
    private String seederType; // plates or roller
    private String rollerType; // used on the seeder (XY24, YYJ24)
    //private int bedLength;

    // 2. Germination stage fields
    // Special case: For courgettes, PT first , then HD
    // Type 1: HD – Hardening off
    // Type 2: PT – Potting on
    private String fromPot;
    private String toPot;
    private int potsQuantities;

    // 3. TR – Transplant Stage
    private int plugsQuantity;
    //private int rowsCount;
    private int rowsSpacing;
    private int	plantsSpacing;
    private String weedControlFabric;
    //private String bedLocation;

    // 4. HV – Harvest stage
    private int harvestWeight;
    //private int	bedLength;
    //private String bedLocation;
    // Special case: Re-harvest for salads
    //Set<LocalDate> harvestDates = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    public Stage(){};
    public Stage(String name) {
        this.name = name;
    }

}
