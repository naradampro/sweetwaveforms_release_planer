package com.sweetwaveform.releaseplanner.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String sayHello() {
        return "<h1>Hello! Welcome to SweetWaveforms Release Planner Portal</h1>";
    }
}
