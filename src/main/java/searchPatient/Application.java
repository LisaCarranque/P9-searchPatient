package searchPatient;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import searchPatient.configuration.Generated;

@Log4j2
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"searchPatient"})
@EnableFeignClients("searchPatient")
@Generated
public class Application {

    public static void main(String[] args) {
        log.info("Launch searchPatient module");
        SpringApplication.run(Application.class, args);
    }

}
