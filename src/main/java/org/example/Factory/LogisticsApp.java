package org.example.Factory;

interface Transportation {
    void deliver();
}

class Truck implements Transportation {
    @Override
    public void deliver() {
        System.out.println("Delivering by truck!");
    }
}

class Ship implements Transportation {
    @Override
    public void deliver() {
        System.out.println("Delivering by ship!");
    }
}

abstract class TransportationFactory {
    public Transportation createTransportation() {
        return create();
    }

    protected abstract Transportation create();
}

class TruckFactory extends TransportationFactory {
    @Override
    protected Transportation create() {
        return new Truck();
    }
}

class ShipFactory extends TransportationFactory {
    @Override
    protected Transportation create() {
        return new Ship();
    }
}

public class LogisticsApp {
    public static void main(String[] args) {
        TransportationFactory truckFactory = new TruckFactory();
        TransportationFactory shipFactory = new ShipFactory();

        Transportation truck = truckFactory.createTransportation();
        Transportation ship = shipFactory.createTransportation();

        truck.deliver();
        ship.deliver();
    }
}

