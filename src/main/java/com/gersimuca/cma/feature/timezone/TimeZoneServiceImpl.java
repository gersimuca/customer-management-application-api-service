package com.gersimuca.cma.feature.timezone;

import com.gersimuca.cma.feature.country.CountryEntity;
import com.gersimuca.cma.feature.country.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeZoneServiceImpl implements TimeZoneService {

    private final CountryRepository countryRepository;

    private final TimeZoneRepository timeZoneRepository;

    @Override
    public List<TimeZoneCountryResponse> getListTimeZones() {
        List<CountryEntity> countries = countryRepository.findAll();
        return countries.stream()
                .map(country -> {
                    List<TimeZoneEntity> timeZones = timeZoneRepository.findByCountry(country);
                    List<String> timeZoneIds = timeZones.stream()
                            .map(TimeZoneEntity::getZoneId)
                            .collect(Collectors.toList());
                    return new TimeZoneCountryResponse(country.getCode(), country.getName(), timeZoneIds);
                })
                .collect(Collectors.toList());
    }

}
