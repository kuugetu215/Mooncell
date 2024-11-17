package karazuki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class McServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McServerApplication.class, args);
    }

}
