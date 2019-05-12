package gnomes.spring.gnomesv01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CropTest {

    Crop crop;

    @BeforeEach
    void setUp() {
        crop = new Crop();
    }

    @Test
    void addBed() {
        List<Bed> beds = new ArrayList<>();
        crop.setBeds(beds);
        crop.addBed(Bed.builder().build());
        assertEquals(false, crop.getBeds().isEmpty());
        assertEquals(1,crop.getBeds().size());
    }

    @Test
    void addStage() {
        List<Stage> stages = new ArrayList<>();
        crop.setStages(stages);
        crop.addStage(Stage.builder().build());
        assertEquals(false,crop.getStages().isEmpty());
        assertEquals(1,crop.getStages().size());
    }

    @Test
    void getId() {
        Long id = 4L;
        crop.setId(id);
        assertEquals(id,crop.getId());
    }

    @Test
    void getName() {
        String name = "A";
        crop.setName(name);
        assertEquals(name,crop.getName());
    }

    @Test
    void getVariety() {
        String variety = "B";
        crop.setVariety(variety);
        assertEquals(variety,crop.getVariety());
    }

    @Test
    void getSowingType() {
        String type = "direct";
        crop.setSowingType(type);
        assertEquals(type,crop.getSowingType());
    }

    @Test
    void getSeedVender() {
        String vender = "vender";
        crop.setSeedVender(vender);
        assertEquals(vender,crop.getSeedVender());
    }

    @Test
    void getSeedBoughtDate() {
        LocalDate date = LocalDate.of(2019,1,1);
        crop.setSeedBoughtDate(date);
        assertEquals(date,crop.getSeedBoughtDate());
    }

    @Test
    void getCompostUsed() {
        String compost = "compost";
        crop.setCompostUsed(compost);
        assertEquals(compost,crop.getCompostUsed());
    }

    @Test
    void getCurrentStage() {
        String stage = "stageA";
        crop.setCurrentStage(stage);
        assertEquals(stage, crop.getCurrentStage());
    }

    @Test
    void getNotes() {
        String notes = "notes";
        crop.setNotes(notes);
        assertEquals(notes,crop.getNotes());
    }

    @Test
    void getStages() {
        List<Stage> stages = new ArrayList<>();
        crop.setStages(stages);
        crop.addStage(Stage.builder().build());
        assertEquals(false,crop.getStages().isEmpty());
        assertEquals(1,crop.getStages().size());
    }

    @Test
    void getBeds() {
        List<Bed> beds = new ArrayList<>();
        crop.setBeds(beds);
        crop.addBed(Bed.builder().build());
        assertEquals(false, crop.getBeds().isEmpty());
        assertEquals(1,crop.getBeds().size());
    }
}