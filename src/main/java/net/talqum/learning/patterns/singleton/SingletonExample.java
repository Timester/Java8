package net.talqum.learning.patterns.singleton;

/**
 * Created by Tömösvári Imre on 2014.12.22..
 */
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
