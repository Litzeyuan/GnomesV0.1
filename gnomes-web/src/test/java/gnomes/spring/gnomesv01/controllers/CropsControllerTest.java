package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CropsControllerTest {

    @Mock
    CropService cropService;

    @Mock
    Model model;

    @InjectMocks
    CropsController cropsController;

    MockMvc mockMvc;
    List<Crop> crops;

    Long id1 = 1L;
    Long id2 = 2L;
    String name1 = "crop1";
    String name2 = "crop2";

    @BeforeEach
    void setUp() throws Exception{
        crops = new ArrayList<>();
        crops.add(Crop.builder().id(id1).name(name1).build());
        crops.add(Crop.builder().id(id2).name(name2).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(cropsController)
                .build();
    }

    @Test
    void mockMVCTest() throws Exception {
        mockMvc.perform(get("/listCrops"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops"));
    }

    @Test
    void listCropsTest() throws Exception{
        when(cropService.findAll()).thenReturn(crops);
        mockMvc.perform(get("/listCrops"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops"))
                .andExpect(model().attribute("crops",hasSize(2))); // added 2 in the array list in the setUp()


        // Or use argument captor
        ArgumentCaptor<List<Crop>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        String viewName = cropsController.listCrops(model);
        assertEquals("crops",viewName);
        verify(model,times(1)).addAttribute(eq("crops"), argumentCaptor.capture());

        List<Crop> crops1 = argumentCaptor.getValue();
        assertEquals(2,crops1.size());
    }

    @Test
    void findCropsByIdTest() throws Exception {
        Crop crop = Crop.builder().id(id1).build();

        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));

        mockMvc.perform(get("/listCrops/find/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops/cropDetails"))
                .andExpect(model().attributeExists("crop"));

        verifyZeroInteractions(cropService);
    }

    @Test
    void showCropTest() throws Exception{
        Crop crop = Crop.builder().id(id1).build();

        when(cropService.findById(anyLong())).thenReturn(Optional.of(crop));
        mockMvc.perform(get("/listCrops/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops/cropDetails"))
                .andExpect(model().attribute("crop", hasProperty("id",is(id1))));
    }


    @Test
    void addNewCropTest() throws  Exception{
        Crop crop = Crop.builder().id(id1).build();

        when(cropService.save(any())).thenReturn(crop);
        mockMvc.perform(get("/newCrop"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops/cropform"))
                .andExpect(model().attributeExists("crop"));
    }

    @Test
    void saveOrUpdateTest() throws  Exception{
        Crop crop = Crop.builder().id(id1).build();
    }
}