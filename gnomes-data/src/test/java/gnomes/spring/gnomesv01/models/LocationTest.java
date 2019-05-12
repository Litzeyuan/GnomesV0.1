package gnomes.spring.gnomesv01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    Location location;

    @BeforeEach
    void setUp() {
        location = new Location();
    }

    @Test
    void getTotalBeds() {
        List<Bed> beds = new ArrayList<>();
        List<Area> areas = new ArrayList<>();
        Area area = Area.builder().beds(beds).build();
        area.addBed(Bed.builder().build());
        area.addBed(Bed.builder().build());
        areas.add(area);
        location.setAreas(areas);
        assertEquals(2, location.getTotalBeds());
    }

    @Test
    void getId() {
        Long id = 1L;
        location.setId(1L);
        assertEquals(id, location.getId());
    }

    @Test
    void getName() {
        String name = "name";
        location.setName(name);
        assertEquals(name, location.getName());
    }

    @Test
    void getAddress() {
        String address = "address";
        location.setAddress(address);
        assertEquals(address, location.getAddress());
    }

    @Test
    void getAreas() {
        List<Area> areas = new ArrayList<>();
        areas.add(Area.builder().build());
        location.setAreas(areas);
        assertEquals(1, location.getAreas().size());
    }

    @Test
     void addArea(){
        List<Area> areas = new ArrayList<>();
        location.setAreas(areas);
        location.addArea(Area.builder().build());
        assertEquals(1, location.getAreas().size());
        assertEquals(location, location.getAreas().get(0).getLocation());
    }
}