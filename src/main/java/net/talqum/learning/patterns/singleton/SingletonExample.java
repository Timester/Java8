package net.talqum.learning.patterns.singleton;

public class SingletonExample {

    private static SingletonExample instance = new SingletonExample();

    private SingletonExample(){}

    public static SingletonExample getInstance(){
        return instance;
    }

    public void print(){
        System.out.println("I'm a singleton");
    }
}
