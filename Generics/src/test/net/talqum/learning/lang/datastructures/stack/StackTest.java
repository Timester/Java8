package net.talqum.learning.lang.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, stack.size());
        stack.push(12);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testPush() throws Exception {
        stack.push(12);
        assertEquals(1, stack.size());
        assertEquals((Integer)12, stack.pop());

        for(int i=0; i<20; i++){
            stack.push(i);
        }

        assertEquals(20, stack.size());
    }

    @Test
    public void testPop() throws Exception {
        stack.push(12);
        stack.push(7);
        stack.push(36);

        assertEquals(3, stack.size());
        assertEquals((Integer)36, stack.pop());
        assertEquals(2, stack.size());
        assertEquals((Integer)7, stack.pop());
        assertEquals(1, stack.size());
        assertEquals((Integer)12, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmpty() throws Exception {
        stack.pop();
    }

    @Test
    public void testPeek() throws Exception {
        stack.push(2);
        stack.push(3);

        assertEquals((Integer)3, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        stack.push(2);
        assertTrue(!stack.isEmpty());
    }
}