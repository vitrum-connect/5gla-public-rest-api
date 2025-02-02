package de.app.fivegla.api;

import lombok.Getter;

/**
 * Error codes.
 */
@Getter
public enum Error {

    INVALID_REQUEST(errorOf(1)),
    SOIL_SCOUT_COULD_NOT_AUTHENTICATE(errorOf(2)),
    SOIL_SCOUT_CSV_DATA_IMPORT_FAILED(errorOf(3)),
    FARM21_COULD_NOT_AUTHENTICATE(errorOf(4)),
    AGRANIMO_COULD_NOT_LOGIN_AGAINST_API(errorOf(5)),
    AGRANIMO_COULD_NOT_FETCH_ZONES(errorOf(6)),
    AGRANIMO_COULD_NOT_FETCH_SOIL_MOISTURE_FOR_ZONE(errorOf(7)),
    COULD_NOT_READ_IMAGE_METADATA(errorOf(8)),
    AGVOLUTION_COULD_NOT_LOGIN_AGAINST_API(errorOf(9)),
    AGVOLUTION_COULD_NOT_FETCH_DEVICES(errorOf(10)),
    AGVOLUTION_COULD_NOT_FETCH_TIME_SERIES(errorOf(11)),
    SENSOTERRA_COULD_NOT_LOGIN_AGAINST_API(errorOf(12)),
    SENSOTERRA_COULD_NOT_FETCH_LOCATIONS(errorOf(13)),
    SENSOTERRA_COULD_NOT_FETCH_PROBES(errorOf(14)),
    SENTEK_XML_PARSING_ERROR(errorOf(15)),
    SENTEK_COULD_NOT_FETCH_SENSORS(errorOf(16)),
    FARM21_COULD_NOT_FETCH_DEVICES(errorOf(17)),
    SENTEK_COULD_NOT_FETCH_SENSOR_DATA(errorOf(18)),
    WEENAT_COULD_NOT_LOGIN_AGAINST_API(errorOf(19)),
    WEENAT_COULD_NOT_FETCH_PLOTS(errorOf(20)),
    WEENAT_COULD_NOT_FETCH_MEASURES(errorOf(21)),
    SENTEK_COULD_NOT_FIND_SENSOR_FOR_ID(errorOf(22)),
    WEENAT_COULD_NOT_FIND_SENSOR_FOR_ID(errorOf(23)),
    AGVOLUTION_COULD_NOT_FIND_SENSOR_FOR_ID(errorOf(24)),
    FIWARE_INTEGRATION_LAYER_ERROR(errorOf(25)),
    FARM21_COULD_NOT_FETCH_DEVICE_DATA(errorOf(26)),
    COULD_NOT_PARSE_GEO_JSON(errorOf(27)),
    COULD_NOT_PARSE_CSV(errorOf(28)),
    THIRD_PARTY_SERVICE_UNAVAILABLE(errorOf(29)),
    MICASENSE_TX_NOT_FOUND(errorOf(30)),
    AGRANIMO_COULD_NOT_FETCH_SOIL_MOISTURE(errorOf(31)),
    INVALID_TENANT_ID(errorOf(32)),
    TENANT_ALREADY_EXISTS(errorOf(33)),
    TENANT_NOT_FOUND(errorOf(34)),
    COULD_NOT_CREATE_GPS_COORDINATES(errorOf(35)),
    GROUP_NOT_FOUND(errorOf(36)),
    TRYING_TO_UPDATE_GROUP_FROM_ANOTHER_TENANT(errorOf(37)),
    TRYING_TO_ACCESS_GROUP_FROM_ANOTHER_TENANT(errorOf(38)),
    TRYING_TO_DELETE_GROUP_FROM_ANOTHER_TENANT(errorOf(39)),
    DEFAULT_GROUP_FOR_TENANT_NOT_FOUND(errorOf(40)),
    THIRD_PARTY_API_CONFIGURATION_NOT_FOUND(errorOf(41)),
    COULD_NOT_STORE_IMAGE_ON_S3(errorOf(42)),
    ORTHOPHOTO_COULD_NOT_TRIGGER_CALCULATION(errorOf(43)),
    COULD_NOT_IMPORT_DATA_FROM_OPEN_WEATHER(errorOf(44)),
    TRANSACTION_ALREADY_PROCESSED(errorOf(45)),
    TRANSACTION_DOES_NOT_EXIST(errorOf(46));

    private static String errorOf(int i) {
        return ERR_ + String.format("%05d", i);
    }

    private static final String ERR_ = "ERR_";

    private final String code;

    Error(String code) {
        this.code = code;
    }

    public String asTitle() {
        return String.format("%s", code);
    }
}
