package net.talqum.learning.lang.datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by Imre on 2014.07.07..
 */
public class Stack<E> {

    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public Stack(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Stack(int initialCapacity){
        if(initialCapacity >= 0) {
            elements = new Object[initialCapacity];
        } else {
            elements = new Object[DEFAULT_CAPACITY];
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public void push(E element){
        ensureCapacity();
        elements[size++] = element;
    }

    public E pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        E temp = (E) elements[--size];
        elements[size] = null;
        return temp;
    }

    public E peek(){
        return (E) elements[size-1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
