package de.app.fivegla.controller;

import de.app.fivegla.controller.api.BaseMappings;
import de.app.fivegla.controller.api.swagger.OperationTags;
import de.app.fivegla.controller.dto.request.DeviceRegistrationRequest;
import de.app.fivegla.integration.generic.GenericDeviceIntegrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is a controller that handles the registration of devices in the system.
 * It provides RESTful endpoints for device registration.
 */
@RestController
@RequestMapping(BaseMappings.DEVICE_REGISTRATION)
public class DeviceRegistrationController {

    private final GenericDeviceIntegrationService genericDeviceIntegrationService;

    public DeviceRegistrationController(GenericDeviceIntegrationService genericDeviceIntegrationService) {
        this.genericDeviceIntegrationService = genericDeviceIntegrationService;
    }

    @Operation(
            operationId = "device-registration.register",
            description = "Registers a device in the system in case the device is not connected to a manufacturer's cloud.",
            tags = OperationTags.DEVICE_REGISTRATION
    )
    @ApiResponse(
            responseCode = "201",
            description = "The device has been registered successfully."
    )
    @ApiResponse(
            responseCode = "400",
            description = "The request is invalid."
    )
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody DeviceRegistrationRequest request) {
        genericDeviceIntegrationService.register(request.getManufacturer(), request.getId(), request.getLatitude(), request.getLongitude());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
