package main.datastructures;

import main.utils.Node;

/**
 * Created by Oscar on 08/04/2017.
 * balanced Binary search tree
 * <p>
 * insert -> O(log N),
 * search -> O(log N)
 * remove -> O(log N)
 */
public class AVLTree<K extends Comparable> implements Tree<K> {

    private Node root;

    private Node put(Node node, K value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.getValue().compareTo(value) > 0) {
            node.setLeft(put(node.getLeft(), value));
        } else if (node.getValue().compareTo(value) < 0) {
            node.setRight(put(node.getRight(), value));

        }
        int balance = height(node.getLeft()) - height(node.getRight());
        if (balance > 1) {
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = rotateRight(node);
            } else {
                node.setRight(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateLeft(node.getRight()));
                node = rotateLeft(node);
            }
        } else {
            node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
            node.setSize(size(node.getLeft()) + size(node.getRight()) + 1);
        }
        return node;
    }

    private Node rotateLeft(Node x) {
        Node newRoot = x.getRight();
        x.setRight(newRoot.getLeft());
        newRoot.setLeft(x);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        newRoot.setHeight(Math.max(height(newRoot.getLeft()), height(newRoot.getRight())) + 1);
        return newRoot;
    }


    private Node rotateRight(Node x) {
        Node newRoot = x.getLeft();
        x.setLeft(newRoot.getRight());
        newRoot.setRight(x);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        newRoot.setHeight(Math.max(height(newRoot.getLeft()), height(newRoot.getRight())) + 1);
        return newRoot;
    }


    private int size(Node x) {
        return x == null ? 0 : x.getSize();
    }

    private int height(Node x) {
        return x == null ? -1 : x.getHeight();
    }

    @Override
    public void insert(K k) {
        root = put(root, k);
    }

    @Override
    public boolean search(K k) {
        return find(root, k) != null;
    }

    private Node find(Node x, K k) {
        if (x == null) {
            return null;
        }
        if (x.getValue().equals(k)) {
            return x;
        }
        if (x.getValue().compareTo(k) > 0) {
            return find(x.getLeft(), k);
        } else {
            return find(x.getRight(), k);
        }
    }

    @Override
    public void delete(K k) {

    }

    public Node getRoot() {
        return root;
    }

/*  private class Node {
        K value;
        int height, size;
        Node left, right;

        public Node(K k) {
            this.value = k;
        }
    }*/
}