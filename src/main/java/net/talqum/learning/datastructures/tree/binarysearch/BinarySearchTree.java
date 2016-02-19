package net.talqum.learning.datastructures.tree.binarysearch;

import net.talqum.learning.datastructures.Node;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    protected Node<T> root;
    protected int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void insert(T data) {
        root = insert(root, data);
        size++;
    }

    /**
     * Inserts a new Node into the tree with the value toInsert.
     * @param p root of a subtree
     * @param toInsert value to be inserted
     * @return the newly inserted Node
     */
    private Node<T> insert(Node<T> p, T toInsert) {
        if (p == null)
            return new Node<>(toInsert);

        if (toInsert.compareTo(p.data) == 0)
            return p;

        if (toInsert.compareTo(p.data) < 0)
            p.left = insert(p.left, toInsert);
        else
            p.right = insert(p.right, toInsert);

        return p;
    }

    public boolean search(T toSearch) {
        return search(root, toSearch);
    }

    /**
     * Searches a value in the tree, returns true if the value is found, false otherwise.
     * @param p root of a subtree
     * @param toSearch value to be looked for
     * @return true if value is found, false otherwise
     */
    private boolean search(Node<T> p, T toSearch) {
        if (p == null)
            return false;
        else if (toSearch.compareTo(p.data) == 0)
            return true;
        else if (toSearch.compareTo(p.data) < 0)
            return search(p.left, toSearch);
        else
            return search(p.right, toSearch);
    }

    public void delete(T toDelete) {
        root = delete(root, toDelete);
        size--;
    }

    /**
     * Deletes a value from the tree.
     * @param p root of a subtree
     * @param toDelete value to be deleted
     * @return p, the root of the subtree
     */
    private Node<T> delete(Node<T> p, T toDelete) {
        if (p == null)
            throw new RuntimeException("cannot remove.");
        else if (toDelete.compareTo(p.data) < 0)
            p.left = delete(p.left, toDelete);
        else if (toDelete.compareTo(p.data) > 0)
            p.right = delete(p.right, toDelete);
        else {
            if (p.left == null) return p.right;
            else if (p.right == null) return p.left;
            else {
                // get data from the rightmost node in the left subtree (inorder precedessor)
                // could be the leftmost node in right subtree, inorder successor
                p.data = retrieveData(p.left);
                // remove the rightmost node in the left subtree (now a duplicate)
                p.left = delete(p.left, p.data);
            }
        }
        return p;
    }

    /**
     * Returns the value of the rightmost Node from p.
     * @param p root of a subtree
     * @return Value of the rightmost Node.
     */
    private T retrieveData(Node<T> p) {
        while (p.right != null)
            p = p.right;

        return p.data;
    }

    public void clear(){
        root = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T data : this)
            sb.append(data.toString());

        return sb.toString();
    }

    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node r) {
        if (r != null) {
            System.out.print(r + " ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node r) {
        if (r != null) {
            inOrderHelper(r.left);
            System.out.print(r + " ");
            inOrderHelper(r.right);
        }
    }

    public void postOrderTraversal() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node r) {
        if (r != null) {
            postOrderHelper(r.left);
            postOrderHelper(r.right);
            System.out.print(r + " ");
        }
    }

    public Iterator<T> iterator() {
        return new BinaryTreeIterator<>(root);
    }

    public int getSize() {
        return size;
    }
}