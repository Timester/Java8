package net.talqum.learning.datastructures.list;

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
        return current != null;
    }

    @Override
    public T next() {
            current = current.right;
            return current.left.data;
    }
}
