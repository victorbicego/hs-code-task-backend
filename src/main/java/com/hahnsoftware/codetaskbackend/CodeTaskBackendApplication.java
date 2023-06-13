package com.hahnsoftware.codetaskbackend;

import com.hahnsoftware.codetaskbackend.configurations.DataInitializer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeTaskBackendApplication {

    private DataInitializer dataInitializer;

    @Autowired
    public CodeTaskBackendApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeTaskBackendApplication.class, args);
    }

    @PostConstruct
    public void init() {
        dataInitializer.initializeData();
    }
}
