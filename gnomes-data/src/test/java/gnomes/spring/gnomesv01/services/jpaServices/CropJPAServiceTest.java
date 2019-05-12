package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.repositories.CropRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CropJPAServiceTest {

    @Mock
    CropRepository cropRepository;
    //@Mock
    //BedRepository bedRepository;
    @InjectMocks
    CropJPAService cropJPAService;

    Long id = 1L;
    String name = "A";
    String variety = "B";
    Crop crop;

    @BeforeEach
    void setUp() {
        crop = Crop.builder().id(id).name(name).variety(variety).build();
        cropJPAService.save(crop);
    }

    @Test
    void findByName() {
        when(cropRepository.findByName(any())).thenReturn(crop);
        Crop crop1 = cropRepository.findByName(name);

        assertEquals(crop, crop1);
        assertEquals(name, crop1.getName());
        verify(cropRepository, times(1)).findByName(anyString());
    }

    @Test
    void findByVariety() {
        when(cropRepository.findByVariety(any())).thenReturn(crop);
        Crop crop1 = cropRepository.findByVariety(variety);

        assertEquals(crop, crop1);
        assertEquals(variety, crop1.getVariety());
        verify(cropRepository, times(1)).findByVariety(anyString());
    }

    @Test
    void findAll() {
        ArrayList testCrops = new ArrayList();
        testCrops.add(Crop.builder().build());
        testCrops.add(Crop.builder().build());

        when(cropRepository.findAll()).thenReturn(testCrops);
        assertEquals(2, cropJPAService.findAll().size());
        assertEquals(testCrops, cropJPAService.findAll());
        verify(cropRepository, times(2)).findAll();
    }

    @Test
    void findById() {
        when(cropRepository.findById(anyLong())).thenReturn(Optional.of(crop));
        assertEquals(crop, cropJPAService.findById(id));
        verify(cropRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        when(cropRepository.save(any())).thenReturn(crop);
        assertNotNull(cropJPAService.save(crop));
        verify(cropRepository,times(2)).save(crop);
    }

    @Test
    void delete() {
        cropJPAService.delete(crop);
        assertNull(cropJPAService.findById(id));
        verify(cropRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        cropJPAService.deleteById(id);
        assertNull(cropJPAService.findById(id));
        verify(cropRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void count() {
        cropJPAService.count();
        verify(cropRepository,times(1)).count();
    }
}