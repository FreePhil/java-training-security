package com.example.jdbcsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration
@EnableJdbcAuditing
public class AuditConfig {
    // https://docs.spring.io/spring-data/jdbc/docs/2.2.4/reference/html/#reference
//    @Bean
//    AuditorAware<AuditableUser> auditorProvider() {
//        return new AuditorAwareImpl();
//    }
}

//class SpringSecurityAuditorAware implements AuditorAware<User> {
//
//    @Override
//    public Optional<User> getCurrentAuditor() {
//
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getPrincipal)
//                .map(User.class::cast);
//    }
//}
