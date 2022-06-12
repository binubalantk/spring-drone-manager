package com.dronemanager.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {
    @Value("${spring.database.host}")
    private String host;

    @Value("${spring.database.port}")
    private String port;

    @Value("${spring.database.username}")
    private String username;

    @Value("${spring.database.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
