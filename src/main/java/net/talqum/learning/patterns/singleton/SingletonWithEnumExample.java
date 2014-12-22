package net.talqum.learning.patterns.singleton;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
public enum SingletonWithEnumExample {
    INSTANCE;

    private SingletonWithEnumExample() {}

    public void print() {
        System.out.println("I'm a singleton");
    }
}

