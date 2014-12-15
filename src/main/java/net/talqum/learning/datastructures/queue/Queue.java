package net.talqum.learning.datastructures.queue;

import net.talqum.learning.datastructures.list.*;

/**
 * Created by Imre on 2014.07.08..
 */
public class Queue<E extends Comparable<E>> {

    private List<E> elements;
    private int size;

    public Queue(){
        elements = new LinkedList<>();
        size = 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(E element){
        elements.add(element);
        size++;
    }

    public E dequeue(){
        E temp = elements.getFirst();
        try {
            elements.removeAt(0);
        } catch(IndexOutOfBoundsException e){
            return temp;
        }
        size--;
        return temp;
    }

}
