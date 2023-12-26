package com.example.jdbcsecurity.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SystemStringAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
