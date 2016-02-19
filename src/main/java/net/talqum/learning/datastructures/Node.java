package net.talqum.learning.datastructures;

public class Node<T extends Comparable<T>>
{
    public T data;
    public Node<T> left, right;

    public Node(T data, Node<T> l, Node<T> r) {
        left = l;
        right = r;
        this.data = data;
    }

    public Node(T data) {
        this(data, null, null);
    }

    @Override
    public String toString() {
        return data.toString();
    }

}