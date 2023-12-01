package org.example.Factory;

interface Animal {
    void pet();
}

class Dog implements Animal {
    @Override
    public void pet() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void pet() {
        System.out.println("Meow!");
    }
}

abstract class AnimalFactory {
    public Animal getAnimal() {
        return createAnimal();
    }

    public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

class FactoryTest {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.getAnimal();
        Animal cat = catFactory.getAnimal();

        dog.pet();
        cat.pet();
    }
}
