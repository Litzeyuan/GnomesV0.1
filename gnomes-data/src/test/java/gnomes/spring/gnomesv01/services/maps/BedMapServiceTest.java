package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Bed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BedMapServiceTest {

    // we can use actual MapService, don't have to use mock here
    BedMapService bedMapService;

    Long id = 1L;
    String name = "A";

    @BeforeEach
    void setUp() {
        bedMapService = new BedMapService();
        bedMapService.save(Bed.builder().id(id).name(name).build());
    }

    @Test
    void findAll() {
        List<Bed> beds = bedMapService.findAll();
        assertEquals(1,beds.size());
    }

    @Test
    void findById() {
        assertEquals(id,bedMapService.findById(id).getId());
    }

    @Test
    void deleteById() {
        bedMapService.deleteById(id);
        assertEquals(0,bedMapService.findAll().size());
    }

    @Test
    void count() {
        Long count = 1L;
        assertEquals(count, bedMapService.count());
    }

    @Test
    void delete() {
        bedMapService.delete(bedMapService.findById(id));
        assertEquals(0, bedMapService.findAll().size());
    }

    @Test
    void save() {
        bedMapService.save(Bed.builder().build());
        assertEquals(2,bedMapService.findAll().size());
    }

    @Test
    void findByName() {
        assertEquals(name,bedMapService.findByName(name).getName());
    }
}