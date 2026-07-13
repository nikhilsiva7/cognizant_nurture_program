package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        // Testing Hands-on 6, 7, 8, 9
        testFindCountry();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
    }

    private static void testFindCountry() {
        try {
            Country c = countryService.findCountryByCode("IN");
            LOGGER.debug("Found Country: {}", c);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void testAddCountry() {
        Country newC = new Country();
        newC.setCode("LK");
        newC.setName("Sri Lanka");
        countryService.addCountry(newC);
        LOGGER.info("Added Sri Lanka");
    }

    private static void testUpdateCountry() {
        try {
            countryService.updateCountry("LK", "Sri Lanka (Updated)");
            LOGGER.info("Updated Sri Lanka name");
        } catch (CountryNotFoundException e) {
            LOGGER.error("Update failed");
        }
    }

    private static void testDeleteCountry() {
        countryService.deleteCountry("LK");
        LOGGER.info("Deleted Sri Lanka");
    }
}