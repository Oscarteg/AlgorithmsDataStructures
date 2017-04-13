package main.datastructures;

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
        if (node.value.compareTo(value) > 0) {
            node.left = put(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = put(node.right, value);

        }
        int balance = height(node.left) - height(node.right);
        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateLeft(node.right);
                node = rotateLeft(node);
            }
        } else {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            node.size = size(node.left) + size(node.right) + 1;
        }
        return node;
    }

    private Node rotateLeft(Node x) {
        Node newRoot = x.right;
        x.right = newRoot.left;
        newRoot.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }


    private Node rotateRight(Node x) {
        Node newRoot = x.left;
        x.left = newRoot.right;
        newRoot.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;
        return newRoot;
    }


    private int size(Node x) {
        return x == null ? 0 : x.size;
    }

    private int height(Node x) {
        return x == null ? -1 : x.height;
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
        if (x.value.equals(k)) {
            return x;
        }
        if (x.value.compareTo(k) > 0) {
            return find(x.left, k);
        } else {
            return find(x.right, k);
        }
    }

    @Override
    public void delete(K k) {

    }

    private class Node {
        K value;
        int height, size;
        Node left, right;

        public Node(K k) {
            this.value = k;
        }
    }
}