package com.getyourguide.supplier.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {

    AUTHORIZATION_FAILURE("AUTHORIZATION_FAILURE"),

    NO_AVAILABILITY("NO_AVAILABILITY"),

    INVALID_PRODUCT("INVALID_PRODUCT"),

    INVALID_RESERVATION("INVALID_RESERVATION"),

    INVALID_BOOKING("INVALID_BOOKING"),

    VALIDATION_FAILURE("VALIDATION_FAILURE"),

    INVALID_TICKET_CATEGORY("INVALID_TICKET_CATEGORY"),

    INTERNAL_SYSTEM_FAILURE("INTERNAL_SYSTEM_FAILURE"),

    INVALID_PARTICIPANTS_CONFIGURATION("INVALID_PARTICIPANTS_CONFIGURATION"),

    TRIGGER_RETRY_EXCEPTION("TRIGGER_RETRY_EXCEPTION");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCode fromValue(String value) {
        for (ErrorCode b : ErrorCode.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
