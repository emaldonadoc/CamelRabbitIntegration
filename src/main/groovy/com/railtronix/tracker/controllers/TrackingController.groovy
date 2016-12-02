package com.railtronix.tracker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingController {

    @RequestMapping("/tracker")
    public String hello() {
        return "HELLO THERE";
    }
}
