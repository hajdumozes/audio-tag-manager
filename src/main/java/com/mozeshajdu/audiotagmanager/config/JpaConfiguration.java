package com.mozeshajdu.audiotagmanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.mozeshajdu.audiotagmanager.persistance"})
public class JpaConfiguration {
}
