package de.app.fivegla.persistence;

import de.app.fivegla.api.Manufacturer;
import de.app.fivegla.persistence.entity.ThirdPartyApiConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ThirdPartyApiConfigurationRepository {

    private final ApplicationData applicationData;


    /**
     * Add third party API configuration.
     *
     * @return The added third party API configuration.
     */
    public ThirdPartyApiConfiguration addThirdPartyApiConfiguration(ThirdPartyApiConfiguration configuration) {
        if (applicationData.getThirdPartyApiConfigurations() == null) {
            applicationData.setThirdPartyApiConfigurations(new ArrayList<>());
        }
        configuration.setUuid(UUID.randomUUID().toString());
        applicationData.getThirdPartyApiConfigurations().add(configuration);
        applicationData.persist();
        return configuration;
    }

    /**
     * Retrieves a list of ThirdPartyApiConfigurations based on the provided tenant ID.
     *
     * @param tenantId The ID of the tenant for which to retrieve the third-party API configurations.
     * @param uuid     The ID of the third party API configuration.
     * @return A list of ThirdPartyApiConfigurations that match the given tenant ID.
     */
    public List<ThirdPartyApiConfiguration> getThirdPartyApiConfigurations(String tenantId, String uuid) {
        if (applicationData.getThirdPartyApiConfigurations() == null) {
            return Collections.emptyList();
        } else {
            return applicationData.getThirdPartyApiConfigurations().stream()
                    .filter(configuration -> configuration.getTenantId().equals(tenantId))
                    .filter(configuration -> configuration.getUuid().equals(uuid))
                    .toList();
        }
    }

    /**
     * Deletes a third-party API configuration.
     *
     * @param tenantId     The ID of the tenant for which to delete the third-party API configuration.
     * @param manufacturer The manufacturer of the third-party API configuration.
     */
    public void deleteThirdPartyApiConfiguration(String tenantId, Manufacturer manufacturer) {
        applicationData.getThirdPartyApiConfigurations().removeIf(configuration -> configuration.getTenantId().equals(tenantId) && configuration.getManufacturer().equals(manufacturer));
        applicationData.persist();
    }

    /**
     * Reads all third party API configurations.
     *
     * @return A list of all third party API configurations.
     */
    public List<ThirdPartyApiConfiguration> getThirdPartyApiConfigurations(String tenantId) {
        return applicationData.getThirdPartyApiConfigurations().stream()
                .filter(configuration -> configuration.getTenantId().equals(tenantId))
                .toList();
    }
}
