package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.models.Stage;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import gnomes.spring.gnomesv01.services.interfaces.StageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class StageControllerTest {

    // all possible stages for a crop
    private final static String SOWING_STAGE_NURSERY = "Sowing - NS";
    private final static String SOWING_STAGE_DIRECT = "Sowing - DS";
    private final static String GERMINATION_STAGE_HD = "Germination - HD";
    private final static String GERMINATION_STAGE_PT = "Germination - PT";
    private final static String TRANSPLANT_STAGE = "Transplant - TR";
    private final static String HARVEST_STAGE = "Harvest - HV";

    @Mock
    StageService stageService;

    @Mock
    CropService cropService;

    @InjectMocks
    StageController stageController;

    MockMvc mockMvc;

    Crop crop;
    List<Stage> stages;

    Long id1 = 1L;
    Long id2 = 2L;

    @BeforeEach
    void setUp() {
        crop = Crop.builder().id(id1).build();
        stages = new ArrayList<>();

        stages.add(Stage.builder().id(id1).name(SOWING_STAGE_DIRECT).build());
        stages.add(Stage.builder().id(id2).name(GERMINATION_STAGE_HD).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(stageController)
                .build();
    }

    @Test
    void initCreationFormTest() throws Exception{
        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));
//        when(stageService.findAll()).thenReturn(stages);

        mockMvc.perform(get(("/crops/1/stages/new")))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("crop"))
                .andExpect(model().attributeExists("stage"))
                .andExpect(view().name("stages/stageForm"));
    }

    @Test
    void processCreationFormTest() throws Exception{
        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));

        mockMvc.perform(post("/crops/1/stages/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/crops/1/stages/all"));

        verify(stageService).save(any());
    }

    @Test
    void initEditFormTest() throws Exception{
        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));
        when(stageService.findById(anyLong())).thenReturn(Optional.of(Stage.builder().id(id1).build()));

        mockMvc.perform(get(("/crops/1/stages/1/edit")))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("crop"))
                .andExpect(model().attributeExists("stage"))
                .andExpect(view().name("stages/stageForm"));
    }

    @Test
    void processEditFormTest() throws Exception{
        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));

        mockMvc.perform(post("/crops/1/stages/1/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/crops/1/stages/all"));

        verify(stageService).save(any());
    }
}