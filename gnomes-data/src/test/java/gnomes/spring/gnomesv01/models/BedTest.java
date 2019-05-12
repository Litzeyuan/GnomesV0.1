package gnomes.spring.gnomesv01.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BedTest {

    Bed bed;

    @BeforeEach
    void setUp() {
        bed = new Bed();
    }

    @Test
    void addCrop() {
        List<Crop> crops = new ArrayList<>();
        bed.setCrops(crops);
        bed.addCrop(new Crop());
        assertEquals(1, bed.getCrops().size());
        bed.addCrop(new Crop());
        bed.addCrop(new Crop());
        assertEquals(3, bed.getCrops().size());
    }

    @Test
    void getId() {
        Long id = 4L;
        bed.setId(id);
        assertEquals(id,bed.getId());
    }

    @Test
    void getName() {
        String name = "name";
        bed.setName(name);
        assertEquals(name, bed.getName());
    }

    @Test
    void getCompost() {
        String compost = "compost A";
        bed.setCompost(compost);
        assertEquals(compost,bed.getCompost());
    }

    @Test
    void getLength() {
        int length = 5;
        bed.setLength(length);
        Assertions.assertEquals(length,bed.getLength());
    }

    @Test
    void getWidth() {
        int width = 1;
        bed.setWidth(width);
        assertEquals(width,bed.getWidth());
    }

    @Test
    void getArea() {
        Area area = new Area("A");
        bed.setArea(area);
        assertEquals(area.getName(), bed.getArea().getName());
    }

    @Test
    void getCrops() {
        List<Crop> crops = new ArrayList<>();
        bed.setCrops(crops);
        assertEquals(crops, bed.getCrops());
    }
}