package com.transport;

public class VehicleFullException extends RuntimeException {
    public VehicleFullException(String message) {
        super(message);
    }
}
