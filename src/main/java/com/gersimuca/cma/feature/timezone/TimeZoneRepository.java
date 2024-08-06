package com.gersimuca.cma.feature.timezone;

import com.gersimuca.cma.feature.country.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeZoneRepository extends JpaRepository<TimeZoneEntity, Long> {
    List<TimeZoneEntity> findByCountry(CountryEntity country);
}
