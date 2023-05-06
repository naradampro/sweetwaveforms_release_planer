package com.sweetwaveforms.releaseplanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Welcome to SweetWaveforms Release Planner Portal";
    }
}
