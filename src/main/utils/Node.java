package main.utils;

/**
 * Created by Oscar on 08/04/2017.
 */
public class Node<K extends Comparable> {
    private K value;
    private int height;
    private int size;
    private Node left;
    private Node right;

    public Node(K k) {
        this.value = k;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
