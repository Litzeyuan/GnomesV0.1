package gnomes.spring.gnomesv01.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class SowingStageServiceControllerTest {

    @Mock
    SowingStageController sowingStageController;

    @BeforeEach
    public void setUp() {

    }

    //@Test
    public void test(){

    }


}