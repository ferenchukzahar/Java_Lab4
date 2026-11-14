package com.transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private final int maxSeats;
    private final List<T> passengers;

    public Vehicle(int maxSeats) {
        if (maxSeats <= 0) {
            throw new IllegalArgumentException("Кількість місць має бути більшою за 0");
        }
        this.maxSeats = maxSeats;
        this.passengers = new ArrayList<>(maxSeats);
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Пасажир не може бути null");
        }
        if (passengers.size() >= maxSeats) {
            throw new VehicleFullException("Усі місця (" + maxSeats + ") вже зайняті!");
        }
        passengers.add(passenger);
    }

    public void disembarkPassenger(T passenger) {
        if (!passengers.remove(passenger)) {
            throw new PassengerNotFoundException("Пасажир " + passenger + " не перебуває у цьому транспортному засобі!");
        }
    }

    public List<T> getPassengers() {
        return new ArrayList<>(passengers);
    }
}
