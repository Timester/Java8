package net.talqum.learning.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void init(){
        queue = new Queue<>();
    }

    @Test
    public void testSize() throws Exception {
        queue.enqueue(1);
        assertEquals(1, queue.size());
    }

    @Test
    public void testEnqueue() throws Exception {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());

        assertEquals((Integer)1, queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals((Integer)2, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals((Integer)3, queue.dequeue());
        assertEquals(0, queue.size());

        assertNull(queue.dequeue());
        assertEquals(0, queue.size());
    }
}