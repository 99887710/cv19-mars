package jw.io;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jw.io.controller.CaseDataController;
import jw.io.controller.PingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "jw.io.controller")
@Import({ PingController.class, CaseDataController.class})
@OpenAPIDefinition(
        info = @Info(
                title = "CV19 - Mars",
                version = "1.0",
                description = "CV19 Mars Backend APIs",
                license = @License(name = "Apache 2.0", url = "http://foo.bar")        ))
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}