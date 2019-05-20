package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Bed;
import gnomes.spring.gnomesv01.repositories.BedRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BedJPAServiceTest {

    @Mock
    BedRepository bedRepository;
    //@Mock
    //CropRepository cropRepository;
    @InjectMocks
    BedJPAService bedJPAService;

    Long id = 1L;
    String name = "name";
    Bed bed;

    @BeforeEach
    void setUp() {
        bed = Bed.builder().id(id).name(name).build();
        bedJPAService.save(bed);
    }

    @Test
    void findByName() {
        when(bedRepository.findByName(any())).thenReturn(Optional.of(bed));
        Bed bed1 = bedRepository.findByName(name).get();

        assertEquals(bed, bed1);
        assertEquals(name, bed1.getName());
        verify(bedRepository, times(1)).findByName(anyString());
    }

    @Test
    void findAll() {
        ArrayList testBeds = new ArrayList();
        testBeds.add(Bed.builder().build());
        testBeds.add(Bed.builder().build());

        when(bedRepository.findAll()).thenReturn(testBeds);
        assertEquals(2, bedJPAService.findAll().size());
        assertEquals(testBeds, bedJPAService.findAll());
        verify(bedRepository, times(2)).findAll();
    }

    @Test
    void findById() {
        when(bedRepository.findById(anyLong())).thenReturn(Optional.of(bed));
        assertEquals(bed, bedJPAService.findById(id).get());
        verify(bedRepository, times(1)).findById(anyLong());
    }

    @Test
    void save() {
        when(bedRepository.save(any())).thenReturn(bed);
        assertNotNull(bedJPAService.save(bed));
        verify(bedRepository,times(2)).save(bed);
    }

    @Test
    void delete() {
        bedJPAService.delete(bed);
        assertThrows(RuntimeException.class,() -> bedJPAService.findById(id));
        verify(bedRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        bedJPAService.deleteById(id);
        assertThrows(RuntimeException.class,() -> bedJPAService.findById(id));
        verify(bedRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void count() {
        bedJPAService.count();
        verify(bedRepository,times(1)).count();
    }
}