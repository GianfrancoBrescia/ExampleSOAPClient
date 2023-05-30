package com.example.soapclient.controller;

import com.example.soapclient.schema.Country;
import com.example.soapclient.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class Controller {

    private final TestService testService;

    @GetMapping(value = "/countries")
    public Country getCountry(@RequestParam("country") String country) {
        return testService.getCountry(country);
    }
}
