package de.app.fivegla.business;

import de.app.fivegla.api.enums.EntityType;
import de.app.fivegla.controller.dto.request.PrecipitationRequest;
import de.app.fivegla.integration.fiware.FiwareEntityIntegrationService;
import de.app.fivegla.integration.fiware.model.ManualPrecipitationEvent;
import de.app.fivegla.integration.fiware.model.internal.NumberAttribute;
import de.app.fivegla.integration.fiware.model.internal.TextAttribute;
import de.app.fivegla.persistence.entity.Tenant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrecipitationService {

    private final GroupService groupService;
    private final FiwareEntityIntegrationService fiwareEntityIntegrationService;

    /**
     * Add a manual precipitation event.
     *
     * @param tenant  The tenant
     * @param request The request
     */
    public void addManualPrecipitationEvent(Tenant tenant, PrecipitationRequest request) {
        var group = groupService.getOrDefault(tenant, request.getGroupId());
        var manualPrecipitationEvent = new ManualPrecipitationEvent(
                UUID.randomUUID().toString(),
                EntityType.MANUAL_PRECIPITATION_EVENT.getKey(),
                new TextAttribute(group.getOid()),
                new TextAttribute(request.getDateCreated().toString()),
                request.getLatitude(),
                request.getLongitude(),
                new NumberAttribute(request.getTemp()),
                new NumberAttribute(request.getHumidity()),
                new NumberAttribute(request.getPrecipitation())
        );
        fiwareEntityIntegrationService.persist(tenant, group, manualPrecipitationEvent);
    }

}
