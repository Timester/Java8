package net.talqum.learning.lang.datastructures.linkedlist;

import net.talqum.learning.lang.datastructures.Node;

import java.util.Iterator;

/**
 * Created by Tömösvári Imre on 2014.07.05..
 */
public class LinkedList<T extends Comparable<T>> implements List<T>, Iterable<T> {

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
        }
        else {
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
        else {
            if(index >= size){
                throw new IndexOutOfBoundsException();
            }

            Node<T> temp = head;
            for(int i=0; i < index; i++){
                temp = temp.right;
            }

            Node<T> newNode = new Node<>(toAdd, temp.left, temp);

            if(temp.left != null){
                temp.left.right = newNode;
                temp.left = newNode;
            }
            else{
                temp.left = newNode;
                head = newNode;
            }

        }

        size++;
    }

    @Override
    public void addAll(List<? extends T> c) {

    }

    @Override
    public void remove(T toDelete) {
        Node<T> temp = head;
        while(temp.right != null) {
            if(temp.data.equals(toDelete)){
                if(temp.left != null && temp.right != null){
                    temp.left.right = temp.right;
                    temp.right.left = temp.left;
                }
                else if(temp.left != null && temp.right == null){   // last
                    temp.left.right = null;
                }
                else if(temp.left == null && temp.right != null){   // first
                    temp.right.left = null;
                    head = temp.right;
                }

                size--;
                return;
            }
        }
    }

    @Override
    public void remove(int index) {
        Node<T> temp = head;
        for(int i = 1; i < index; i++){
            if(temp.right != null) {
                temp = temp.right;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        if(temp.left != null && temp.right != null){
            temp.left.right = temp.right;
            temp.right.left = temp.left;
        }
        else if(temp.left != null && temp.right == null){   // last
            temp.left.right = null;
        }
        else if(temp.left == null && temp.right != null){   // first
            temp.right.left = null;
            head = temp.right;
        }

        size--;
        return;
    }

    @Override
    public void clear() {
        head.right = null;
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
        Node<T> temp = head;
        for(int i = 0; i < index; i++){
            if(temp.right != null) {
                temp = temp.right;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return temp.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }
}
