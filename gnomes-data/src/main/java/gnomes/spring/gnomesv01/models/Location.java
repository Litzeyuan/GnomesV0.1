package gnomes.spring.gnomesv01.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Location extends BaseEntity {

    private Long    id;
    private String  name;
    private String  address;
    private Map<String, List<Bed>> areaMap = new HashMap();

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

    public Map<String, List<Bed>> getAreaMap() {
        return areaMap;
    }

    public void setAreaMap(Map<String, List<Bed>> areaMap) {
        this.areaMap = areaMap;
    }

    public int getAreasAmount() {
        return areaMap.size();
    }

    public int getBedsAmount() {
        int beds = 0;
        for (List list :areaMap.values()) {
            beds += list.size();
        }
        return beds;
    }
}
