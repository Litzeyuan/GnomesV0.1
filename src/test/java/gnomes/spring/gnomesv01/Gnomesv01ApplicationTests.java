package gnomes.spring.gnomesv01;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Gnomesv01ApplicationTests {

    Gnomesv01Application app;

    @BeforeEach
    public void setUp(){
        app = new Gnomesv01Application();
    }
    @Test
    public void contextLoads() {
        Assertions.assertEquals("This is gnomes helper",app.greeting());
    }

}
