package com.gersimuca.cma;

import com.gersimuca.cma.feature.country.CountryEntity;
import com.gersimuca.cma.feature.country.CountryRepository;
import com.gersimuca.cma.feature.timezone.TimeZoneEntity;
import com.gersimuca.cma.feature.timezone.TimeZoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;
import java.util.List;

@EnableAsync
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer(CountryRepository countryRepository, TimeZoneRepository timeZoneRepository) {
		return args -> {
			// Create countries
			CountryEntity usa = new CountryEntity();
			usa.setCode("US");
			usa.setName("United States");

			CountryEntity france = new CountryEntity();
			france.setCode("FR");
			france.setName("France");

			// Create time zones
			TimeZoneEntity est = new TimeZoneEntity();
			est.setZoneId("America/New_York");
			est.setCountry(usa);

			TimeZoneEntity cet = new TimeZoneEntity();
			cet.setZoneId("Europe/Paris");
			cet.setCountry(france);

			// Set time zones to countries
			usa.setTimeZones(List.of(est));
			france.setTimeZones(List.of(cet));

			// Save data
			countryRepository.saveAll(Arrays.asList(usa, france));
			timeZoneRepository.saveAll(Arrays.asList(est, cet));
		};
	}
}