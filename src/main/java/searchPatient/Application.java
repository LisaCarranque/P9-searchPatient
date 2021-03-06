package searchPatient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import searchPatient.configuration.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * this class is the main class for searchPatient microservice
 */
@Slf4j
@EnableSwagger2
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
