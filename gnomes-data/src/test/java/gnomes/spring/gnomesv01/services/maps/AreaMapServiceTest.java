package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Area;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreaMapServiceTest {

    // don't have to use mock here, we can use actual MapService
    AreaMapService areaMapService;

    Long id = 1L;
    String name = "A";

    @BeforeEach
    void setUp() {
        areaMapService = new AreaMapService();
        areaMapService.save(Area.builder().id(id).name(name).build());
    }

    @Test
    void findAll() {
        List<Area> areas = areaMapService.findAll();
        assertEquals(1,areas.size());
    }

    @Test
    void findById() {
        assertEquals(id,areaMapService.findById(id).getId());
    }

    @Test
    void deleteById() {
        areaMapService.deleteById(id);
        assertEquals(0, areaMapService.findAll().size());
    }

    @Test
    void count() {
        Long count = 1L;
        assertEquals(count,areaMapService.count());
    }

    @Test
    void delete() {
        areaMapService.delete(areaMapService.findById(id));
        assertEquals(0,areaMapService.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;
        Area areaWithID = Area.builder().id(id).build();
        Area savedArea = areaMapService.save(areaWithID);
        Area areaWithoutID = Area.builder().build();
        Area savedArea2 = areaMapService.save(areaWithoutID);

        assertEquals(id,savedArea.getId());
        assertEquals(areaWithID, savedArea);
        assertEquals(areaWithoutID, savedArea2);

        Long count = 3L;
        assertEquals(count,areaMapService.count());
    }

    @Test
    void findByName() {
        Area area = areaMapService.findByName(name);
        assertNotNull(area);
        assertEquals(id,area.getId());

    }

    @Test
    void findByNameNotExist() {
        Area area = areaMapService.findByName("name2");
        assertNull(area);
    }
}