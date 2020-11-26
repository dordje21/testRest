package com.test.test.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class TestApplication {
        public static void main(String[] args) {
            SpringApplication app = new SpringApplication(TestApplication.class);
            app.setDefaultProperties(Collections
                    .singletonMap("server.port", "8080"));
            app.run(args);
        }
}
