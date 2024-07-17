package com.leokenzley.callme.api.rest.callme.controller;

import com.leokenzley.callme.api.exception.BusinessException;
import com.leokenzley.callme.api.rest.callme.exception.NotFoundExeception;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/callme")
public class CallmeController {

    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    @GetMapping("/ping")
    public String ping() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return "Scopes: " + authentication.getAuthorities();
    }

    @GetMapping("/examples/not-found")
    public String notfound() {
        throw new NotFoundExeception("Exemplo de erro: NOT FOUND");
    }

    @GetMapping("/examples/generic-exception")
    public String genericException() {
        throw new BusinessException("Exemplo de erro genérico de bad request");
    }
}
