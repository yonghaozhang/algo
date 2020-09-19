package tree;

import org.junit.Test;
import search.BinarySearch2;

import static org.junit.Assert.*;

public class BinarySearchTree2Test {

    @Test
    public void find() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        BinarySearchTree2 tree2 = new BinarySearchTree2();
        tree2.insert(1);
        tree2.insert(3);
        tree2.insert(5);
        tree2.insert(7);
        tree2.insert(9);
        tree2.insert(12);

    }

    @Test
    public void delete() throws Exception {

    }
}