package net.talqum.learning.datastructures.list;

import java.util.Iterator;

public class ArrayList<T extends Comparable<T>> implements List<T> {

    public static final int INITIAL_CAPACITY = 256;
    private Object[] elements;
    private int size = 0;

    public ArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public ArrayList(int initialSize) {
        this.elements = new Object[initialSize];
    }

    @Override
    public void add(T toAdd) {
        elements[size] = toAdd;
        size++;
    }

    @Override
    public void addAt(T toAdd, int index) {
        if(checkIndex(index)){
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = toAdd;
            size++;
        }
        else{
            throw new IndexOutOfBoundsException("List is shorter than " + index);
        }
    }

    @Override
    public void addAll(List<? extends T> c) {
        for (T t : c) {
            add(t);
        }
    }

    @Override
    public T get(int index) {
        if(checkIndex(index)) {
            return (T) elements[index];
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T getFirst() {
        if(size > 0){
            return (T)elements[0];
        }
        else{
            return null;
            //throw new IndexOutOfBoundsException("List is empty");
        }
    }

    @Override
    public T getLast() {
        if(size > 0){
            return (T)elements[size-1];
        }
        else{
            return null;
           // throw new IndexOutOfBoundsException("List is empty");
        }
    }

    @Override
    public void remove(T toDelete) {
        for (int i=0; i< size; i++) {
            if(((T)elements[i]).equals(toDelete)){
                System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                size--;
            }
        }
    }

    @Override
    public void removeAt(int index) {
        if(checkIndex(index)){
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            size--;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T toSearch) {
        for (int i=0; i< size; i++) {
            if(((T)elements[i]).equals(toSearch)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        for (int i=0; i< size; i++) {
            if(((T)elements[i]).equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }
}
