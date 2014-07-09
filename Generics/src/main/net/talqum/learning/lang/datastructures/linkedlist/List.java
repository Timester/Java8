package net.talqum.learning.lang.datastructures.linkedlist;

/**
 * Created by Tömösvári Imre on 2014.07.05..
 */
public interface List<T extends Comparable<T>> extends Iterable<T> {
    public void add(T toAdd);
    public void addAt(T toAdd, int index);
    public void addAll(List<? extends T> c);
    public T get(int index);
    public void remove(T toDelete);
    public void removeAt(int index);
    public void clear();
    public int size();
    public boolean contains(T toSearch);
    public int indexOf(T element);
}
