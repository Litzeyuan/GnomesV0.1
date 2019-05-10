package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CropsControllerTest {

    @Mock
    CropService cropService;

    @Mock
    Model model;

    CropsController cropsController;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        cropsController = new CropsController(cropService);
    }

    @Test
    void mockMVCTest() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(cropsController).build();
        mockMvc.perform(get("/crops.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("crops"));
    }

    @Test
    void getCropsPageTest() throws Exception{
        //given
        List<Crop> crops = new ArrayList<>();
        crops.add(new Crop());
        crops.add(new Crop());

        //when
        when(cropService.findAll()).thenReturn(crops);

        //argument captor
        ArgumentCaptor<List<Crop>> argumentCaptor = ArgumentCaptor.forClass(List.class);


        String viewName = cropsController.getCropsPage(model);

        assertEquals("crops",viewName);
        verify(cropService, times(1)).findAll();
        verify(model,times(1)).addAttribute(eq("crops"), argumentCaptor.capture());

        List<Crop> crops1 = argumentCaptor.getValue();
        assertEquals(2,crops1.size());

    }
}