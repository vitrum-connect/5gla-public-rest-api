package de.app.fivegla.integration.fiware.model.internal;

import de.app.fivegla.integration.fiware.api.CustomDateFormatter;
import de.app.fivegla.integration.fiware.api.FiwareType;

import java.time.Instant;

/**
 * Represents an attribute.
 */
public record InstantAttribute(Instant value) implements Attribute {

    /**
     * Converts the attribute object to JSON format.
     *
     * @return The attribute object in JSON format.
     */
    @Override
    public String asJson() {
        return "{" +
                "  \"type\":\"" + FiwareType.DATE_TIME.getKey() + "\"," +
                "  \"value\":\"" + CustomDateFormatter.format(value) + "\"" +
                "}";
    }

}
