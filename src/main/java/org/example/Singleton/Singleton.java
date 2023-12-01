package org.example.Singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonTest {
    public static void main(String[] args) {
        // Singleton newSingleton = new Singleton();
        // --> Error: Singleton() has private access in Singleton

        Singleton singleton = Singleton.getInstance();
    }
}
