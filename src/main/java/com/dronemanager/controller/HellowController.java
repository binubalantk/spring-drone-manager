package com.dronemanager.controller;

import com.dronemanager.core.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("unused")
public class HellowController {
    private DatabaseConfig databaseConfig;

    @Autowired
    public HellowController(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @GetMapping(value = "/")
    public String Helo() {
        return "Testing: " + this.databaseConfig.getPassword();
    }
}
