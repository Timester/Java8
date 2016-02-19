package net.talqum.learning.patterns.singleton;

public enum SingletonWithEnumExample {
    INSTANCE;

    private SingletonWithEnumExample() {}

    public void print() {
        System.out.println("I'm a singleton");
    }
}

