package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StageMapServiceTest {
    // we can use actual MapService, don't have to use mock here
    StageMapService stageMapService;

    Long id = 1L;
    String name = "A";

    @BeforeEach
    void setUp() {
        stageMapService = new StageMapService();
        stageMapService.save(Stage.builder().id(id).name(name).build());
    }

    @Test
    void findAll() {
        List<Stage> beds = stageMapService.findAll();
        assertEquals(1,beds.size());
    }

    @Test
    void findById() {
        assertEquals(id,stageMapService.findById(id).getId());
    }

    @Test
    void deleteById() {
        stageMapService.deleteById(id);
        assertEquals(0,stageMapService.findAll().size());
    }

    @Test
    void count() {
        Long count = 1L;
        assertEquals(count, stageMapService.count());
    }

    @Test
    void delete() {
        stageMapService.delete(stageMapService.findById(id));
        assertEquals(0, stageMapService.findAll().size());
    }

    @Test
    void save() {
        stageMapService.save(Stage.builder().build());
        assertEquals(2,stageMapService.findAll().size());
    }

    @Test
    void findByName() {
        assertEquals(name,stageMapService.findByName(name).getName());
    }
}