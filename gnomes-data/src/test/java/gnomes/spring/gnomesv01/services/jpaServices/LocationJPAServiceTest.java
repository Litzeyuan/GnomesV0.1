package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.repositories.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationJPAServiceTest {

    @Mock
    LocationRepository locationRepository;
    //@Mock
    //AreaRepository areaRepository;
    @InjectMocks
    LocationJPAService locationJPAService;

    Long id = 1L;
    String name = "name";
    Location location;

    @BeforeEach
    void setUp() {
        location = Location.builder().id(id).name(name).build();
        locationJPAService.save(location);
    }

    @Test
    void findByName() {
        when(locationRepository.findByName(any())).thenReturn(location);
        Location location1 = locationJPAService.findByName(name);

        assertEquals(location, location1);
        assertEquals(name, location1.getName());
        verify(locationRepository,times(1)).findByName(name);
        verify(locationRepository).findByName(any());
    }

    @Test
    void findAll() {
        ArrayList testAreas = new ArrayList();
        testAreas.add(Location.builder().build());
        testAreas.add(Location.builder().build());

        when(locationRepository.findAll()).thenReturn(testAreas);
        List<Location> areas = locationJPAService.findAll();

        assertEquals(2,areas.size());
        assertEquals(testAreas,areas);
        verify(locationRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(locationRepository.findById(anyLong())).thenReturn(Optional.of(location));
        assertEquals(id,locationJPAService.findById(id).getId());
        verify(locationRepository, times(1)).findById(id);
    }

    @Test
    void save() {
        when(locationRepository.save(any())).thenReturn(location);
        assertNotNull(locationJPAService.save(location));
    }

    @Test
    void delete() {
        locationJPAService.delete(location);
        assertNull(locationJPAService.findById(id));
        verify(locationRepository).delete(any());
    }

    @Test
    void deleteById() {
        locationJPAService.deleteById(id);
        assertNull(locationJPAService.findById(id));
        verify(locationRepository).deleteById(anyLong());
    }

    @Test
    void count() {
        locationJPAService.count();
        verify(locationRepository).count();
    }
}