package gnomes.spring.gnomesv01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Gnomesv01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext cxt = SpringApplication.run(Gnomesv01Application.class, args);

        //Dependency Injection
        //to get controller by name, no creation
        //XXController xx = cxt.getBean("controller name");

    }

    public String greeting(){
        return "This is gnomes helper";
    }

}
