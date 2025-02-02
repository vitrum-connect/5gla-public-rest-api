package de.app.fivegla.integration.fiware.model;

import de.app.fivegla.business.agricrop.GpsCoordinate;
import de.app.fivegla.integration.fiware.model.api.FiwareEntity;
import de.app.fivegla.integration.fiware.model.api.Validatable;
import de.app.fivegla.integration.fiware.model.internal.Attribute;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Device position.
 */
@Slf4j
public record AgriCrop(
        String id,
        String type,
        Attribute group,
        Attribute dateCreated,
        List<GpsCoordinate> coordinates
) implements Validatable, FiwareEntity {

    @Override
    public String asJson() {
        validate();
        var json = "{" +
                "  \"id\":\"" + id.trim() + "\"," +
                "  \"type\":\"" + type.trim() + "\"," +
                "  \"customGroup\":" + group.asJson().trim() + "," +
                "  \"dateCreated\":" + dateCreated.asJson().trim() + "," +
                "  \"location\":" + coordinatesAsJson(coordinates).trim() +
                "}";
        log.debug("{} as JSON: {}", this.getClass().getSimpleName(), json);
        return json;
    }

    @Override
    public String asSmartModelJson() {
        throw new NotImplementedException("Smart model JSON is not supported for AgriCrop.");
    }

    @Override
    public void validate() {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("The id of the device position must not be null or blank.");
        }
        if (StringUtils.isBlank(type)) {
            throw new IllegalArgumentException("The type of the device position must not be null or blank.");
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean shouldCreateSmartModelEntity() {
        return false;
    }
}
