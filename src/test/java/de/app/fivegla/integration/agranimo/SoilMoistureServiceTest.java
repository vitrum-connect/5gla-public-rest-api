package de.app.fivegla.integration.agranimo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class AgranimoSoilMoistureServiceTest {

    @Autowired
    private AgranimoSoilMoistureService soilMoistureService;

    private Instant since = Instant.ofEpochSecond(1662087600);
    private Instant until = Instant.ofEpochSecond(1662617200);

    @Test
    void givenInvalidTimePeriodWhenFetchingWaterVolumeShouldNotCauseAnError() {
        soilMoistureService.fetchWaterVolume(until, since);
    }

    @Test
    void givenValidCredentialsWhenFetchingWaterVolumeThenThereShouldBeEntriesForTheZone() {
        soilMoistureService.fetchWaterVolume(since, until);
    }

    @Test
    void givenValidCredentialsWhenFetchingWaterHeightThenThereShouldBeEntriesForTheZone() {
        soilMoistureService.fetchWaterHeight(since, until);
    }

    @Test
    void givenValidCredentialsWhenFetchingWaterContentThenThereShouldBeEntriesForTheZone() {
        soilMoistureService.fetchWaterContent(since, until);
    }
}