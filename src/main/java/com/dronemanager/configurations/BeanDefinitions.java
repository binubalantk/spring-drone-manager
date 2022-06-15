package com.dronemanager.configurations;

import com.dronemanager.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@SuppressWarnings("unused")
public class BeanDefinitions {
    @Bean()
    @Scope()
    public User getUser() {
        return new User();
    }

}
