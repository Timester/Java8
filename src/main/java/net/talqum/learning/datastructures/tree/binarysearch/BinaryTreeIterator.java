package net.talqum.learning.datastructures.tree.binarysearch;

import net.talqum.learning.datastructures.Node;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Tömösvári Imre on 2014.07.02..
 */
public class BinaryTreeIterator<T extends Comparable<T>> implements Iterator<T> {

    Stack<Node<T>> nodeStack = new Stack<>();

    public BinaryTreeIterator(Node<T> root) {
        if (root != null) nodeStack.push(root);
    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    public T next() {
        Node<T> cur = nodeStack.peek();
        if (cur.left != null) {
            nodeStack.push(cur.left);
        } else {
            Node<T> tmp = nodeStack.pop();
            while (tmp.right == null) {
                if (nodeStack.isEmpty())
                    return cur.data;
                tmp = nodeStack.pop();
            }
            nodeStack.push(tmp.right);
        }

        return cur.data;
    }

    public void remove() {
        //TODO  write  this
    }
}
