package net.talqum.learning.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListTest {

    private List<Integer> lista;

    @Rule
    public ExpectedException exception = ExpectedException.none();


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
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        lista.removeAt(4);
        lista.removeAt(2);
        lista.removeAt(0);

        assertEquals((Integer)1, lista.get(0));
        assertEquals((Integer)3, lista.get(1));
        assertEquals(2, lista.size());

        lista.remove(1);
        assertEquals((Integer)3, lista.get(0));
        assertEquals(1, lista.size());

        lista.remove(14);
        assertEquals(1, lista.size());
    }

    @Test
    public void testRemoveException() throws Exception {
        exception.expect(IndexOutOfBoundsException.class);
        lista.remove(2);
        exception.expect(IndexOutOfBoundsException.class);
        lista.removeAt(0);

        lista.add(2);
        exception.expect(IndexOutOfBoundsException.class);
        lista.removeAt(1);
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

        exception.expect(IndexOutOfBoundsException.class);
        lista.get(5);
    }

    @Test
    public void testGetFirstGetLast(){
        assertNull(lista.getFirst());
        assertNull(lista.getLast());

        lista.add(2);
        lista.add(3);
        lista.add(1);
        lista.add(6);

        assertEquals((Integer)2, lista.getFirst());
        assertEquals((Integer)6, lista.getLast());
    }

    @Test
    public void testClear() throws Exception {
        lista.add(2);
        lista.add(5);
        assertEquals(2, lista.size());

        lista.clear();
        assertEquals(0, lista.size());
    }

    @Test
    public void testIterator() throws Exception {
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);

        Iterator<Integer> iter = lista.iterator();

        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        iter.next();
        assertEquals((Integer)6, iter.next());
        assertFalse(iter.hasNext());
    }
}