package net.talqum.learning.datastructures.tree.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void init(){
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void testInsert() throws Exception {
        assertEquals(0, binarySearchTree.getSize());

        binarySearchTree.insert(4);

        assertEquals(1, binarySearchTree.getSize());
    }

    @Test
    public void testSearch() throws Exception {
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);

        assertTrue(binarySearchTree.search(7));
        assertTrue(!binarySearchTree.search(9));
    }

    @Test
    public void testDelete() throws Exception {
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);

        binarySearchTree.delete(7);

        assertEquals(1, binarySearchTree.getSize());
    }

    @Test
    public void testClear() throws Exception {
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);

        binarySearchTree.clear();

        assertEquals(0, binarySearchTree.getSize());
    }
}