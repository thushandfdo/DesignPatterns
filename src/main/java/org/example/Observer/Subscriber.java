package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String message);
}

class Customer implements Subscriber {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber observer) {
        subscribers.add(observer);
    }

    public void removeSubscriber(Subscriber observer) {
        subscribers.remove(observer);
    }

    public void notifySubscribers(String message) {
        for (Subscriber observer : subscribers) {
            observer.update(message);
        }
    }
}

class ObserverTest {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Customer customer1 = new Customer("Kamal");
        Customer customer2 = new Customer("Amal");
        Customer customer3 = new Customer("Sarath");

        publisher.addSubscriber(customer1);
        publisher.addSubscriber(customer2);
        publisher.addSubscriber(customer3);

        publisher.notifySubscribers("Hello World!");

        publisher.removeSubscriber(customer2);

        publisher.notifySubscribers("Hello World Again!");
    }
}

