package gnomes.spring.gnomesv01.controllers;

import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

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
    void getCropsPageTest() throws Exception{
        String viewName = cropsController.getCropsPage(model);

        Assertions.assertEquals("crops",viewName);
        Mockito.verify(cropService, Mockito.times(1)).findAll();
        Mockito.verify(model,Mockito.times(1)).addAttribute(Mockito.eq("crops"),Mockito.anySet());
    }
}