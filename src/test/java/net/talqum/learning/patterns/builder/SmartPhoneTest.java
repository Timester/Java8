package net.talqum.learning.patterns.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmartPhoneTest {

    @Test
    public void testBuilder(){
        SmartPhone sp = new SmartPhone.Builder(123456L)
                .manufacturer("Samsung")
                .name("Galaxy")
                .build();

        assertEquals(123456L, sp.getId());
        assertEquals("Samsung", sp.getManufacturer());
        assertEquals("Galaxy", sp.getName());
        assertEquals(200, sp.getPrice(), 0);
        assertEquals(5.0f, sp.getScreenSize(), 0);
    }

}