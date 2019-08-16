package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
@ComponentScan("controller")
public class Hello {
    public static void main(String[] args) {
        SpringApplication.run(Hello.class, args);
    }
}
