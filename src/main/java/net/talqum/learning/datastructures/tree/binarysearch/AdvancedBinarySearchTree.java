package net.talqum.learning.datastructures.tree.binarysearch;

import net.talqum.learning.datastructures.Node;

public class AdvancedBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T>
{

    public BinarySearchTree<T> clone() throws CloneNotSupportedException {
        BinarySearchTree<T> twin = new BinarySearchTree<>();
        twin.root = cloneHelper(root);
        return twin;
    }

    private Node<T> cloneHelper(Node<T> p) {
        if (p == null)
            return null;
        else
            return new Node<>(p.data, cloneHelper(p.left), cloneHelper(p.right));
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> p) {
        if (p == null) return -1;
        else
            return 1 + Math.max(height(p.left), height(p.right));
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<T> p) {
        if (p == null) return 0;
        else if (p.left == null && p.right == null) return 1;
        else
            return countLeaves(p.left) + countLeaves(p.right);
    }


    //This method restores a BST given preorder and inorder traversals
    public void restore(T[] pre, T[] in) {
        root = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private Node<T> restore(T[] pre, int preL, int preR, T[] in, int inL, int inR) {
        if (preL <= preR) {
            int count = 0;
            //find the root in the inorder array
            while (pre[preL] != in[inL + count]) count++;

            Node<T> tmp = new Node<>(pre[preL]);
            tmp.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
            tmp.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
            return tmp;
        } else
            return null;
    }


    //The width of a binary tree is the maximum number of elements on one level of the tree.
    public int width() {
        int max = 0;
        for (int k = 0; k <= height(); k++) {
            int tmp = width(root, k);
            if (tmp > max) max = tmp;
        }
        return max;
    }

    //returns the number of node on a given level
    public int width(Node<T> p, int depth) {
        if (p == null) return 0;
        else if (depth == 0) return 1;
        else
            return width(p.left, depth - 1) + width(p.right, depth - 1);
    }

    //The diameter of a tree is the number of nodes
    //on the longest path between two leaves in the tree.
    public int diameter() {
        return diameter(root);
    }

    private int diameter(Node<T> p) {
        if (p == null) return 0;

        //the path goes through the root
        int len1 = height(p.left) + height(p.right) + 3;

        //the path does not pass the root
        int len2 = Math.max(diameter(p.left), diameter(p.right));

        return Math.max(len1, len2);
    }

}
