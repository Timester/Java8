package net.talqum.learning.datastructures.list;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ArrayListTest {

    private List<Integer> list;

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void init(){
        list = new ArrayList<>();
    }

    @Test
    public void testAddandSize() throws Exception {
        assertEquals(0, list.size());
        list.add(2);
        assertEquals(1, list.size());
        list.add(3);
        assertEquals(2, list.size());
    }

    @Test
    public void testAddAt() throws Exception {
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(4);

        list.addAt(9, 2);

        assertEquals((Integer)4, list.get(5));
        assertEquals((Integer)3, list.get(1));
        assertEquals((Integer)9, list.get(2));
        assertEquals((Integer)1, list.get(3));

        list.addAt(7, 0);

        assertEquals((Integer)7, list.get(0));
        assertEquals((Integer)2, list.get(1));

        list.addAt(8, 6);

        assertEquals((Integer)8, list.get(6));
        assertEquals((Integer)4, list.get(7));
    }
/*
    @Test
    public void testAddAll() throws Exception {
        list.add(2);
        list.add(3);
        list.add(1);

        List<Integer> lista2 = new ArrayList<>();

        lista2.addAll(list);

        assertEquals((Integer)2 ,lista2.get(0));
        assertEquals((Integer)1 ,lista2.get(2));

        assertEquals(3 ,lista2.size());
    }
*/
    @Test
    public void testRemove() throws Exception {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeAt(4);
        list.removeAt(2);
        list.removeAt(0);

        assertEquals((Integer)1, list.get(0));
        assertEquals((Integer)3, list.get(1));
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals((Integer)3, list.get(0));
        assertEquals(1, list.size());

        list.remove(14);
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveException() throws Exception {
        exception.expect(IndexOutOfBoundsException.class);
        list.remove(2);
        exception.expect(IndexOutOfBoundsException.class);
        list.removeAt(0);

        list.add(2);
        exception.expect(IndexOutOfBoundsException.class);
        list.removeAt(1);
    }

    @Test
    public void testContains() throws Exception {
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);

        assertTrue(list.contains(2));
        assertTrue(list.contains(1));
        assertTrue(list.contains(6));
    }

    @Test
    public void testIndexOf() throws Exception {
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(1);
        list.add(4);

        assertEquals(0, list.indexOf(2));
        assertEquals(2, list.indexOf(1));
        assertEquals(5, list.indexOf(4));
    }

    @Test
    public void testGet() throws Exception {
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(4);

        assertEquals((Integer) 2, list.get(0));
        assertEquals((Integer)1, list.get(2));
        assertEquals((Integer) 4, list.get(4));

        exception.expect(IndexOutOfBoundsException.class);
        list.get(5);
    }

    @Test
    public void testGetFirstGetLast(){
        assertNull(list.getFirst());
        assertNull(list.getLast());

        list.add(2);
        list.add(3);
        list.add(1);
        list.add(6);

        assertEquals((Integer) 2, list.getFirst());
        assertEquals((Integer) 6, list.getLast());
    }

    @Test
    public void testClear() throws Exception {
        list.add(2);
        list.add(5);
        assertEquals(2, list.size());

        list.clear();
        assertEquals(0, list.size());
    }
/*
    @Test
    public void testIterator() throws Exception {
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Iterator<Integer> iter = list.iterator();

        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        iter.next();
        assertEquals((Integer)5, iter.next());
        assertTrue(iter.hasNext());
        iter.next();
        assertFalse(iter.hasNext());

        int size = 0;
        for(int i : list){
            size++;
        }

        assertEquals(5, size);
    }
    */
}