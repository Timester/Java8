package net.talqum.learning.lang.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private List<Integer> lista;

    @Before
    public void init(){
        lista = new LinkedList<>();
    }

    @Test
    public void testAddandSize() throws Exception {
        assertEquals(0, lista.size());
        lista.add(2);
        assertEquals(1, lista.size());
        lista.add(3);
        assertEquals(2, lista.size());
    }

    @Test
    public void testAddAt() throws Exception {
        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);
        lista.add(4);

        lista.addAt(9, 2);

        assertEquals((Integer)4, lista.get(5));
        assertEquals((Integer)3, lista.get(1));
        assertEquals((Integer)9, lista.get(2));
        assertEquals((Integer)1, lista.get(3));

        lista.addAt(7, 0);

        assertEquals((Integer)7, lista.get(0));
        assertEquals((Integer)2, lista.get(1));

        lista.addAt(8, 6);

        assertEquals((Integer)8, lista.get(6));
        assertEquals((Integer)4, lista.get(7));
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testContains() throws Exception {
        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);

        assertTrue(lista.contains(2));
        assertTrue(lista.contains(1));
        assertTrue(lista.contains(6));
    }

    @Test
    public void testIndexOf() throws Exception {
        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);
        lista.add(1);
        lista.add(4);

        assertEquals(0, lista.indexOf(2));
        assertEquals(2, lista.indexOf(1));
        assertEquals(5, lista.indexOf(4));
    }

    @Test
    public void testGet() throws Exception {
        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);
        lista.add(4);

        assertEquals((Integer)2, lista.get(0));
        assertEquals((Integer)1, lista.get(2));
        assertEquals((Integer)4, lista.get(4));
    }
}