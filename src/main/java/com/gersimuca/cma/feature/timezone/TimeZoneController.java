package com.gersimuca.cma.feature.timezone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeZoneController {

    @Autowired
    private TimeZoneService service;

    @GetMapping("/timezones")
    public List<TimeZoneCountryResponse> getTimeZones() {
        return service.getListTimeZones();
    }
}