package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Area;
import gnomes.spring.gnomesv01.repositories.AreaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AreaJPAServiceTest {

    @Mock
    AreaRepository areaRepository;

    @InjectMocks
    AreaJPAService areaJPAService;

    Long id = 1L;
    String name = "name";
    Area area;

    @BeforeEach
    void setUp() {
        area = Area.builder().id(id).name(name).build();
        areaJPAService.save(area);
    }

    @Test
    void findByName() {
        when(areaRepository.findByName(any())).thenReturn(Optional.of(area));
        Area area1 = areaJPAService.findByName(name).get();

        assertEquals(area, area1);
        assertEquals(name, area1.getName());
        verify(areaRepository,times(1)).findByName(name);
        verify(areaRepository).findByName(any());
    }

    @Test
    void findAll() {
        ArrayList testAreas = new ArrayList();
        testAreas.add(new Area());//or use builder
        testAreas.add(new Area());

        when(areaRepository.findAll()).thenReturn(testAreas);
        List<Area> areas = areaJPAService.findAll();

        assertEquals(2,areas.size());
        assertEquals(testAreas,areas);
        verify(areaRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(areaRepository.findById(anyLong())).thenReturn(Optional.of(area));
        assertEquals(id,areaJPAService.findById(id).get().getId());
        verify(areaRepository, times(1)).findById(id);
    }

    @Test
    void save() {
        when(areaRepository.save(any())).thenReturn(area);
        assertNotNull(areaJPAService.save(area));
    }

    @Test
    void delete() {
        areaJPAService.delete(area);
        assertEquals(Optional.empty(),areaJPAService.findById(id));
        verify(areaRepository).delete(any());
    }

    @Test
    void deleteById() {
        areaJPAService.deleteById(id);
        assertEquals(Optional.empty(),areaJPAService.findById(id));
        verify(areaRepository).deleteById(anyLong());
    }

    @Test
    void count() {
        areaJPAService.count();
        verify(areaRepository).count();
    }
}