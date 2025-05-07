package com.bitbybid.rfpmanager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        excludeName = {
                "org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration"
        }
)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}