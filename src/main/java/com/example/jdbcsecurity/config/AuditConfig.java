package com.example.jdbcsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration
@EnableJdbcAuditing
public class AuditConfig {
//    @Bean
//    AuditorAware<AuditableUser> auditorProvider() {
//        return new AuditorAwareImpl();
//    }
}
