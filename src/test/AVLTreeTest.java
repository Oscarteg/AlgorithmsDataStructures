package test;

import jdk.nashorn.internal.ir.annotations.Ignore;
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
		assertEquals(this.avlTree.getRoot().getValue(), 25);
		assertEquals(this.avlTree.getRoot().getLeft().getValue(), 10);
		assertEquals(this.avlTree.getRoot().getLeft().getLeft().getValue(), 5);
		assertEquals(this.avlTree.getRoot().getLeft().getRight().getValue(), 15);

		assertEquals(this.avlTree.getRoot().getRight().getValue(), 30);
		assertEquals(this.avlTree.getRoot().getRight().getRight().getValue(), 50);

	}

	@Ignore
	@AfterEach
	public void printTree() {
		TreeTraversals.print(this.avlTree.getRoot());
	}
}
