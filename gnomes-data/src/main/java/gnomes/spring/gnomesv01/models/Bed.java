package gnomes.spring.gnomesv01.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(exclude={"area","crops"})
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beds")
public class Bed extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;
    private String      name;
    private String      compost;

    @Column(nullable = true)
    @Nullable
    private int         length; //ft

    @Column(nullable = true)
    @Nullable
    private int         width;  //ft


    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToMany(mappedBy = "beds")
    private List<Crop> crops;

    @Builder
    public Bed(Long id, String name) {
        super(id);
        this.name = name;
    }

    // helper method
    public void addCrop(Crop crop){
        this.crops.add(crop);
    }
}
