package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Crop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CropMapServiceTest {

    // we can use actual MapService, don't have to use mock here
    CropMapService cropMapService;

    Long id = 1L;
    String name = "A";
    String variety = "B";

    @BeforeEach
    void setUp() {
        cropMapService = new CropMapService();
        cropMapService.save(Crop.builder().id(id).name(name).variety(variety).build());
    }

    @Test
    void findAll() {
        List<Crop> crops = cropMapService.findAll();
        assertEquals(1,crops.size());
    }

    @Test
    void findById() {
        assertEquals(id,cropMapService.findById(id).getId());
    }

    @Test
    void deleteById() {
        cropMapService.deleteById(id);
        assertEquals(0,cropMapService.findAll().size());
    }

    @Test
    void count() {
        Long count = 1L;
        assertEquals(count, cropMapService.count());
    }

    @Test
    void delete() {
        cropMapService.delete(cropMapService.findById(id));
        assertEquals(0, cropMapService.findAll().size());
    }

    @Test
    void save() {
        cropMapService.save(Crop.builder().build());
        assertEquals(2,cropMapService.findAll().size());
    }

    @Test
    void findByName() {
        assertEquals(name,cropMapService.findByName(name).getName());
    }

    @Test
    void findByVariety() {
        assertEquals(variety,cropMapService.findByVariety(variety).getVariety());
    }
}