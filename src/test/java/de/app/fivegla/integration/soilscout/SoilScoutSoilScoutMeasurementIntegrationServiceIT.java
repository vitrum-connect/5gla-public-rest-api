package de.app.fivegla.integration.soilscout;

import de.app.fivegla.SpringBootIntegrationTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class SoilScoutSoilScoutMeasurementIntegrationServiceIT extends SpringBootIntegrationTestBase {

    @Autowired
    private SoilScoutMeasurementIntegrationService soilScoutMeasurementIntegrationService;

    @Test
    void givenTimeRangeOf14DaysWhenFetchingSensorDataTheServiceShouldReturnMeasurements() {
        var measurements = soilScoutMeasurementIntegrationService.findAll(Instant.now().minus(14, ChronoUnit.DAYS), Instant.now());
        Assertions.assertNotNull(measurements);
        Assertions.assertFalse(measurements.isEmpty());
    }

}
