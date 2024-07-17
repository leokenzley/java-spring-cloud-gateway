package com.leokenzley.caller.demo.api.web.rest.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class CallerController {

    @GetMapping("")
    public String ping() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authenticationauthentication = context.getAuthentication();
        System.out.println(authenticationauthentication.getPrincipal().toString());
        return "GO GO";
    }
}
