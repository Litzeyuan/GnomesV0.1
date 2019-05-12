package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationMapServiceTest {

    // we can use actual MapService, don't have to use mock here
    LocationMapService locationMapService;

    Long id = 1L;
    String name = "A";

    @BeforeEach
    void setUp() {
        locationMapService = new LocationMapService();
        locationMapService.save(Location.builder().id(id).name(name).build());
    }

    @Test
    void findAll() {
        List<Location> beds = locationMapService.findAll();
        assertEquals(1,beds.size());
    }

    @Test
    void findById() {
        assertEquals(id,locationMapService.findById(id).getId());
    }

    @Test
    void deleteById() {
        locationMapService.deleteById(id);
        assertEquals(0,locationMapService.findAll().size());
    }

    @Test
    void count() {
        Long count = 1L;
        assertEquals(count, locationMapService.count());
    }

    @Test
    void delete() {
        locationMapService.delete(locationMapService.findById(id));
        assertEquals(0, locationMapService.findAll().size());
    }

    @Test
    void save() {
        locationMapService.save(Location.builder().build());
        assertEquals(2,locationMapService.findAll().size());
    }

    @Test
    void findByName() {
        assertEquals(name,locationMapService.findByName(name).getName());
    }
}