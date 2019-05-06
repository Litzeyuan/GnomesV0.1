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
    private Set<Crop> crops;

    public Bed(){};
    public Bed(String name) {
        this.name = name;
    }

    // helper method
    public void addCrop(Crop crop){
        this.crops.add(crop);
    }
}
