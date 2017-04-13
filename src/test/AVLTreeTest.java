package test;

import main.algorithms.TreeTraversals;
import main.datastructures.AVLTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oscar on 13/04/2017.
 */
public class AVLTreeTest {

    private AVLTree avlTree;

    @BeforeEach
    public void setup() {
        this.avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(25);
        avlTree.insert(30);
        avlTree.insert(50);
    }

    @Test
    public void testAVLTree() {
    }

    @AfterEach
    public void printTree() {
        TreeTraversals.print(this.avlTree.getRoot());
    }
}
