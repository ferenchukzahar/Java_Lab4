package com.transport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void testBusAndTaxiCanCarryAnyHuman() {
        Bus bus = new Bus(3);
        Taxi taxi = new Taxi(2);

        Human human = new Human("Андрій");
        Firefighter firefighter = new Firefighter("Богдан");
        Policeman policeman = new Policeman("Віктор");

        bus.boardPassenger(human);
        bus.boardPassenger(firefighter);
        bus.boardPassenger(policeman);
        assertEquals(3, bus.getOccupiedSeats());

        taxi.boardPassenger(firefighter);
        taxi.boardPassenger(policeman);
        assertEquals(2, taxi.getOccupiedSeats());
    }

    @Test
    void testSpecializedVehicles() {
        FireTruck fireTruck = new FireTruck(2);
        Firefighter f1 = new Firefighter("Пожежник 1");
        fireTruck.boardPassenger(f1);
        assertEquals(1, fireTruck.getOccupiedSeats());

        PoliceCar policeCar = new PoliceCar(2);
        Policeman p1 = new Policeman("Поліцейський 1");
        policeCar.boardPassenger(p1);
        assertEquals(1, policeCar.getOccupiedSeats());
    }

    @Test
    void testVehicleFullException() {
        Taxi taxi = new Taxi(1);
        taxi.boardPassenger(new Human("Пасажир 1"));

        assertThrows(VehicleFullException.class, () -> {
            taxi.boardPassenger(new Human("Пасажир 2"));
        });
    }

    @Test
    void testDisembarkAndNotFoundException() {
        PoliceCar policeCar = new PoliceCar(2);
        Policeman p1 = new Policeman("Офіцер 1");
        Policeman p2 = new Policeman("Офіцер 2");

        policeCar.boardPassenger(p1);
        assertEquals(1, policeCar.getOccupiedSeats());

        policeCar.disembarkPassenger(p1);
        assertEquals(0, policeCar.getOccupiedSeats());

        assertThrows(PassengerNotFoundException.class, () -> {
            policeCar.disembarkPassenger(p2);
        });
    }

    @Test
    void testRoadCountOfHumans() {
        Bus bus = new Bus(10);
        bus.boardPassenger(new Human("Пасажир"));
        bus.boardPassenger(new Firefighter("Пожежник"));

        FireTruck fireTruck = new FireTruck(4);
        fireTruck.boardPassenger(new Firefighter("Пожежник 2"));

        PoliceCar policeCar = new PoliceCar(2);
        policeCar.boardPassenger(new Policeman("Поліцейський"));

        Road road = new Road();
        road.addCarToRoad(bus);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        assertEquals(4, road.getCountOfHumans());
    }
}
