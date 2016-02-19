package net.talqum.learning.datastructures.list;

public interface List<T extends Comparable<T>> extends Iterable<T> {
    void add(T toAdd);
    void addAt(T toAdd, int index);
    void addAll(List<? extends T> c);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(T toDelete);
    void removeAt(int index);
    void clear();
    int size();
    boolean contains(T toSearch);
    int indexOf(T element);
}
