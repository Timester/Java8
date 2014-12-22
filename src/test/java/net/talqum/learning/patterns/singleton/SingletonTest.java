package net.talqum.learning.patterns.singleton;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void testSingleton(){
        SingletonExample singleton = SingletonExample.getInstance();
        singleton.print();
    }

    @Test
    public void testEnumSingleton(){
        SingletonWithEnumExample.INSTANCE.print();
    }
}