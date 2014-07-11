package net.talqum.learning.datastructures.linkedlist;

import net.talqum.learning.datastructures.Node;

import java.util.Iterator;

/**
 * Created by Tömösvári Imre on 2014.07.05..
 */
public class ListIterator<T extends Comparable<T>> implements Iterator<T> {

    Node<T> current;

    public ListIterator(Node<T> head){
        current = head;
    }

    @Override
    public boolean hasNext() {
        return current.right != null;
    }

    @Override
    public T next() {
        if(hasNext()){
            current = current.right;
            return current.data;
        }
        return null;
    }
}
