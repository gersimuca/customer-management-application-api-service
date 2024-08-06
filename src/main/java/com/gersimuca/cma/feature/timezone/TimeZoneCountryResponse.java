package com.gersimuca.cma.feature.timezone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class TimeZoneCountryResponse {
    private String code;
    private String name;
    private List<String> timeZones;
}
