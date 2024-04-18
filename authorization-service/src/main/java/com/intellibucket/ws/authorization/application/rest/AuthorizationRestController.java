package com.intellibucket.ws.authorization.application.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization/1.0/private/context-holder")
public class AuthorizationRestController {
    public boolean authorize(String token) {
        return false;
    }
}
