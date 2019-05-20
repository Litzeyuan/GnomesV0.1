package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Stage;
import gnomes.spring.gnomesv01.repositories.StageRepository;
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
class StageJPAServiceTest {

    @Mock
    StageRepository stageRepository;
    @InjectMocks
    StageJPAService stageJPAService;

    Long id = 1L;
    String name = "name";
    Stage stage;

    @BeforeEach
    void setUp() {
        stage = Stage.builder().id(id).name(name).build();
        stageJPAService.save(stage);
    }

    @Test
    void findByName() {
        when(stageRepository.findByName(any())).thenReturn(Optional.of(stage));
        Stage stage1 = stageJPAService.findByName(name).get();

        assertEquals(stage, stage1);
        assertEquals(name, stage1.getName());
        verify(stageRepository,times(1)).findByName(name);
        verify(stageRepository).findByName(any());
    }

    @Test
    void findAll() {
        ArrayList testStages = new ArrayList();
        testStages.add(Stage.builder().build());
        testStages.add(Stage.builder().build());

        when(stageRepository.findAll()).thenReturn(testStages);
        List<Stage> areas = stageJPAService.findAll();

        assertEquals(2,areas.size());
        assertEquals(testStages,areas);
        verify(stageRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(stageRepository.findById(anyLong())).thenReturn(Optional.of(stage));
        assertEquals(id,stageJPAService.findById(id).get().getId());
        verify(stageRepository, times(1)).findById(id);
    }

    @Test
    void save() {
        when(stageRepository.save(any())).thenReturn(stage);
        assertNotNull(stageJPAService.save(stage));
    }

    @Test
    void delete() {
        stageJPAService.delete(stage);
        assertThrows(RuntimeException.class, () -> stageJPAService.findById(id));
        verify(stageRepository).delete(any());
    }

    @Test
    void deleteById() {
        stageJPAService.deleteById(id);
        assertThrows(RuntimeException.class, () -> stageJPAService.findById(id));
        verify(stageRepository).deleteById(anyLong());
    }

    @Test
    void count() {
        stageJPAService.count();
        verify(stageRepository).count();
    }


}