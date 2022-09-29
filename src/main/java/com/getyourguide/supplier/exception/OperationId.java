package com.getyourguide.supplier.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OperationId {

    GET_AVAILABILITY("get-availabilities"),
    RESERVE("reserve"),
    CANCEL_RESERVATION("cancel-reservation"),
    BOOK("book"),
    CANCEL_BOOKING("cancel-booking"),
    DEFAULT("default");

    private final String value;

    OperationId(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static OperationId fromValue(String value) {
        for (OperationId b : OperationId.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
