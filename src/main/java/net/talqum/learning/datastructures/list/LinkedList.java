package net.talqum.learning.datastructures.list;

import net.talqum.learning.datastructures.Node;

import java.util.Iterator;

/**
 * Created by Tömösvári Imre on 2014.07.05..
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    @Override
    public void add(T toAdd) {
        if(head == null){
            head = new Node<>(toAdd, null, null);
        } else {
            Node<T> temp = head;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = new Node<>(toAdd, temp, null);
        }
        size++;
    }

    @Override
    public void addAt(T toAdd, int index) {
        if(head == null){
            head = new Node<>(toAdd, null, null);
        }
        else if(!checkIndex(index)){
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> temp = head;
            for(int i=0; i < index; i++){
                temp = temp.right;
            }

            Node<T> newNode = new Node<>(toAdd, temp.left, temp);

            if(temp.left != null){
                temp.left.right = newNode;
                temp.left = newNode;
            } else {
                temp.left = newNode;
                head = newNode;
            }
            size++;
        }
    }

    @Override
    public void addAll(List<? extends T> c) {
        for(T a : c){
            add(a);
        }
    }

    @Override
    public void remove(T toDelete) {
        if(head == null){
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> temp = head;
            while (temp.right != null) {
                if (temp.data.equals(toDelete)) {
                    if (temp.left != null && temp.right != null) {
                        temp.left.right = temp.right;
                        temp.right.left = temp.left;
                    } else if (temp.left != null && temp.right == null) {   // last
                        temp.left.right = null;
                    } else if (temp.left == null && temp.right != null) {   // first
                        temp.right.left = null;
                        head = temp.right;
                    } else {
                        head = null;
                    }

                    size--;
                    return;
                }
            }
        }
    }

    @Override
    public void removeAt(int index) {
        if(head == null){
            throw new IndexOutOfBoundsException();
        } else if(!checkIndex(index)){
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.right;
            }

            if (temp.left != null && temp.right != null) {  // middle
                temp.left.right = temp.right;
                temp.right.left = temp.left;
            } else if (temp.left != null && temp.right == null) {   // last
                temp.left.right = null;
            } else if (temp.left == null && temp.right != null) {   // first
                temp.right.left = null;
                head = temp.right;
            } else {
                head = null;
            }

            size--;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T toSearch) {
        Node<T> temp = head;
        while(temp != null) {
            if(temp.data.equals(toSearch)){
                return true;
            }
            temp = temp.right;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        int idx = 0;

        Node<T> temp = head;
        while(temp != null) {
            if(temp.data.equals(element)){
                return idx;
            }
            temp = temp.right;
            idx++;
        }

        return -1;
    }

    @Override
    public T get(int index) {
        if(head == null){
            return null;
        } else if(!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.right;
            }
            return temp.data;
        }
    }

    @Override
    public T getFirst() {
        if(head != null){
            return head.data;
        } else{
            return null;
        }
    }

    @Override
    public T getLast() {
        if(head != null){
            Node<T> temp = head;
            for (int i = 0; i < size-1; i++) {
                temp = temp.right;
            }
            return temp.data;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }


    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }
}
