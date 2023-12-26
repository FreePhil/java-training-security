package com.example.jdbcsecurity.config;

import com.example.jdbcsecurity.repository.SystemPermissionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SystemPermissionEvaluator {

    SystemPermissionRepository permissionRepository;

    public SystemPermissionEvaluator(SystemPermissionRepository repo) {
        this.permissionRepository = repo;
    }

    public boolean hasPermission(String permissionTag) {
        Optional<Authentication> authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
        return authentication.map(auth -> {
            var permission = permissionRepository.findOneByUsernameAAndPermissionTag(auth.getName(), permissionTag);
            return permission.map(p -> p.getHasPermission()).orElse(false);
        }).orElse(false);
    }
}
