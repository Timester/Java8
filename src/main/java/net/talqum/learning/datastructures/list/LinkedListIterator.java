package net.talqum.learning.datastructures.list;

import net.talqum.learning.datastructures.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

    private Node<T> current;
    private Node<T> temp;
    private int position = 0;

    public LinkedListIterator(Node<T> head){
        current = head;
    }

    @Override
    public boolean hasNext() {
        if(current == null){
            return temp.right != null;
        }
        else{
            return true;
        }
    }

    public boolean hasPrevious(){
        if(current == null){
            return temp != null;
        }
        else{
            return current.left != null;
        }
    }

    @Override
    public T next() {
        if(current == null){
            throw new NoSuchElementException();
        }
        else{
            T ret = current.data;
            if (current.right == null) {
                temp = current;
            }
            current = current.right;
            position++;
            return ret;
        }
    }

    public T previous(){
        T ret;
        if(current == null){
            current = temp;
            temp = null;
            ret = current.data;
        }
        else {
            if (current.left == null) {
                throw new NoSuchElementException();
            } else {
                ret = current.left.data;
                current = current.left;
            }
        }

        position--;
        return ret;
    }

    public int nextIndex(){
        if (hasNext()){
            return position;
        }
        else{
            return position;
        }
    }

    public int previousIndex(){
        if (hasPrevious()){
            return position-1;
        }
        else{
            return -1;
        }
    }
}
