package gnomes.spring.gnomesv01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AreaTest {

    Area area;

    @BeforeEach
    void setUp(){
        area = new Area();
    }

    @Test
    void getId() {
        Long id = 4L;
        area.setId(id);
        assertEquals(id, area.getId());
    }

    @Test
    void getName() {
        String name = "A";
        area.setName(name);
        assertEquals(name,area.getName());
    }

    @Test
    void getBeds() {
        List<Bed> beds = new ArrayList<>();
        area.setBeds(beds);
        assertEquals(beds, area.getBeds());
    }

    @Test
    void getLocation() {
        Location location = new Location();
        area.setLocation(location);
        assertEquals(location,area.getLocation());
    }

    @Test
    public void getTotalBeds() {
        List<Bed> beds = new ArrayList<>();
        area.setBeds(beds);
        area.addBed(new Bed());
        area.addBed(new Bed());
        assertEquals(2, area.getBeds().size());
        area.addBed(new Bed());
        area.addBed(new Bed());
        assertEquals(4, area.getBeds().size());
    }

    @Test
    public void addBed(){
        Bed bed = new Bed();
        List<Bed> beds = new ArrayList<>();
        area.setBeds(beds);
        area.addBed(bed);
        assertEquals(false, area.getBeds().isEmpty());
        assertEquals(1,area.getBeds().size());
        assertEquals(area, bed.getArea());
    }
}