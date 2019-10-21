package es.upm.frameworkeducativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FrameworkEducativoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkEducativoApplication.class, args);
    }

}
