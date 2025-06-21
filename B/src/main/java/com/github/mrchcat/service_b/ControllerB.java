package com.github.mrchcat.service_b;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ControllerB {

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "Hello from B");
    }

}
