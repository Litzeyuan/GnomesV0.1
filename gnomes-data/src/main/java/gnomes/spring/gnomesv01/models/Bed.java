package gnomes.spring.gnomesv01.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "beds")
public class Bed extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;
    private String      name;
    @Column(nullable = true)
    @Nullable
    private int         length; //ft
    @Column(nullable = true)
    @Nullable
    private int         width;  //ft
    private String      compost;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToMany(mappedBy = "beds")
    private Set<Crop> crops;

    public Bed(){};
    public Bed(String name) {
        this.name = name;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getCompost() {
        return compost;
    }

    public void setCompost(String compost) {
        this.compost = compost;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Set<Crop> getCrops() {
        return crops;
    }

    public void setCrops(Set<Crop> crops) {
        this.crops = crops;
    }

    public void addCrop(Crop crop){
        this.crops.add(crop);
    }
}
