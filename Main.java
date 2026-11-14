package com.transport;

public class Main {
    public static void main(String[] args) {
        Human citizen = new Human("Іван Петренко");
        Firefighter firefighter = new Firefighter("Олександр Коваль");
        Policeman policeman = new Policeman("Дмитро Мельник");

        Bus bus = new Bus(20);
        bus.boardPassenger(citizen);
        bus.boardPassenger(firefighter);
        bus.boardPassenger(policeman);

        Taxi taxi = new Taxi(4);
        taxi.boardPassenger(citizen);

        FireTruck fireTruck = new FireTruck(6);
        fireTruck.boardPassenger(firefighter);

        PoliceCar policeCar = new PoliceCar(2);
        policeCar.boardPassenger(policeman);

        Road road = new Road();
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        System.out.println("Зайнято місць в автобусі: " + bus.getOccupiedSeats() + " з " + bus.getMaxSeats());
        System.out.println("Зайнято місць у таксі: " + taxi.getOccupiedSeats() + " з " + taxi.getMaxSeats());
        System.out.println("Зайнято місць у пожежній машині: " + fireTruck.getOccupiedSeats() + " з " + fireTruck.getMaxSeats());
        System.out.println("Зайнято місць у поліцейській машині: " + policeCar.getOccupiedSeats() + " з " + policeCar.getMaxSeats());
        System.out.println("\nЗагальна кількість людей у транспорті на дорозі: " + road.getCountOfHumans());
    }
}
